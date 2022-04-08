package TRMS;

import java.util.Objects;

public class Event_type {
    private int event_type_id;
    private String event_type_name;

    public Event_type (){
        event_type_id = 0;
        event_type_name = "";
    }

    public void setEvent_type_name(String event_type_name) {
        this.event_type_name = event_type_name;
    }

    public void setEvent_type_id(int event_type_id) {
        this.event_type_id = event_type_id;
    }

    public String getEvent_type_name() {
        return event_type_name;
    }

    public int getEvent_type_id() {
        return event_type_id;
    }

    @Override
    public String toString() {
        return "Event_type{" +
                "event_type_id=" + event_type_id +
                ", event_type_name='" + event_type_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Event_type that = (Event_type) o;
        return event_type_id == that.event_type_id && Objects.equals(event_type_name, that.event_type_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), event_type_id, event_type_name);
    }
}
