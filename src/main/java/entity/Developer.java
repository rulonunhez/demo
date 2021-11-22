package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "1")
public class Developer extends Employee {
    private String programingLenguage;

    public Developer(String firstname, String lastname, String contactnumber, String s){
        super(firstname, lastname, contactnumber);
        this.programingLenguage = s;
    }

    public Developer() {
    }
}
