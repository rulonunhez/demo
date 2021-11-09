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
    @JoinColumn
    private Employee empleado;

    public Card() {
    }

    public Card(long id, String code, Employee empleado) {
        this.id = id;
        this.code = code;
        this.empleado = empleado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
