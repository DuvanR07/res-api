package com.restaurante.resapi.entity;

import javax.persistence.*;

@Table(name = "detalle_factura")
@Entity
public class E_Detalle_Factura {

    public E_Detalle_Factura() {

    }

    public E_Detalle_Factura(long id, E_Factura factura, E_Persona cocinero, String plato, long valor) {
        this.id = id;
        this.factura = factura;
        this.cocinero = cocinero;
        this.plato = plato;
        this.valor = valor;
    }

    @GeneratedValue
    @Id
    @Column(name = "_id")
    private long id;

    @JoinColumn(name = "id_factura")
    @OneToOne(cascade = CascadeType.ALL)
    private E_Factura factura;

    @JoinColumn(name = "id_cocinero")
    @OneToOne(cascade = CascadeType.ALL)
    private E_Persona cocinero;

    @Column(name = "plato")
    private String plato;

    @Column(name = "valor")
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
