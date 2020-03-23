package nl.utwente.soa.digital.testing.location.services;

import nl.utwente.soa.digital.testing.location.dao.Location;
import nl.utwente.soa.digital.testing.location.dao.ScheduleItem;
import nl.utwente.soa.digital.testing.location.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleItemService {
    public static List<ScheduleItem> schedule = new ArrayList<>();
    @Autowired
    private LocationService service;

    public static void createScheduleItem(ScheduleItem item) {
        schedule.add(item);
        System.out.println(schedule);
    }

    public static List<ScheduleItem> getSchedule() {
        return schedule;
    }

    public boolean isAvailable(Location location, Date date) {
        return ! schedule.stream().filter(item -> item.getDate().equals(date) && item.getLocation().equals(location)).findAny().isPresent();
    }

    public Location getAvailableLocation(Date date, Integer nrOfSeats) {
        System.out.println("Date" + date);
        /** Retrieve all Locations with sufficient seats */
        List<Location> SuitableLocations = service.getLocationList()
                .stream()
                .filter(location -> location.getNrOfSeats() >= nrOfSeats)
                .collect(Collectors.toList());

        List<Location> AvailableLocations = new ArrayList<>();

        /** Check if the location is already reserved  */
        for (Location location : SuitableLocations) {
            if (!schedule.stream().filter(item -> item.getLocation().equals(location) && item.getDate().equals(date)).findAny().isPresent()) {
                AvailableLocations.add(location);
            }
        }
        System.out.println(AvailableLocations.size());
        return AvailableLocations.stream().findFirst().orElseThrow(() -> new NotFoundException("There is no location with enough seats"));
    }
}
