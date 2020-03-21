package nl.utwente.soa.digital.testing.location;

public class Location {
    private String name;
    private Integer nrOfSeats;

    public Location(String name, Integer nrOfSeats) {
        this.name = name;
        this.nrOfSeats = nrOfSeats;
    }

    public String getName() {
        return name;
    }

    public Integer getNrOfSeats() {
        return nrOfSeats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNrOfSeats(Integer nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

}
