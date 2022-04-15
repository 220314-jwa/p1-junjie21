package data;

import TRMS.Department;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DepartmentDAOImpl implements DepartmentDAO{

    Connection connection;
    private PreparedStatement preparedStatement;

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
    public Department getById(int id) {
        Department department = null;

        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "select * from department where dept_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                department = new Department();
                department.setDept_id(resultSet.getInt("dept_id"));
                department.setDept_name(resultSet.getString("dept_name"));
                department.setHead_id(resultSet.getInt("head_id"));
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
        return department;
    }

    @Override
    public Set<Department> getAll() throws SQLException {
        Set<Department> set = new HashSet<>();
        String sql = "select * from department";
       try(Connection connection = ConnectionFactory.getConnection()){
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           ResultSet resultSet = preparedStatement.executeQuery();

           while(resultSet.next()){
               Department dept = parseResultSet(resultSet);
               set.add(dept);
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
        return set;
    }

    private Department parseResultSet(ResultSet resultSet) throws SQLException {
        Department department = new Department();
        department.setDept_id(resultSet.getInt("dept_id"));
        department.setHead_id(resultSet.getInt("head_id"));
        department.setDept_name(resultSet.getString("dept_name"));

        return  department;
    }

    @Override
    public void update(Department updateObj) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "update department set dept_id, dept_name, head_id, where dept_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,updateObj.getDept_id());
            preparedStatement.setInt(2,updateObj.getHead_id());
            preparedStatement.setString(3,updateObj.getDept_name());
            connection.setAutoCommit(false);

            int count = preparedStatement.executeUpdate();
            if(count !=1){
                connection.rollback();
                throw  new SQLException("error");
            }else {
                connection.commit();
            }
        }catch (SQLException e) {
            e.printStackTrace();
            try
            {
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            throw  e;
        }finally {
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Department deleteObj) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "delete from department where dept_id = ?";
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, deleteObj.getDept_id());
            connection.setAutoCommit(false);

            int count = preparedStatement.executeUpdate();

            if(count !=1){
                connection.rollback();
                throw new SQLException("error: no department delete!");
            }else connection.commit();;
        }catch (SQLException e){
            e.printStackTrace();
            try{
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            throw e;
        }finally {
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


    @Override
    public Department getByDeprName(String dept_name) {
        Department department = null;
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "Select * from department where dept_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(2,dept_name);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){

            }else{
                System.out.println("Department does not exist!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return department;
    }


}
