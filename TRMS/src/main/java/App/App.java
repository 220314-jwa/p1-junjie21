package App;

import TRMS.Department;
import TRMS.Employee;
import TRMS.Event_type;
import TRMS.Reimbursement_request;
import TRMS.Status;
import data.*;
import io.javalin.Javalin;
import Service.UserServiceImpl;
import Service.UserService;

import java.sql.SQLException;


public class App {

    public static void main(String args[]) {
        // To start the application here
        Javalin app = Javalin.create().start(6666);

        // post for creating put update get retrieve

        // get employee ID:
        app.get("/emp/{id}", ctx -> {
            //Employee employee = new Employee();
            Employee employee =  ctx.bodyAsClass(TRMS.Employee.class);
            ctx.json(employee);
        });

        // get info for employee // creating data
        app.get("/emp", ctx -> {
            Employee employee = ctx.bodyAsClass(TRMS.Employee.class);
            ctx.json(employee.getEmployee_id());
            ctx.json(employee.getFirstName());
            ctx.json(employee.getLastName());
            ctx.json(employee.getDept_id());
            ctx.json(employee.getManager_id());
            System.out.println(employee);
            ctx.result(employee.toString());
        });

        app.post("/emp/create",ctx -> {
            try{
                Employee employee = ctx.bodyAsClass(TRMS.Employee.class);
                EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
                employeeDAO.create(employee);
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        // updating data changes values put

// ------------------------------------------------------------------------------------------------------------------
        // Department
        app.get("/dept", ctx -> {
            Department department = ctx.bodyAsClass(TRMS.Department.class);
            ctx.json(department.getDept_name());
            ctx.json(department.getDept_id());
            ctx.json(department.getHead_id());
            ctx.result(department.toString());

        });

        app.post("/dept/create", ctx -> {
            try{
                Department department = ctx.bodyAsClass(TRMS.Department.class);
                DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();
                departmentDAO.create(department);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

// ------------------------------------------------------------------------------------------------------------------
        // Request
        app.get("/request", ctx -> {
            Reimbursement_request reimbursement_request = ctx.bodyAsClass(TRMS.Reimbursement_request.class);
            ctx.json(reimbursement_request.getRequest_id());
            ctx.json(reimbursement_request.getEvent_type_id());
            ctx.json(reimbursement_request.getCost());
            ctx.json(reimbursement_request.getDescription());
            ctx.json(reimbursement_request.getLocation());
            ctx.json(reimbursement_request.getEvent_date());
            ctx.json(reimbursement_request.getSubmitted_at());
            ctx.result(reimbursement_request.toString());
        });

        app.post("/request/create", ctx -> {
            try{
                Reimbursement_request reimbursement_request = ctx.bodyAsClass(TRMS.Reimbursement_request.class);
                RequestDAOImpl requestDAO = new RequestDAOImpl();
                requestDAO.create(reimbursement_request);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

// ------------------------------------------------------------------------------------------------------------------
        // Event
        app.get("/event", ctx -> {
            Event_type event = ctx.bodyAsClass(TRMS.Event_type.class);
            ctx.json(event.getEvent_type_id());
            ctx.json(event.getEvent_type_name());
            ctx.result(event.toString());
        });


        app.post("/event/create", ctx -> {
            try{
                Event_type event = ctx.bodyAsClass(TRMS.Event_type.class);
                EventDAOImpl eventDAO = new EventDAOImpl();
                eventDAO.create(event);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

// ------------------------------------------------------------------------------------------------------------------
        // Status
        app.get("/status", ctx -> {
            Status status =ctx.bodyAsClass(TRMS.Status.class);
            ctx.json(status.getStatus_id());
            ctx.json(status.getStatus_name());
            ctx.result(status.toString());
        });


        app.post("/status/create", ctx -> {
            try{
                Status status = ctx.bodyAsClass(TRMS.Status.class);
                StatusDAOImpl statusDAO = new StatusDAOImpl();
                statusDAO.create(status);
            }catch(Exception e){
                e.printStackTrace();
            }
        });

    }
}
