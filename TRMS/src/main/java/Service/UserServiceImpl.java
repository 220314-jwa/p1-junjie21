package Service;

import TRMS.Employee;
import data.*;
import exceptions.IncorrectCredentialsException;

import java.util.List;

public class UserServiceImpl implements UserService {
    private EmployeeDAO employeeDAO = DaoFactory.getEmployeeDAO();
    private DepartmentDAO departmentDAO = DaoFactory.getDepartmentDAO();
    private RequestDAO requestDAO = DaoFactory.getRequestDAO();
    private EventDAO eventDAO = DaoFactory.getEventDAO();
    //private StatusDAO statusDAO =

    @Override
    public Employee logIn(String username, String password) throws IncorrectCredentialsException{
        //Employee employee = (Employee) employeeDAO.getByFirstName(username);

         return null;
    }

    @Override
    public List<Employee> viewAvailableEmployee() {
        //return EmployeeDAO.getAll();
        return null;
    }

    @Override
    public Employee getById(int id) {
        //return EmployeeDAO.getById(id);
        return null;
    }

    @Override
    public Employee getByLastName(String lastName) {
        //return EmployeeDAO.get
        return null;
    }

    @Override
    public List<Employee> searchEmployeeById(int id) {
        return null;
    }
}
