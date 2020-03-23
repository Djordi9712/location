package nl.utwente.soa.digital.testing.location.rest;

import nl.utwente.soa.digital.testing.location.dao.Location;
import nl.utwente.soa.digital.testing.location.exceptions.NotFoundException;
import nl.utwente.soa.digital.testing.location.services.LocationService;
import nl.utwente.soa.digital.testing.location.dao.ScheduleItem;
import nl.utwente.soa.digital.testing.location.services.ScheduleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class LocationRestController {

    @Autowired
    private LocationService locService;
    @Autowired
    private ScheduleItemService service;

    @GetMapping(path = "/location")
    public Location getLocations(@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam(name = "seats") Integer nrOfSeats) {
        System.out.println("GetMapping was called");
        return service.getAvailableLocation(date, nrOfSeats);
    }

    @PostMapping(path = "/location/claim")
    public ScheduleItem createItem(@RequestBody ScheduleItem item) {
        /**Retrieve the specified location object if available */
        Location location = locService.retrieveLocation(item.getLocation());
        item.setLocation(location);
        if (service.isAvailable(location, item.getDate())) {
            service.createScheduleItem(item);
            return item;
        }
        throw new NotFoundException("The location is unavailable at the specified timeslot");
    }
}

