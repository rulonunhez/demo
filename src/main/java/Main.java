import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
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
    }
}
