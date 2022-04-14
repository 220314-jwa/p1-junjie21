package data;

import TRMS.Reimbursement_request;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RequestDAOTest {

    private static RequestDAO requestDAO = DaoFactory.getRequestDAO();
    private static Reimbursement_request test =  new Reimbursement_request();
    private static Reimbursement_request test2 = new Reimbursement_request();


    @BeforeAll
    public static void setUp() throws SQLException {
        test.setEmployee_id(666);

        Random rnd = new Random();
        test2.setRequest_id(666+ rnd.nextInt());
        test.setRequest_id(requestDAO.create(test));
    }

    @Test
    public void getById(){
        int id = test.getRequest_id();
        Reimbursement_request reimbursement_request = requestDAO.getById(id);
        assertEquals(test, reimbursement_request.getEmployee_id());
    }

    @Test
    public void deleteRequest(){
        assertDoesNotThrow(() ->{
            requestDAO.delete(test2);
        });
    }

    @Test
    public void createRequest() throws SQLException {
        int id = requestDAO.create(test2);
        test2.setRequest_id(id);

        assertNotEquals(1,id);
    }

}