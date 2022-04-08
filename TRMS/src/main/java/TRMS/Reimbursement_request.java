package TRMS;

import javafx.scene.input.DataFormat;

import java.util.Date;
import java.util.Objects;

public class Reimbursement_request {
    private int request_id;
    private int event_type_id;
    private int cost;
    private String description;
    private String location;
    private Date event_date;
    private Date submitted_at;


    // default constructor
    public Reimbursement_request() {
        request_id = 0;
        event_type_id = 0;
        cost = 0;
        description = "";
        location = "";
        event_date = new Date();
        submitted_at = new Date();
    }


    public void setSubmitted_at(Date submitted_at) {
        this.submitted_at = submitted_at;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public Date getSubmitted_at() {
        return submitted_at;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(int cost) {

        this.cost = cost;
    }

    public void setEvent_type_id(int event_type_id) {
        this.event_type_id = event_type_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public int getEvent_type_id() {
        return event_type_id;
    }

    public int getRequest_id() {
        return request_id;
    }

    // print method
    @Override
    public String toString() {
        return "Reimbursement_request{" +
                "request_id=" + request_id +
                ", event_type_id=" + event_type_id +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", event_date=" + event_date +
                ", submitted_at=" + submitted_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement_request that = (Reimbursement_request) o;
        return request_id == that.request_id && event_type_id == that.event_type_id && cost == that.cost && Objects.equals(description, that.description) && Objects.equals(location, that.location) && Objects.equals(event_date, that.event_date) && Objects.equals(submitted_at, that.submitted_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request_id, event_type_id, cost, description, location, event_date, submitted_at);
    }

}
