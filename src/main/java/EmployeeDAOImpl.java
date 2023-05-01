import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {

        EntityManager entityManager = UtilEntity.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        UtilEntity.closeManagerFactory();
    }

    @Override
    public Employee getEmployeeById(int id) {

        EntityManager entityManager = UtilEntity.createEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        System.out.println(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        UtilEntity.closeManagerFactory();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {

        EntityManager entityManager = UtilEntity.createEntityManager();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employeeList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        UtilEntity.closeManagerFactory();
        return employeeList;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {

        EntityManager entityManager = UtilEntity.createEntityManager();
        entityManager.getTransaction().begin();
        Employee empForUpdate = entityManager.find(Employee.class, id);
        empForUpdate.setFirstName(employee.getFirstName());
        empForUpdate.setLastName(employee.getLastName());
        empForUpdate.setGender(employee.getGender());
        empForUpdate.setAge(employee.getAge());
        empForUpdate.setCity(employee.getCityId());
        entityManager.merge(empForUpdate);
        entityManager.getTransaction().commit();
        entityManager.close();
        UtilEntity.closeManagerFactory();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManager entityManager = UtilEntity.createEntityManager();
        Employee empForDelete = entityManager.find(Employee.class, employee.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(empForDelete);
        entityManager.getTransaction().commit();
        entityManager.close();
        UtilEntity.closeManagerFactory();
    }
}
