package TRMS;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int manager_id;
    private int dept_id;
    private int employee_id;
    private String username;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    // constructor default all the values
    public Employee(){
        firstName = "";
        lastName = "";
        manager_id = 0;
        employee_id = 0;
        dept_id = 0;
        username = "";
        password = "";
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getManager_id() {
        return manager_id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", manager_id=" + manager_id +
                ", dept_id=" + dept_id +
                ", employee_id=" + employee_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return manager_id == employee.manager_id && dept_id == employee.dept_id && employee_id == employee.employee_id && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(username, employee.username) && Objects.equals(password, employee.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, manager_id, dept_id, employee_id, username, password);
    }
}
