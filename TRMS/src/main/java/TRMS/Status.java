package TRMS;

import java.util.Objects;

public class Status {
    private int status_id;
    private String status_name;

    // default constructor
    public Status(){
        status_id = 0;
        status_name = "";
    }
    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public int getStatus_id() {
        return status_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Status status = (Status) o;
        return status_id == status.status_id && Objects.equals(status_name, status.status_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), status_id, status_name);
    }

    @Override
    public String toString() {
        return "Status{" +
                "status_id=" + status_id +
                ", status_name='" + status_name + '\'' +
                '}';
    }
}
