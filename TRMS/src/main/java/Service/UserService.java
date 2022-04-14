package Service;

import java.sql.SQLException;
import java.util.List;

import TRMS.Employee;
import TRMS.Reimbursement_request;
import data.GenericDAO;
import exceptions.AlreadyAdoptedException;
import exceptions.IncorrectCredentialsException;
import exceptions.UsernameAlreadyExistsException;

public interface UserService {
    public Employee logIn(String username, String password) throws IncorrectCredentialsException, SQLException;
    public Employee register(Employee newUser) throws UsernameAlreadyExistsException, SQLException;
    public List<Employee> viewAvailableEmployee();
    public Employee pickEmployee(Employee employee, Reimbursement_request request) throws AlreadyAdoptedException,Exception;
    public Employee getById(int id);
    public Reimbursement_request getReById(int id);

}
