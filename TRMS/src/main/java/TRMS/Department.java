package TRMS;

import java.util.Objects;

public class Department {
    private int dept_id;
    private int head_id;
    private String dept_name;

    public Department(){
        dept_id = 0;
        head_id = 0;
        dept_name = "";
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public void setHead_id(int head_id) {
        this.head_id = head_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public int getHead_id() {
        return head_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_id=" + dept_id +
                ", head_id=" + head_id +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Department that = (Department) o;
        return dept_id == that.dept_id && head_id == that.head_id && Objects.equals(dept_name, that.dept_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dept_id, head_id, dept_name);
    }


}
