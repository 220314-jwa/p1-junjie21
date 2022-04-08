package SPMS;

public class Status {
    private int status_id;
    private String status_name;

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
}
