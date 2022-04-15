package data;

import TRMS.Employee;
import TRMS.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.ConnectionFactory;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import static org.junit.jupiter.api.Assertions.*;

class StatusDAOImplTest {

    private static StatusDAO statusDAO = new StatusDAOImpl();


    @Test
    public void checkStaus(){
        Status status = new Status();
        //statusDAO.getById(2);
        assertEquals("good",status.getStatus_name());
    }

    @Test
    public void checkID(){
        //Status status = new Status();
        int id = 1;

        assertEquals(id,statusDAO.getById(2));

    }

}