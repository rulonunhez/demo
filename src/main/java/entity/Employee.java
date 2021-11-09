package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fName;
    private String lName;
    @OneToMany (mappedBy = , cascade = , fetch = )
    private List<Task> tareas;
    @OneToOne
    @JoinColumn
    private Card tarjeta;

    public Employee() {
    }

    public Employee(long id, String fName, String lName, List<Task> tareas, Card tarjeta) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.tareas = tareas;
        this.tarjeta = tarjeta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
