import entity.Employee;
import entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Generación tabla Employee
        Employee e = new Employee();
        e.setfName("Anna");
        e.setlName("López");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        emf.close();

        // Generación tabla Card
        Task t = new Task();
        t.setDescription("Buenas tardes");
        // t.setBeginDate();
        // t.setEndDate();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
