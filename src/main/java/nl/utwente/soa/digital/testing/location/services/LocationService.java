package nl.utwente.soa.digital.testing.location.services;

import nl.utwente.soa.digital.testing.location.dao.Location;
import nl.utwente.soa.digital.testing.location.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private ScheduleItemService service;

    public static List<Location> locationList = new ArrayList<Location>();

    public static List<Location> getLocationList() {
        return locationList;
    }

    public void createLocation(Location location) {
        locationList.add(location);
    }

    public Location retrieveLocation(Location location) {
        Location loc = locationList.stream()
                .filter(loca -> loca.equals(location))
                .findAny()
                .orElseThrow(() -> new NotFoundException("The location has not been found"));

        System.out.println(location.toString());

        return loc;
    }

    public Location getAvailableLocation(Date date, Integer nrOfSeats) {
        System.out.println("Date" + date);
        System.out.println(service.getSchedule());
        /** Retrieve all Locations with sufficient seats */
        List<Location> SuitableLocations = getLocationList()
                .stream()
                .filter(location -> location.getNrOfSeats() >= nrOfSeats)
                .collect(Collectors.toList());

        if (SuitableLocations.isEmpty()) {
            throw new NotFoundException("There is no location with enough seats");
        }

        List<Location> AvailableLocations = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        /** Check if the location is already reserved  */
        for (Location location : SuitableLocations) {
            System.out.println();
            if (!service.getSchedule().stream()
                    .filter(item -> item.getLocation().equals(location)
                            && dateFormat.format(item.getDate()).equals(dateFormat.format(date))).findAny().isPresent()) {
                AvailableLocations.add(location);
            }
        }
        System.out.println(AvailableLocations.size());
        return AvailableLocations.stream().findFirst().orElseThrow(() -> new NotFoundException("There is no location available at this date with enough seats, please try another date"));
    }

}
