package data;

import TRMS.Reimbursement_request;

import java.sql.*;

public class RequestDAOImpl implements RequestDAO{

    Connection connection;

    // default constructor
    public RequestDAOImpl() {
        connection = ConnectionFactory.getConnection();
    }

    public int create(Reimbursement_request req) throws SQLException{
        String sql = "insert into reimbursement_request(request_id,event_type_id,cost,description,location,event_date,submitted_at)" + "values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,req.getRequest_id());
        preparedStatement.setInt(2,req.getEvent_type_id());
        preparedStatement.setInt(3,req.getCost());
        preparedStatement.setString(4, req.getDescription());
        preparedStatement.setString(5, req.getLocation());
        preparedStatement.setDate(6, (Date) req.getEvent_date());
        preparedStatement.setDate(7, (Date) req.getSubmitted_at());

        int employee_id;
        if(req.getClass().equals("Found")){
            employee_id = 1;
        }
        else{
            employee_id =2;
        }
        preparedStatement.setInt(8,req.getEvent_type_id());
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
    public Reimbursement_request getById(Reimbursement_request request_id) {
        return null;
    }

    @Override
    public Reimbursement_request getByEventId(Reimbursement_request event_type_id) {
        return null;
    }

    @Override
    public Reimbursement_request getByCost(Reimbursement_request cost) {
        return null;
    }

    @Override
    public Reimbursement_request getByDescription(Reimbursement_request description) {
        return null;
    }

    @Override
    public Reimbursement_request getByLocation(Reimbursement_request location) {
        return null;
    }

    @Override
    public Reimbursement_request getByDate(Reimbursement_request event_date) {
        return null;
    }

    @Override
    public Reimbursement_request getByAt(Reimbursement_request submitted_at) {
        return null;
    }
}
