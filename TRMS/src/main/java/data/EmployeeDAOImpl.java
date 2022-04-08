package data;

import TRMS.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    Connection connection;

    // Default constructor
    public EmployeeDAOImpl() {
        connection = ConnectionFactory.getConnection();
    }

    public int create(Employee emp) throws SQLException {
        String sql = "insert into employee (employee_id,firstName,lastName,dept_id,manager_id) " + "values(default, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, emp.getFirstName());
        preparedStatement.setString(2, emp.getLastName());
        //preparedStatement.setInt(1,emp.getEmployee_id());
        preparedStatement.setInt(4,emp.getManager_id());
        preparedStatement.setInt(3,emp.getDept_id());

        boolean count = preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if(count  == true){
            System.out.println("Here we are");
            resultSet.next();
            int id = resultSet.getInt(1);
            return id;
        }
        else
        {
            System.out.println("Not one found");
            return -1;
        }
    }

    @Override
    public List<Employee> getByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Employee> getByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Employee> getById(int employeeId) {
        return null;
    }

    @Override
    public List<Employee> getByDept(int deptId) {
        return null;
    }

    @Override
    public List<Employee> getByManager(int managerId) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }
}


