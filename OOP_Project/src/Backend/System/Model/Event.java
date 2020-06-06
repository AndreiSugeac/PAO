package Backend.System.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Event {
    private UUID event_id;
    private String nameEvent;
    private LocalDate date;
    private LocalTime startingHour;
    private Location location;

    private static List<Event> events = new ArrayList<Event>();

    public Event(UUID event_id, String nameEvent, LocalDate date, LocalTime startingHour, Location location) {
        this.event_id = event_id;
        this.nameEvent = nameEvent;
        this.date = date;
        this.startingHour = startingHour;
        this.location = new Location(location.getCountry(), location.getCity(), location.getVenue());
    }

    public Event(String nameEvent, LocalDate date, LocalTime startingHour, Location location) {
        this.event_id = UUID.randomUUID();
        this.nameEvent = nameEvent;
        this.date = date;
        this.startingHour = startingHour;
        this.location = new Location(location.getCountry(), location.getCity(), location.getVenue());
    }

    public UUID getEvent_id() {
        return event_id;
    }

    public void setEvent_id(UUID event_id) {
        this.event_id = event_id;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public LocalDate getDate() {
        return date;
    }


    public LocalTime getStartingHour() {
        return startingHour;
    }

    public Location getLocation() {
        return location;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartingHour(LocalTime startingHour) {
        this.startingHour = startingHour;
    }

    public void setLocation(Location location) {
        this.location = new Location(location.getCountry(), location.getCity(), location.getVenue());
    }

    @Override
    public String toString() {
        return "Event{" +
                "nameEvent='" + nameEvent + '\'' +
                ", date='" + date + '\'' +
                ", startingHour=" + startingHour +
                ", location=" + location.toString() +
                '}';
    }

    public String toStringCsv() {
        return "" + nameEvent +
                "," + date +
                "," +  startingHour +
                "," + location.toStringCsv();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return startingHour == event.startingHour &&
                Objects.equals(nameEvent, event.nameEvent) &&
                Objects.equals(date, event.date) &&
                Objects.equals(location, event.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameEvent, date, startingHour, location);
    }
}
