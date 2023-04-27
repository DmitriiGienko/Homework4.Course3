import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilEntity {

    public static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("myPersistenceUnit");


    public static EntityManager createEntityManager() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public static void closeManagerFactory() {
        entityManagerFactory.close();
    }
}
