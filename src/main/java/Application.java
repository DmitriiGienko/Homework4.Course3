
public class Application {
    public static void main(String[] args) {

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        employeeDAO.getAllEmployee();
        System.out.println("+++++++++++++++++++++++++++++++++++");

//        employeeDAO.getEmployeeById(2);

        employeeDAO.addEmployee(new Employee("Valentin","Pirogoff","male",45,3 ));
        System.out.println("+++++++++++++++++++++++++++++++++++");

//        employeeDAO.deleteEmployee(employeeDAO.getEmployeeById(6));
//        employeeDAO.getAllEmployee();

        employeeDAO.updateEmployee(employeeDAO.getEmployeeById(6),new Employee("fg",));
        employeeDAO.getAllEmployee();


    }



}
