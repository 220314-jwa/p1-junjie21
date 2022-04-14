package data;

import TRMS.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface EmployeeDAO extends GenericDAO<Employee>{

    public Set<Employee> findAll() throws Exception;
    public Employee getByUsername(String username);
    public Set<Employee> getByStatus(String status);
}
