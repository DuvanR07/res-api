package com.restaurante.resapi.model;

import com.restaurante.resapi.entity.E_Factura;
import com.restaurante.resapi.entity.E_Mesa;
import com.restaurante.resapi.entity.E_Persona;

public class Factura_model {


    public Factura_model(E_Factura e_factura){

        this.id = e_factura.getId();
        this.cliente = e_factura.getCliente();
        this.camarero = e_factura.getCamarero();
        this.mesa = e_factura.getMesa();
        this.fecha_factura = e_factura.getFecha_factura();
    }




    public Factura_model(long id, E_Persona cliente, E_Persona camarero, E_Mesa mesa, long fecha_factura) {
        this.id = id;
        this.cliente = cliente;
        this.camarero = camarero;
        this.mesa = mesa;
        this.fecha_factura = fecha_factura;
    }

    private long id;


    private E_Persona cliente;


    private E_Persona camarero;


    private E_Mesa mesa;



    private long fecha_factura;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public E_Persona getCliente() {
        return cliente;
    }

    public void setCliente(E_Persona cliente) {
        this.cliente = cliente;
    }

    public E_Persona getCamarero() {
        return camarero;
    }

    public void setCamarero(E_Persona camarero) {
        this.camarero = camarero;
    }

    public E_Mesa getMesa() {
        return mesa;
    }

    public void setMesa(E_Mesa mesa) {
        this.mesa = mesa;
    }

    public long getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(long fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

}
