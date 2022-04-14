package data;

import TRMS.Event_type;
import TRMS.Reimbursement_request;
import utils.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class RequestDAOImpl implements RequestDAO {

    Connection connection;

    // default constructor
    public RequestDAOImpl() {
        connection = ConnectionFactory.getConnection();
    }

    public int create(Reimbursement_request req) throws SQLException {
        int genID = 0;
        PreparedStatement preparedStatement = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);
            String sql = "insert into reimbursement_request(request_id,employee_id,event_type_id,cost,description,location,event_date,submitted_at) values (default, ?, ?, ?, ?, ?, ?, ?)";
            String[] keys = {"id"};
            preparedStatement = connection.prepareStatement(sql, keys);
            preparedStatement.setInt(1, req.getEmployee_id());
            preparedStatement.setInt(2, req.getEvent_type_id());
            preparedStatement.setInt(3, req.getCost());
            preparedStatement.setString(4, req.getDescription());
            preparedStatement.setString(5, req.getLocation());
            preparedStatement.setDate(6, new java.sql.Date(req.getEvent_date().getTime()));
            preparedStatement.setDate(7, new java.sql.Date(req.getSubmitted_at().getTime()));
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                genID = resultSet.getInt("id");
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return genID;

    }

    @Override
    public Reimbursement_request getById(int id) {
        Reimbursement_request reimbursement_request = null;

        String sql = "SELECT * FROM reimbursement_request WHERE request_id = ?";

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                reimbursement_request = parseResultSet(resultSet);
            } else {
                System.out.println("Something went wrong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursement_request;
    }

    @Override
    public Set<Reimbursement_request> getAll() {
        Set<Reimbursement_request> requests = new HashSet<>();
        String sql = "SELECT * FROM reimbursement_request";
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reimbursement_request request = parseResultSet(resultSet);
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    private Reimbursement_request parseResultSet(ResultSet resultSet) throws SQLException {
        Reimbursement_request request = new Reimbursement_request();
        request.setEmployee_id(resultSet.getInt(1));
        request.setEvent_type_id(resultSet.getInt(2));
        request.setRequest_id(resultSet.getInt(3));
        request.setEvent_date(resultSet.getDate(4));
        request.setCost(resultSet.getInt(5));
        request.setDescription(resultSet.getString(6));
        request.setLocation(resultSet.getString(7));
        request.setSubmitted_at(resultSet.getDate(8));
        return request;
    }

    @Override
    public void update(Reimbursement_request updateObj) throws SQLException {
        PreparedStatement preparedStatement = null;
        //Connection connection = ConnectionFactory.getConnection();

        try (Connection connection = ConnectionFactory.getConnection()) {
            //PreparedStatement preparedStatement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);

            String sql = "update reimbursement_request set employee_id = ?, event_type_id = ?, status_id = ?, event_date = ?, cost = ?, description = ?, location = ?, submitted_at = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, updateObj.getRequest_id());


            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                System.out.println("Something went wrong with updating");
                connection.rollback();
            } else connection.commit();
        } catch (SQLException e) {
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
    }

    @Override
    public void delete(Reimbursement_request deleteObj) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "delete from reimbursement_request where request_id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(0, deleteObj.getRequest_id());

            connection.setAutoCommit(false);
            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                System.out.println("You were not able to delete the request");
                connection.rollback();
            } else connection.commit();
        } catch (SQLException e) {
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
    }


    @Override
    public int getByEmpId(int request_id) {
        return 0;
    }
}
