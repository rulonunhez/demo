package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table (name = "tasks")
public class Task {
    @Id
    @GeneratedValue
    @Column (name = "idtask")
    private long id;
    @Column (length = 100)
    private String description;
    @Column (name = "begindate")
    private LocalDate beginDate;
    @Column (name = "enddate")
    private LocalDate endDate;
    @OneToOne
    @JoinColumn
    private Employee empleado;

    public Task() {
    }

    public Task(String description, LocalDate beginDate, LocalDate endDate, Employee empleado) {
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
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
