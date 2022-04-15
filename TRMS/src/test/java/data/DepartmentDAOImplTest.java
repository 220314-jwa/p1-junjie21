package data;

import TRMS.Department;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentDAOImplTest {

    private static DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    private static Department department = new Department();
    private static Department newDepartment = new Department();

    @Test
    public void getById(){
        int id = 1;
        Department output = departmentDAO.getById(id);
        assertEquals(10,output.getDept_id());
    }

    @Test
    public void getAll() throws SQLException{
        Set<Department> output = departmentDAO.getAll();
        assertNotNull(output);
    }

    @Test
    public void testDeleteDepartment(){
        assertDoesNotThrow(() ->{
            departmentDAO.delete(newDepartment);
        });
    }

    @Test
    public void testDeleteFail(){
        assertThrows(SQLException.class, () ->
        {
            departmentDAO.delete(new Department());
        });
    }

}