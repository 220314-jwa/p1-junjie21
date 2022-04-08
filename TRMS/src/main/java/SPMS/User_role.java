package SPMS;

public class User_role extends Person{
    private String role_name;
    private int role_id;

    @Override
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public int getRole_id() {
        return role_id;
    }

    public String getRole_name() {
        return role_name;
    }
}
