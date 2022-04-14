package data;

import TRMS.Employee;
import io.cucumber.java.an.E;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDAOTest {
    private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    private static Employee empTest = new Employee();
    private static Employee newEmp = new Employee();

    @Test
    public void print(){
        System.out.println("Testing start!");
    }

    @Test
    public void getById(){
        int input = 1;
        Employee output = employeeDAO.getById(input);
        assertEquals(20,output.getEmployee_id());
    }

    @Test
    public void testGetByIdDoesNotExist() {
        Employee employee = employeeDAO.getById(1);
        assertNull(employee);
    }

    @Test
    public void testGetByIdDoesExist() {
        int id = empTest.getEmployee_id();
        Employee employee = employeeDAO.getById(id);
        assertEquals(empTest, employee);
    }

    @Test
    public void getAll(){
        Set<Employee> output = employeeDAO.getAll();
        assertNotNull(output);
    }

    @Test
    public void addEmployee() throws SQLException {
        Employee newE = new Employee();
        System.out.println(newE);

        int id1 = employeeDAO.create(newE);
        assertNotEquals(1,id1);
        System.out.println(id1);
    }

    @Test
    public void testDeleteEmployeeExists() {
        assertDoesNotThrow(() -> {
            employeeDAO.delete(newEmp);
        });
    }
    @Test
    public void testDeleteEmployeeDoesNotExist() {
        assertThrows(SQLException.class, () -> {
            employeeDAO.delete(new Employee());
        });
    }

    @AfterAll
    public static void cleanUp(){
        try {
            employeeDAO.delete(empTest);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}