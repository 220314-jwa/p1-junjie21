package data;

import TRMS.Department;
import TRMS.Employee;

import java.util.List;

public interface DepartmentDAO extends GenericDAO<Department>{

    public Department getByDeprName(String dept_name);

}
