package nl.utwente.soa.digital.testing.location.dao;

import java.util.Date;

public class ScheduleItem {
    private Location location;
    private Date date;

    public ScheduleItem(Location location, Date date) {
        this.location = location;
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
