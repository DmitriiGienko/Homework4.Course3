import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        System.out.printf("Сотрудник %s %s добавлен\n", employee.getFirstName(), employee.getLastName());
    }

    @Override
    public Employee getEmployeeById(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        System.out.println(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return employee;
    }

    @Override
    public void getAllEmployee() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employeeList = query.getResultList();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Employee empForUpdate = entityManager.find(Employee.class, id);
        System.out.printf("Сотрудник %s %s изменен\n", empForUpdate.getFirstName(), empForUpdate.getLastName());
        empForUpdate.setFirstName(employee.getFirstName());
        empForUpdate.setLastName(employee.getLastName());
        empForUpdate.setGender(employee.getGender());
        empForUpdate.setAge(employee.getAge());
        empForUpdate.setCity(employee.getCityId());
        entityManager.merge(empForUpdate);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee empForDelete = entityManager.find(Employee.class, employee.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(empForDelete);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        System.out.printf("Сотрудник %s %s удален\n", employee.getFirstName(), employee.getLastName());
    }
}
