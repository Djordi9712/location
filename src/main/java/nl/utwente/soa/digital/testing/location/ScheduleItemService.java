package nl.utwente.soa.digital.testing.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleItemService {
    public static List<ScheduleItem> schedule = new ArrayList<>();
    @Autowired private LocationService service;

    public static void createScheduleItem(ScheduleItem item) {
        schedule.add(item);
        System.out.println(schedule);
    }

    public static List<ScheduleItem> getSchedule() {
        return schedule;
    }

    public Location getAvailableLocation(Date date, Integer nrOfSeats) {
        List<Location> SuitableLocations = service.getLocationList()
                                                  .stream()
                                                  .filter(location -> location.getNrOfSeats() >= nrOfSeats)
                                                  .collect(Collectors.toList());
        return SuitableLocations.get(0);
    }

//        Location availableLocation = SuitableLocations.stream().filter(location -> schedule.co
}
