import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    final String user = "postgres";
    final String password = "Flyer1983";
    final String url = "jdbc:postgresql://localhost:5432/skypro";


    @Override
    public void addEmployee(Employee employee) {

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO employee " +
                             "(first_name, last_name, gender, age, city_id) " +
                             "VALUES (?,?,?,?,?)")) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.setInt(5, employee.getCity());
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
                             "LEFT JOIN city ON employee.city_id = city.city_id " +
                             "WHERE id=?")) {
            preparedStatement.setInt(1, id);
            System.out.println("Соеденение c БД установлено!");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String nameOfEmployee = resultSet.getString("first_name");
                String surnameOfEmployee = resultSet.getString("last_name");
                String genderOfEmployee = (resultSet.getString("gender").equals("male") ? "мужской" : "женский");
                int ageOfEmployee = resultSet.getInt("age");
                String cityOfEmployee = resultSet.getString("city_name");

                System.out.printf("Сотрудник %S %S, пол - %s, возраст - %d, проживает в г.%s",
                        nameOfEmployee, surnameOfEmployee, genderOfEmployee, ageOfEmployee, cityOfEmployee);

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
                             "LEFT JOIN city ON employee.city_id = city.city_id")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String nameOfEmployee = resultSet.getString("first_name");
                String surnameOfEmployee = resultSet.getString("last_name");
                String genderOfEmployee = (resultSet.getString("gender").equals("male") ? "мужской" : "женский");
                int ageOfEmployee = resultSet.getInt("age");
                String cityOfEmployee = resultSet.getString("city_name");
                int idCityOfEmployee = resultSet.getInt("city_id");

                employeeList.add(new Employee(
                        idOfEmployee, nameOfEmployee, surnameOfEmployee, genderOfEmployee, ageOfEmployee,
                        idCityOfEmployee));

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
                             "age = 82 WHERE id=?")) {
            preparedStatement.setInt(1, id);
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
                             "WHERE id =?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.printf("Сотрудник с id = %d удален\n");

        } catch (SQLException e) {
            System.out.println(" Ошибка при установлении соедениения!");
            e.printStackTrace();
        }

    }
}
