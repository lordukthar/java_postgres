package com.example.accessingdatajpa;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "playground")
public class Playground implements Serializable {

    private static final long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long equip_id;

    @Column(name = "color")
    private String color;

    Playground(long equip_id, String color) {
        this.equip_id = equip_id;
        this.color = color;
    }

    Playground( String color) {
        this.color = color;
    }


    Playground() {
        System.out.println("KJLKJLKJLK");
    }

    public long getEquip_id() {
        return equip_id;
    }

    public String getColor() {
        return color;
    }
}
