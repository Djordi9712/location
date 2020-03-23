package nl.utwente.soa.digital.testing.location.services;

import nl.utwente.soa.digital.testing.location.dao.Location;
import nl.utwente.soa.digital.testing.location.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LocationService {
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
}
