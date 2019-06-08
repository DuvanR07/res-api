package com.restaurante.resapi.entity;

import javax.persistence.*;

@Table(name = "mesa")
@Entity
public class E_Mesa {

    public E_Mesa() {

    }

    public E_Mesa(long id, String des, long num_max, String ubicacion) {
        this.id = id;
        this.des= des;
        this.num_max = num_max;
        this.ubicacion = ubicacion;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "_id")
    private long id;


    @Column(name = "des")
    private String des;

    @Column(name = "num_max")
    private long num_max;

    @Column(name = "ubicacion")
    private String ubicacion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public long getNum_max() {
        return num_max;
    }

    public void setNum_max(long num_max) {
        this.num_max = num_max;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
