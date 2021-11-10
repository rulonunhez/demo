package entity;

import javax.persistence.*;
import java.util.Enumeration;

@Entity
@Table (name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name = "idcard")
    private long id;
    @Column (nullable = false)
    private String code;
    @Transient
    private TypeCard type;
    @OneToOne
    @JoinColumn (name = "idemployee")
    private Employee empleado;

    public Card() {
    }

    public Card(String code, TypeCard type, Employee empleado) {
        this.code = code;
        this.type = type;
        this.empleado = empleado;
    }

    public Card(String code, TypeCard type) {
        this.code = code;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String fName) {
        this.code = code;
    }

    public TypeCard getType() {
        return type;
    }

    public void setType(TypeCard type) {
        this.type = type;
    }

    public Employee getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Employee empleado) {
        this.empleado = empleado;
    }
}
