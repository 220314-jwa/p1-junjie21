package data;

import TRMS.Event_type;

import java.awt.*;

public interface EventDAO extends GenericDAO<Event_type>{
    public Event_type getByName(String event_name);
}
