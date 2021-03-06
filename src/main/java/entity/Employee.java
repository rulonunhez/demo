package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "employees")
@NamedQuery(name = "consultarTrabajadores", query = "select e from Employee e")
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn (name = "employee_type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "0")
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column (name = "idemployee")
    private long id;
    @Column (name = "firstname")
    private String fName;
    @Column (name = "lastname")
    private String lName;
    @Column (name = "contactnumber")
    private  String contactNumber;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "idcard")
    private Card tarjeta;
    @OneToMany (mappedBy = "employee", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
            , fetch = FetchType.LAZY)
    private List<Task> tareas;
    @ManyToMany
    @JoinTable (name = "emp_dep",
            joinColumns = @JoinColumn (name = "idemployee"),
            inverseJoinColumns = @JoinColumn (name = "iddepartment"))
    private List<Department> ldepartments;

    public Employee() {
    }

    public Employee(String fName, String lName, String contactNumber) {
        this.fName = fName;
        this.lName = lName;
        this.contactNumber = contactNumber;
        this.tareas = new ArrayList<Task>();
        this.ldepartments = new ArrayList<Department>();
    }

    public long getId() {
        return id;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void addTask(Task t){
        tareas.add(t);
        t.setEmployee(this);
    }

    public void removeTask(Task t) {
        this.tareas.remove(t);
        t.setEmployee(null);
    }

    public List<Task> getTareas() {
        return tareas;
    }

    public void setTareas(List<Task> tareas) {
        this.tareas = tareas;
    }

    public Card getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Card tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void addDepartment(Department d) {
        ldepartments.add(d);
    }
}
