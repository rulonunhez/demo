package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table (name = "tasks")
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idtask")
    private long id;
    @Basic (optional = false)
    @Column (length = 100, nullable = false)
    private String description;
    @Basic (optional = false)
    @Column (name = "begindate", nullable = false)
    private LocalDate beginDate;
    @Column (name = "enddate")
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn (name = "idemployee")
    private Employee employee;


    public Task() {
    }

    /*public Task(String description, LocalDate beginDate, LocalDate endDate, Employee empleado) {
        this.description = description;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.empleado = empleado;
    }

    public Task(String description, LocalDate endDate, Employee empleado) {
        this.description = description;
        this.beginDate = LocalDate.now();
        this.endDate = endDate;
        this.empleado = empleado;
    }

    public Task(LocalDate beginDate, String description, Employee empleado) {
        this.description = description;
        this.beginDate = beginDate;
        this.endDate = null;
        this.empleado = empleado;
    }

    public Task(String description, Employee empleado) {
        this.description = description;
        this.beginDate = LocalDate.now();
        this.endDate = null;
        this.empleado = empleado;
    }*/

    public Task(String description) {
        this.description = description;
        this.beginDate = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws Exception{
        if (description != null ||
                (description.length() > 0 && description.length() < 100) ){
            this.description = description;
        } else {
            throw new Exception("Error al modificar la descripción");
        }

    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(description, task.description) && Objects.equals(beginDate, task.beginDate) && Objects.equals(endDate, task.endDate);
    }

}
