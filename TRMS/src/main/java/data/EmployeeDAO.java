package data;

import TRMS.Employee;

import java.util.List;

public interface EmployeeDAO  {
    public List<Employee> getByFirstName(String firstName);
    public List<Employee> getByLastName(String lastName);
    public List<Employee> getById(int employeeId);
    public List<Employee> getByDept(int deptId);
    public List<Employee> getByManager(int managerId);
    public List<Employee> getAll();
    // public int create(Employee employee);
}
