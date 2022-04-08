package data;

import TRMS.Department;
import TRMS.Employee;

import java.util.List;

public interface DepartmentDAO {
    public Department getByDeptId(Department dept_id);

    public Department getByHeadId(Department head_id);

    public Department getByDeprName(Department dept_name);

    public Department getAll();
}
