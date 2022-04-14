package data;

import TRMS.Employee;
import TRMS.Status;
import io.cucumber.java.an.E;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    Connection connection;
    private PreparedStatement preparedStatement;

    // Default constructor
    public EmployeeDAOImpl() {
        connection = ConnectionFactory.getConnection();
        // this.connection = connection;
    }

    public int create(Employee employee) throws SQLException {
        String sql = "insert into employee (employee_id,firstName,lastName,dept_id,manager_id,username,password) values (default, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            //preparedStatement.setInt(1,emp.getEmployee_id());
            preparedStatement.setInt(4,employee.getManager_id());
            preparedStatement.setInt(3,employee.getDept_id());
            preparedStatement.setString(5, employee.getUsername());
            preparedStatement.setString(6,employee.getPassword());

            int status_id;
            if(employee.getEmployee_id() == 1){
                status_id = 1;
            }
            else{
                status_id = 2;
            }
            connection.setAutoCommit(false); // for tx management (ACID)
            // execute this command, return number of rows affected:
            int count = preparedStatement.executeUpdate();
            // lets us return the id that is auto-generated
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            // if we affected one or more rows:
            if (count > 0) {
                System.out.println("Employee added!");
                // return the generated id:
                // before we call resultSet.next(), it's basically pointing to nothing useful
                // but moving that pointer allows us to get the information that we want
                resultSet.next();
                int id = resultSet.getInt(1);
                //employee.setId(id);
                connection.commit(); // commit the changes to the DB
            }
            // if 0 rows are affected, something went wrong:
            else {
                System.out.println("Something went wrong when trying to add employee!");
                connection.rollback(); // rollback the changes
            }
        } catch (SQLException e){
            // print out what went wrong:
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee.getEmployee_id();
    }



    @Override
    public Employee getById(int id){
        Employee employee = null;

        //PreparedStatement preparedStatement = null;
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "select * from employee where employee_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                employee = new Employee();
                employee.setEmployee_id(id);
                employee.setFirstName(resultSet.getString("first name"));
                employee.setLastName(resultSet.getString("last name"));
                employee.setManager_id(resultSet.getInt("manager id"));
                employee.setDept_id(resultSet.getInt("department id"));
                employee.setUsername(resultSet.getString("username"));
                employee.setPassword(resultSet.getString("password"));

                //Status status = new Status();
                //status.setStatus_id(resultSet.getInt("status_id"));
                //status.setStatus_name(resultSet.getString("status_name"));
                //employee.setEmployee_id(id);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return  employee;
    }



    @Override
    public Set<Employee> findAll() throws Exception {
        String sql =  "SELECT SELECT employee_id,firstName,lastname,dept_id,manager_id FROM employee WHERE employee_id = ?";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        Employee employee = null;
        Set<Employee> list =  new HashSet<>();
        while(rs.next()){
            int employee_id = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            int dept_id = rs.getInt(4);
            int manager_id = rs.getInt(5);
            String username = rs.getString(6);
            String password = rs.getString(7);
            employee =  new Employee();
            employee.setEmployee_id(employee_id);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setDept_id(dept_id);
            employee.setManager_id(manager_id);
            employee.setUsername(username);
            employee.setPassword(password);
            list.add(employee);
        }
        return list;
    }

    @Override
    public Employee getByUsername(String username) {
        Employee employee = null;
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "Select * from employee where username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(3, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){

            }else{
                System.out.println("something went wrong getting username");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            {
                try{
                    preparedStatement.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return employee;
    }

    private Employee parseResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployee_id(resultSet.getInt("employee_id"));
        employee.setFirstName(resultSet.getString("firstName"));
        employee.setLastName(resultSet.getString("lastName"));
        employee.setDept_id(resultSet.getInt("manager_id"));
        employee.setManager_id(resultSet.getInt("dept_id"));
        employee.setUsername(resultSet.getString("username"));
        employee.setPassword(resultSet.getString("password"));
        int status_id = resultSet.getInt("employee_id");

        String status = (status_id == 1) ? "Available" : "Picked";
        //employee.setStatus(status);
        return employee;
    }

    @Override
    public Set<Employee> getAll() {
        Set<Employee> emp = new HashSet<>();
        String sql = "select * from employee";
        try(Connection connection =  ConnectionFactory.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Employee employee = parseResultSet(resultSet);
                emp.add(employee);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return emp;
    }


    public Set<Employee> getByStatus(String status){
        Set<Employee> allEmployees = new HashSet<>();
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "SELECT employee_id,firstName,lastname,dept_id,manager_id FROM employee join status on status.status_id where status_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int statusId = (status.equals("Available")?1:2);
            preparedStatement.setInt(1,statusId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Employee employee = parseResultSet(resultSet);
                allEmployees.add(employee);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return allEmployees;
    }

    @Override
    public void update(Employee updateObj) throws SQLException{
        Connection connection = ConnectionFactory.getConnection();
        String sql = "update employee set firstname, lastname, dept_id, manager_id where employee_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // fill in the template:
            preparedStatement.setInt(1,updateObj.getEmployee_id());
            preparedStatement.setString(2, updateObj.getFirstName());
            preparedStatement.setString(3, updateObj.getLastName());
            preparedStatement.setInt(4,updateObj.getDept_id());
            preparedStatement.setInt(5,updateObj.getManager_id());
           // int status_id = (updateObj.setEmployee_id().equals("Available")) ? 1 : 2;
            //preparedStatement.setInt(6,status_id);
            //preparedStatement.setInt(7,updateObj.getId());

            connection.setAutoCommit(false);
            // return count
            int count = preparedStatement.executeUpdate();
            if(count !=1 ){
                connection.rollback();
                throw new SQLException("error");
            }else{
                connection.commit();
            }
        }catch(SQLException e){
            e.printStackTrace();
            try{
                connection.rollback();
            }catch(SQLException e1){
                e1.printStackTrace();
            }
            throw  e;
        }finally {
            try{
                connection.close();;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Employee deleteObj) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "delete from employee where employee_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, deleteObj.getEmployee_id());
            connection.setAutoCommit(false);
            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                connection.rollback();
                throw new SQLException("ERROR: no object found to update");
            } else connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw e;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    }


