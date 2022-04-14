package data;

public class DaoFactory {
    private static EmployeeDAO employeeDAO = null;
    private static DepartmentDAO departmentDAO = null;
    private static EventDAO eventDAO = null;
    private static RequestDAO requestDAO = null;
    private static StatusDAO statusDAO = null;

    // Constructor
    private DaoFactory(){

    }

    public static EmployeeDAO getEmployeeDAO(){
        if(employeeDAO == null){
            employeeDAO = new EmployeeDAOImpl();
        }
        return employeeDAO;
    }

    public static StatusDAO getStatusDAO() {
        return statusDAO;
    }

    public static DepartmentDAO getDepartmentDAO(){
        if(departmentDAO == null){
            departmentDAO = new DepartmentDAOImpl();
        }
        return departmentDAO;
    }

    public static EventDAO getEventDAO(){
        if(eventDAO == null){
            eventDAO =  new EventDAOImpl();
        }
        return eventDAO;
    }

    public static RequestDAO getRequestDAO(){
        if(requestDAO == null){
            requestDAO = new RequestDAOImpl();
        }
        return requestDAO;
    }




}
