package data;

import TRMS.Event_type;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class EventDAOImpl implements EventDAO{

    Connection connection;

    public EventDAOImpl(){
        connection = ConnectionFactory.getConnection();
    }

    public int create(Event_type eve) throws SQLException{
        String sql = "insert into event_type(event_type_id, event_type_name) " + " values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, eve.getEvent_type_name());
        preparedStatement.setInt(2,eve.getEvent_type_id());


        int event_id;
        if(eve.getClass().equals("Avaliable")){
            event_id =1;
        }
        else
        {
            event_id =2;
        }
        preparedStatement.setInt(3,eve.getEvent_type_id());
        int count = preparedStatement.getUpdateCount();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if(count > 0){
            System.out.println("Employee found!");
            resultSet.next();
            int id = resultSet.getInt(1);
            return id;
        }
        else{
            System.out.println("Can't find the employee you are looking for!");
            return -1;
        }
    }

    @Override
    public Event_type getById(int id) {
        return null;
    }

    @Override
    public Set<Event_type> getAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Event_type updateObj) throws SQLException {

    }

    @Override
    public void delete(Event_type deleteObj) throws SQLException {

    }


    @Override
    public Event_type getByName(String event_name) {
        return null;
    }
}
