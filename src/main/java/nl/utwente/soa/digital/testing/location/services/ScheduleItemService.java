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

}
