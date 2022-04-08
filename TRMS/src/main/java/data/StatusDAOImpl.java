package data;

import TRMS.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public Status getById(Status status_id) {
        return null;
    }

    @Override
    public Status getByName(Status status_name) {
        return null;
    }
}
