package nl.utwente.soa.digital.testing.location;

import nl.utwente.soa.digital.testing.location.dao.Location;
import nl.utwente.soa.digital.testing.location.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitLocations {
    @Autowired private LocationService service;

    @PostConstruct
    public void init() {
        service.createLocation(new Location("Therm", 250));
        service.createLocation(new Location("NH115", 75));
        service.createLocation(new Location("NH124", 75));
    }
}
