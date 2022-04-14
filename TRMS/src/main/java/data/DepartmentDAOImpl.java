package data;

import TRMS.Department;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAOImpl implements DepartmentDAO{

    Connection connection;

    public DepartmentDAOImpl (){
    connection = ConnectionFactory.getConnection();
    }

    public int create(Department dept) throws SQLException {
        String sql = "insert into department(dept_id,dept_name,head_id) values (default, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,dept.getDept_name());
        preparedStatement.setInt(2,dept.getHead_id());
        //preparedStatement.setInt(2,dept.getDept_id());

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
    public Department getByDeptId(Department dept_id) {
        return null;
    }

    @Override
    public Department getByHeadId(Department head_id) {
        return null;
    }

    @Override
    public Department getByDeprName(Department dept_name) {
        return null;
    }

    @Override
    public Department getAll() {
        return null;
    }
}
