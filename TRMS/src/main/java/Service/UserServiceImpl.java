package Service;

import TRMS.Employee;
import TRMS.Reimbursement_request;
import data.*;
import exceptions.AlreadyAdoptedException;
import exceptions.IncorrectCredentialsException;
import exceptions.UsernameAlreadyExistsException;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private EmployeeDAO employeeDAO = DaoFactory.getEmployeeDAO();
    //private DepartmentDAO departmentDAO = DaoFactory.getDepartmentDAO();
    private RequestDAO requestDAO = DaoFactory.getRequestDAO();
    private EventDAO eventDAO = DaoFactory.getEventDAO();

    @Override
    public Employee logIn(String username, String password) throws IncorrectCredentialsException, SQLException {
        Employee employee = employeeDAO.getByUsername(username);
        if(employee != null && employee.getPassword().equals(password)){
            return employee;
        }else{
            throw new IncorrectCredentialsException();
        }
    }

    @Override
    public Employee register(Employee newUser) throws UsernameAlreadyExistsException, SQLException {
        int id = employeeDAO.create(newUser);
        if(id != 0){
            newUser.setEmployee_id(id);
            return newUser;
        }else{
            throw new UsernameAlreadyExistsException();
        }
    }

    @Override
    public List<Employee> viewAvailableEmployee() {
        // return employeeDAO.getAll("All");
        return null;
    }

    @Override
    public Employee pickEmployee(Employee employee, Reimbursement_request request) throws AlreadyAdoptedException, Exception {
        //request = employeeDAO.getById(request.getRequest_id());
        return null;
    }

    @Override
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    @Override
    public Reimbursement_request getReById(int id) {
        return requestDAO.getById(id);
    }
}
