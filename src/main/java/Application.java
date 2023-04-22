import java.sql.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        task1();
        task2();

    }

    public static void task1() {
        final String user = "postgres";
        final String password = "Flyer1983";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM employee " +
                             "FULL JOIN city ON employee.city_id = city.city_id ")) {
            System.out.println("Соеденение c БД установлено!");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Введите id сотрудника в диапазоне 1-5");
            Scanner sc = new Scanner(System.in);
            int value = sc.nextInt();
            if (value > 5 || value < 1) {
                System.err.println("Неправильно указанан id");
                return;
            }
            while (resultSet.next()) {
                if (value == resultSet.getInt("id")) {
                    String nameOfEmployee = resultSet.getString("first_name");
                    String surnameOfEmployee = resultSet.getString("last_name");
                    String genderOfEmployee = (resultSet.getString("gender").equals("male") ? "мужской" : "женский");
                    int ageOfEmployee = resultSet.getInt("age");
                    String cityOfEmployee = resultSet.getString("city_name");

                    System.out.printf("Сотрудник %S %S, пол - %s, возраст - %d, проживает в г.%s",
                            nameOfEmployee, surnameOfEmployee, genderOfEmployee, ageOfEmployee, cityOfEmployee);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при установлении соедениения!");
            e.printStackTrace();
        }


    }

    public static void task2() {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

// вывел сотрудников
//        employeeDAO.getAllEmployee();

//добавил сотрудника
        employeeDAO.addEmployee(new Employee("Valentin", "Petrosyan",
                "male", 19, new City("Волгоград", 4)));
// вывел сотрудников
//        employeeDAO.getAllEmployee();

///удалил сотрудника
//        employeeDAO.deleteEmployee(6);

// вывел сотрудников
        employeeDAO.getAllEmployee();

// вывел сотрудника по id
//        employeeDAO.getEmployeeById(1);

// изменил сотрудника по id
//        employeeDAO.updateEmployee(2);

// вывел сотрудников
//        employeeDAO.getAllEmployee();
    }
}
