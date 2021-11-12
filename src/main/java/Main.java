import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try {
            // Generación tabla Employee
            Employee e = new Employee("Pablo", "Rodriguez", "698457426");
            // Generación tabla Task
            Task t = new Task("Creating landing page");
            // Generación tabla Card
            Card c = new Card("2345-2345-2345-2345", TypeCard.BLACK);
            Department d1 = new Department("IT");
            Department d2 = new Department("Finance");
            e.setTarjeta(c);
            e.addTask(t);
            e.addDepartment(d1);
            e.addDepartment(d2);
            c.setEmpleado(e);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(e);
            em.persist(t);
            em.persist(c);
            em.persist(d1);
            em.persist(d2);
            em.getTransaction().commit();
            em.close();
            emf.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
