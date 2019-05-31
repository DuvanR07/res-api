package com.restaurante.resapi.model;

import com.restaurante.resapi.entity.E_Detalle_Factura;
import com.restaurante.resapi.entity.E_Factura;
import com.restaurante.resapi.entity.E_Persona;

public class Detalle_Factura_model {
    public Detalle_Factura_model(E_Detalle_Factura e_detalle_factura) {

        this.id = e_detalle_factura.getId();
        this.factura = e_detalle_factura.getFactura();
        this.cocinero = e_detalle_factura.getCocinero();
        this.plato = e_detalle_factura.getPlato();
        this.valor = e_detalle_factura.getValor();
    }


    public Detalle_Factura_model(long id, E_Factura factura, E_Persona cocinero, String plato, long valor) {
        this.id = id;
        this.factura = factura;
        this.cocinero = cocinero;
        this.plato = plato;
        this.valor = valor;
    }


    private long id;
    private E_Factura factura;
    private E_Persona cocinero;
    private String plato;
    private long valor;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public E_Factura getFactura() {
        return factura;
    }

    public void setFactura(E_Factura factura) {
        this.factura = factura;
    }

    public E_Persona getCocinero() {
        return cocinero;
    }

    public void setCocinero(E_Persona cocinero) {
        this.cocinero = cocinero;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }
}
