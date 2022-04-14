package Service;

import TRMS.Employee;
import TRMS.Reimbursement_request;
import data.EmployeeDAO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import data.RequestDAO;
import exceptions.IncorrectCredentialsException;
import exceptions.UsernameAlreadyExistsException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private EmployeeDAO employeeDAO;
    @Mock
    private RequestDAO requestDAO;
    @InjectMocks
    private static UserService userService = new UserServiceImpl();

    @Test
    public void examplesTest(){
        assertTrue(true);
    }

    @Test
    public void logInSuccessfully() throws IncorrectCredentialsException, SQLException {
        String username = "junjie21";
        String password = "jy89611768";

        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(password);
        when(employeeDAO.getByUsername(username)).thenReturn(employee);
        Employee result = userService.logIn(username,password);
        assertEquals(username,result.getUsername());
    }

    @Test
    public void logInWrongUsername(){
        String username = "ssqwe2";
        String password = "332100";

        Employee employee = new Employee();
        when(employeeDAO.getByUsername(username)).thenReturn(employee);

        assertThrows(IncorrectCredentialsException.class, ()->{
           userService.logIn(username,password);
        });
    }

    @Test
    public void registerUserSuccessfully() throws UsernameAlreadyExistsException, SQLException {
        Employee employee = new Employee();
        when(employeeDAO.create(employee)).thenReturn(1);


        assertThrows(UsernameAlreadyExistsException.class, () ->{
            userService.register(employee);
        });
    }

    @Test
    public void registerUsernameTaken() throws SQLException {
        Employee employee = new Employee();
        employee.setUsername("junjie21");

        when(employeeDAO.create(employee)).thenReturn(0);

        assertThrows(UsernameAlreadyExistsException.class,()->{
           userService.register(employee);
        });
    }

    @Test
    public void viewEmployeeSuccessfully(){
        when(employeeDAO.getByStatus("Available")).thenReturn(Collections.emptySet());

        List<Employee> emp = userService.viewAvailableEmployee();
        assertNotNull(emp);
    }

    @Test
    public void requestSuccess() throws Exception {
        Employee employee = new Employee();
        Reimbursement_request request = new Reimbursement_request();

        when(employeeDAO.getById(request.getRequest_id())).thenReturn(employee);
        when(requestDAO.getById(employee.getEmployee_id())).thenReturn(request);
        doNothing().when(requestDAO).update(any(Reimbursement_request.class));
        doNothing().when(employeeDAO).update(any(Employee.class));

        //Employee result =  userService.pickEmployee(employee,request);
    }

    @Test
    public void requestNotSuccess() throws SQLException {
        Employee employee = new Employee();
        Reimbursement_request request = new Reimbursement_request();

        when(requestDAO.getById(request.getRequest_id())).thenReturn(request);

        assertThrows(Exception.class, ()->{
           userService.pickEmployee(employee,request);
        });
        verify(requestDAO, never()).update(any(Reimbursement_request.class));
        verify(employeeDAO,never()).update(any(Employee.class));

    }
}