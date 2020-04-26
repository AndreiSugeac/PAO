package System.Services;

import System.Model.Event;

public class EventServices extends Services {

    public int insertEvent(Event event) {
        return getDataBase().addEvent(event);
    }

    public Event getEventByName(String name) {
        return getDataBase().getEventByName(name).get();
    }

    public int deleteEventByName(String Name) {
        return getDataBase().deleteEventByName(Name);
    }
}
