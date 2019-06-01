package com.restaurante.resapi.model;

import com.restaurante.resapi.entity.E_Persona;

public class Persona_model {
    private long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String observacion;
    private String tipo;


    public Persona_model(E_Persona e_persona) {

        this.id = e_persona.getId();
        this.nombre = e_persona.getNombre();
        this.apellido1 = e_persona.getApellido1();
        this.apellido2 = e_persona.getApellido2();
        this.observacion = e_persona.getObservacion();
        this.tipo = e_persona.getTipo();
    }

    public Persona_model(long id, String nombre, String apellido1, String apellido2, String observacion, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.observacion = observacion;
        this.tipo = tipo;
    }

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
