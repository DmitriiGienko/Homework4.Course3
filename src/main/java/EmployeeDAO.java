import java.util.List;

public interface EmployeeDAO {

    //    Создание (добавление) сущности Employee в таблицу.
    void addEmployee(Employee employee);

    //    Получение конкретного объекта Employee по id.
    Employee getEmployeeById(int id);

    //    Получение списка всех объектов Employee из базы.
    List<Employee> getAllEmployee();

    //    Изменение конкретного объекта Employee в базе по id.
    void updateEmployee(int id, Employee employee);

    void deleteEmployee(Employee employee);


}
