package data;

import TRMS.Status;
import org.checkerframework.checker.units.qual.C;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StatusDAOImpl implements StatusDAO{

    Connection connection;
    public StatusDAOImpl(){
    connection = ConnectionFactory.getConnection();
    }

    public int create(Status status) throws SQLException{
    String sql = "insert into status (status_id , status_name)" + "values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,status.getStatus_id());
        preparedStatement.setString(2,status.getStatus_name());

        int statusId;
        if(status.getClass().equals("ab")){
            statusId = 1;
        }
        else
        {
            statusId =2;
        }
        preparedStatement.setInt(3,status.getStatus_id());
        int count = preparedStatement.getUpdateCount();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if(count > 0){
            System.out.println("status :");
            resultSet.next();
            int id = resultSet.getInt(1);
            return id;
        }
        else
        {
            System.out.println();
            return -1;
        }

    }

    @Override
    public Status getById(int id) {
        Status status = null;
        PreparedStatement preparedStatement = null;
        try(Connection connection = ConnectionFactory.getConnection()){
            // TODO
            String sql = "";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                status = new Status();
                status.setStatus_id(id);
                status.setStatus_name(resultSet.getString("name"));
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
        return status;
    }

    @Override
    public Set<Status> getAll() {
        Set<Status> statusSet = new HashSet<>();
        PreparedStatement preparedStatement= null;
        try(Connection connection = ConnectionFactory.getConnection()){
            // TODO
            String sql = "";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet  = preparedStatement.executeQuery();
            while(resultSet.next()){
                Status status = new Status();
                status.setStatus_id(resultSet.getInt("id"));
                status.setStatus_name(resultSet.getString("name"));
                statusSet.add(status);
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
        return statusSet;
    }

    @Override
    public void update(Status updateObj) throws SQLException {
        PreparedStatement preparedStatement = null;

        try(Connection connection = ConnectionFactory.getConnection()){
            connection.setAutoCommit(false);
            //TODO
            String sql = "";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,updateObj.getStatus_name());
            int row = preparedStatement.executeUpdate();

            if(row == 1){
                connection.commit();
            }else{
                connection.rollback();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public void delete(Status deleteObj) throws SQLException {
        PreparedStatement preparedStatement = null;
        try(Connection connection = ConnectionFactory.getConnection()){
            connection.setAutoCommit(false);
            //TODO
            String sql = "";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,deleteObj.getStatus_id());
            int row = preparedStatement.executeUpdate();

            if(row == 1){
                connection.commit();
            }else{
                connection.rollback();
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
    }

    @Override
    public Status getByName(String status_name) {
        Status status = null;
        PreparedStatement preparedStatement = null;

        try(Connection connection = ConnectionFactory.getConnection()){
        //TODO
            String sql = "";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,status_name);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                status = new Status();
                status.setStatus_id(resultSet.getInt("id"));
                status.setStatus_name(resultSet.getString("status_name"));
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
        return status;
    }
}
