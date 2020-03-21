package nl.utwente.soa.digital.testing.location.rest;

import nl.utwente.soa.digital.testing.location.Location;
import nl.utwente.soa.digital.testing.location.ScheduleItem;
import nl.utwente.soa.digital.testing.location.ScheduleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class LocationRestController {

    @Autowired private ScheduleItemService service;

    @GetMapping(path="/location")
        public List<Location> getLocations() {
            System.out.println("GetMapping was called");
            return service.getAvailableLocations();
    }

    @PostMapping(path="/location/claim")
    public ScheduleItem createItem(@RequestBody ScheduleItem item) {
        //check if there exists a location with this name
        service.createScheduleItem(item);
        System.out.println(item.getLocation().getName());
        return item;
    }
}
