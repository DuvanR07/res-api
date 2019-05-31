package com.restaurante.resapi.model;

import com.restaurante.demo.entity.E_Mesa;

public class Mesa_model {

    public Mesa_model(E_Mesa e_mesa) {

        this.id = e_mesa.getId();
        this.num_max = e_mesa.getNum_max();
        this.ubicacion = e_mesa.getUbicacion();
    }

    public Mesa_model(long id, long num_max, String ubicacion) {
        this.id = id;
        this.num_max = num_max;
        this.ubicacion = ubicacion;
    }

    private long id;
    private long num_max;
    private String ubicacion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
