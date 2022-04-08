package Service;

import java.sql.SQLException;
import java.util.List;

import TRMS.Employee;
import exceptions.IncorrectCredentialsException;

public interface UserService {
    public Employee logIn(String username, String password) throws IncorrectCredentialsException, SQLException;

    public List<Employee> viewAvailableEmployee();


    public Employee getById(int id);

    public Employee getByLastName(String lastName) throws IncorrectCredentialsException, SQLException;

    public List<Employee> searchEmployeeById(int id);

}
