package data;

import TRMS.Event_type;

import java.awt.*;

public interface EventDAO {
    public Event_type getById(Event_type event_type_id);
    public Event_type getByName(Event_type event_name);
}
