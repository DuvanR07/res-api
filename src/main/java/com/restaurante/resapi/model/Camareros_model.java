package com.restaurante.resapi.model;


import java.io.Serializable;

public class Camareros_model implements Serializable {
    public Camareros_model() throws Exception {

    }
    public Camareros_model(String nombre, String apellido1, String apellido2, String tipo_persona, String mes, String total) throws  Exception {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.tipo_persona = tipo_persona;
        this.mes = mes;
        this.total = total;
    }


    private String nombre;
    private String apellido1;
    private String apellido2;
    private String tipo_persona;
    private String mes;
    private String total;


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

    public String getTipo_persona() {
        return tipo_persona;
    }

    public void setTipo_persona(String tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
