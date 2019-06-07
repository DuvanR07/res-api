package com.restaurante.resapi.repository;

import com.restaurante.resapi.entity.E_Persona;
import com.restaurante.resapi.model.Camareros_model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Repository("CamarerosRepository")
public class CamarerosRepository implements CamareroCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Camareros_model> camareros() {
    return  entityManager.createQuery("SELECT\n" +
            "persona.nombre,\n" +
            "persona." +
            "apellido1,\n" +
            "persona.apellido2,\n" +
            "persona.tipo,\n" +
            "COALESCE(factura.fecha_factura,\"No registra\") AS mes,\n" +
            "COALESCE(SUM(detalle_factura.valor),\"0\") AS total\n" +
            "FROM\n" +
            "    res_api.detalle_factura\n" +
            "   INNER JOIN res_api.factura \n" +
            "        ON (detalle_factura.id_factura = factura._id)\n" +
            "   RIGHT JOIN res_api.persona \n" +
            "        ON (factura.id_camarero = persona._id)\n" +
            "        WHERE persona.tipo=\"Camarero\"\n" +
            "        GROUP BY MONTH(factura.fecha_factura), persona._id",Camareros_model.class)
                .getResultList();

    }
}
