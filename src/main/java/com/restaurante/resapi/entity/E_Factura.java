package com.restaurante.resapi.entity;

import javax.persistence.*;

@Table(name = "factura")
@Entity
public class E_Factura {

    public E_Factura() {

    }


    public E_Factura(long id, E_Persona cliente, E_Persona camarero, E_Mesa mesa, long fecha_factura) {
        this.id = id;
        this.cliente = cliente;
        this.camarero = camarero;
        this.mesa = mesa;
        this.fecha_factura = fecha_factura;
    }

    @GeneratedValue
    @Id
    @Column(name = "_id")
    private long id;

    @JoinColumn(name = "id_cliente")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private E_Persona cliente;


    @JoinColumn(name = "id_camarero")
    @OneToOne(cascade = CascadeType.ALL)
    private E_Persona camarero;

    @JoinColumn(name = "id_mesa")
    @OneToOne(cascade = CascadeType.ALL)
    private E_Mesa mesa;


    @Column(name = "fecha_factura")
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
