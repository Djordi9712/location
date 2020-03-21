package nl.utwente.soa.digital.testing.location;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    public static List<Location> locationList = new ArrayList<Location>();

    public static List<Location> getLocationList() {
        return locationList;
    }

    public void createLocation(Location location) {
        locationList.add(location);
    }
}
