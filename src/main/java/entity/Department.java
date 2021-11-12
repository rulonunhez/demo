package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "departments")
public class Department {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "department")
    private int id;
    private String name;
    @ManyToMany
    @JoinTable (name = "emp_dep", joinColumns = @JoinColumn (name = "iddeparment")
            , inverseJoinColumns = @JoinColumn (name = "idemployee"))
    private List<Employee> lemployees;

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmployee(Employee e){
        lemployees.add(e);
    }
}
