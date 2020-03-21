package nl.utwente.soa.digital.testing.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public List<Location> getAvailableLocations() {
        return service.getLocationList();
    }
}
