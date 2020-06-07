package Backend.System.Services;

import Backend.System.Model.Event;

import java.util.List;

public class EventServices extends Services {

    public int insertEvent(Event event) {
        return getDataBase().addEvent(event);
    }

    public List<Event> getEvents() {
        return getPostgres().getAllEvents();
    }

    public Event getEventByName(String name) {
        if(getPostgres().getEventByName(name).isPresent())
            return getPostgres().getEventByName(name).get();
        else return null;
    }

    public int deleteEventByName(String Name) {
        return getDataBase().deleteEventByName(Name);
    }
}
