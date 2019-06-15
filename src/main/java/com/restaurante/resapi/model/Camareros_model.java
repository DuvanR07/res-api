package com.restaurante.resapi.model;


import java.io.Serializable;

public class Camareros_model implements Serializable {

    public Camareros_model(){

    }

    public Camareros_model(String nombre, String apellido1, String apellido2, String tipo, String mes, Integer total) throws  Exception {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.tipo = tipo;
        this.mes = mes;
        this.total = total;
    }


    private String nombre;
    private String apellido1;
    private String apellido2;
    private String tipo;
    private String mes;
    private Integer total;


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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public static String sql = "SELECT\n" +
            "persona.`nombre`,\n" +
            "`persona`.`apellido1`,\n" +
            "`persona`.`apellido2`,\n" +
            "`persona`.`tipo`,\n" +
            "COALESCE(MONTH(`factura`.`fecha_factura`),\"No registra\") AS mes,\n" +
            "COALESCE(SUM(`detalle_factura`.`valor`),\"0\") AS total\n" +
            "FROM\n" +
            "    `res_api`.`detalle_factura`\n" +
            "   INNER JOIN `res_api`.`factura` \n" +
            "        ON (`detalle_factura`.`id_factura` = `factura`.`_id`)\n" +
            "   RIGHT JOIN `res_api`.`persona` \n" +
            "        ON (`factura`.`id_camarero` = `persona`.`_id`)\n" +
            "        WHERE `persona`.`tipo`=\"Camarero\"\n" +
            "        GROUP BY MONTH(`factura`.`fecha_factura`), `persona`._id";
}
