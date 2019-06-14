package com.restaurante.resapi.repository;

import com.restaurante.resapi.model.Camareros_model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CamarerosRepository {
    @Autowired
    private EntityManager em;

    public List<?> camareros() {
        String sql = "SELECT\n" +
                "persona.`nombre`,\n" +
                "`persona`.`apellido1`,\n" +
                "`persona`.`apellido2`,\n" +
                "`persona`.`tipo`,\n" +
                "COALESCE(`factura`.`fecha_factura`,\"No registra\") AS mes,\n" +
                "COALESCE(SUM(`detalle_factura`.`valor`),\"0\") AS total\n" +
                "FROM\n" +
                "    `res_api`.`detalle_factura`\n" +
                "   INNER JOIN `res_api`.`factura` \n" +
                "        ON (`detalle_factura`.`id_factura` = `factura`.`_id`)\n" +
                "   RIGHT JOIN `res_api`.`persona` \n" +
                "        ON (`factura`.`id_camarero` = `persona`.`_id`)\n" +
                "        WHERE `persona`.`tipo`=\"Camarero\"\n" +
                "        GROUP BY MONTH(`factura`.`fecha_factura`), `persona`._id";

        List<Object[]> lista = new ArrayList<>();
        List<Map<String, Object>> listaCamareros = new ArrayList<>();
        lista = em.createNativeQuery(sql).getResultList();


        Map<String, Object> data = new HashMap<>();
        for (Object[] ob : lista) {
            data.put("nombre", ob[0]);
            data.put("apellido1", ob[1]);
            data.put("apellido2", ob[2]);
            data.put("tipo", ob[3]);
            data.put("mes", ob[4]);
            data.put("total", ob[5]);

            listaCamareros.add(data);
        }

        return em.createNativeQuery(sql).getResultList();

    }
}
