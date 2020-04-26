package System.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Event {
    private String nameEvent;
    private String date;
    private int startingHour;
    private int duration; // in minutes
    private Location location;

    private static List<Event> events = new ArrayList<Event>();

    public Event(String nameEvent, String date, int startingHour, int duration, Location location) {
        this.nameEvent = nameEvent;
        this.date = date;
        this.startingHour = startingHour;
        this.duration = duration;
        this.location = new Location(location.getCountry(), location.getCity(), location.getVenue());
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public String getDate() {
        return date;
    }


    public int getStartingHour() {
        return startingHour;
    }

    public int getDuration() {
        return duration;
    }

    public Location getLocation() {
        return location;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStartingHour(int startingHour) {
        this.startingHour = startingHour;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
                ", duration=" + duration + " min" +
                ", location=" + location.toString() +
                '}';
    }

    public String toStringCsv() {
        return "" + nameEvent +
                "," + date +
                "," +  startingHour +
                "," + duration +
                "," + location.toStringCsv();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return startingHour == event.startingHour &&
                duration == event.duration &&
                Objects.equals(nameEvent, event.nameEvent) &&
                Objects.equals(date, event.date) &&
                Objects.equals(location, event.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameEvent, date, startingHour, duration, location);
    }
}
