package com.restaurante.resapi.model;

import java.io.Serializable;

public class Clientes_model  implements Serializable {

    private long id;
    private String nombre;
    private String apellido1;
    private String tipo;
    private long total;

    public Clientes_model(){

    }

    public Clientes_model(long id, String nombre, String apellido1, String tipo, long total) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.tipo = tipo;
        this.total = total;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public static String sql = "SELECT\n" +
            "`persona`.`_id`,\n" +
            "persona.`nombre`,\n" +
            "`persona`.`apellido1`,\n" +
            "`persona`.`tipo`,\n" +
            "SUM(`detalle_factura`.`valor`) AS valor\n" +
            "FROM\n" +
            "    `res_api`.`factura`\n" +
            "    INNER JOIN `res_api`.`persona` \n" +
            "        ON (`factura`.`id_cliente` = `persona`.`_id`)\n" +
            "    INNER JOIN `res_api`.`detalle_factura` \n" +
            "        ON (`detalle_factura`.`id_factura` = `factura`.`_id`)\n" +
            "        WHERE persona.`tipo`=\"Cliente\"\n" +
            "        GROUP BY `persona`.`_id`\n" +
            "        HAVING `valor` > 100000";
}
