package Backend.System.Services;

import Backend.System.Model.Event;

public class EventServices extends Services {

    public int insertEvent(Event event) {
        return getDataBase().addEvent(event);
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
