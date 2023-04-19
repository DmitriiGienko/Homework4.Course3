import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAOImpl implements EmployeeDAO {

    final String user = "postgres";
    final String password = "Flyer1983";
    final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public void addEmployee() {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO employee " +
                             "(first_name, last_name, gender, age, city_id) " +
                             "VALUES ('Petrushka','Petrov', 'male', 24, 3)")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Сотрудник добавлен");

        } catch (SQLException e) {
            System.out.println("Ошибка при установлении соедениения!");
            e.printStackTrace();
        }

    }

    @Override
    public void getEmployeeById(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM employee " +
                             "FULL JOIN city ON employee.city_id = city.city_id")) {
            System.out.println("Соеденение c БД установлено!");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (id == resultSet.getInt("id")) {
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

    @Override
    public void getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM employee " +
                             "FULL JOIN city ON employee.city_id = city.city_id")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String nameOfEmployee = resultSet.getString("first_name");
                String surnameOfEmployee = resultSet.getString("last_name");
                String genderOfEmployee = (resultSet.getString("gender").equals("male") ? "мужской" : "женский");
                int ageOfEmployee = resultSet.getInt("age");
                String cityOfEmployee = resultSet.getString("city_name");

                employeeList.add(new Employee(
                        idOfEmployee, nameOfEmployee, surnameOfEmployee, genderOfEmployee, ageOfEmployee, cityOfEmployee));

            }
        } catch (SQLException e) {
            System.out.println("Ошибка при установлении соедениения!");
            e.printStackTrace();
        }

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }


    @Override
    public void updateEmployee(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement =
                     connection.prepareStatement("UPDATE employee SET " +
                             "first_name = 'Petr', last_name = 'Petrov', " +
                             "age = 82 WHERE id=" + id)) {
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.println("Ошибка при установлении соедениения!");
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM employee " +
                             "WHERE id =" + id)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.printf("Сотрудник с id = %d удален\n");

        } catch (SQLException e) {
            System.out.println("Ошибка при установлении соедениения!");
            e.printStackTrace();
        }

    }
}
