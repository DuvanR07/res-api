package com.restaurante.resapi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "persona")
@Entity
public class E_Persona implements Serializable {

    public  E_Persona(){

    }

    public E_Persona(long id, String nombre, String apellido1, String apellido2, String observacion, String tipo_persona) {
        this.id= id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.observacion = observacion;
        this.tipo_persona = tipo_persona;
    }

    @GeneratedValue
    @Id
    @Column(name = "_id")
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;


    @Column(name = "observacion")
    private String observacion;

    @Column(name = "tipo_persona")
    private String tipo_persona;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipo_persona() {
        return tipo_persona;
    }

    public void setTipo_persona(String tipo_persona) {
        this.tipo_persona = tipo_persona;
    }


}
