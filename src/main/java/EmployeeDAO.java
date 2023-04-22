import java.util.List;

public interface EmployeeDAO {

    //    Создание (добавление) сущности Employee в таблицу.
    void addEmployee(String name, String surname, String gender, int age, int cityId);

    //    Получение конкретного объекта Employee по id.
    void getEmployeeById(int id);

    //    Получение списка всех объектов Employee из базы.
    void getAllEmployee();

    //    Изменение конкретного объекта Employee в базе по id.
    void updateEmployee(int id);

    //    Удаление конкретного объекта Employee из базы по id.
    void deleteEmployee(int id);


}
