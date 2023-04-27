
public class Application {
    public static void main(String[] args) {

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

// вывел всех сотрудников
        for (Employee employee : employeeDAO.getAllEmployee()) {
            System.out.println(employee);
        }
// вывел всех сотрудника по id
        employeeDAO.getEmployeeById(2);

// добавил нового сотрудника
        employeeDAO.addEmployee(new Employee("Valentin", "Pirogoff", "male", 45, 3));

// удалил сотрудника
        employeeDAO.deleteEmployee(employeeDAO.getEmployeeById(6));

//изменил сотрудника
        employeeDAO.updateEmployee(9, new Employee("Marfa", "Valentinova", "female", 35, 2));


    }


}
