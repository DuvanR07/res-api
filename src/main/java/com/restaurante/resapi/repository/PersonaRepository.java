package com.restaurante.resapi.repository;

import com.restaurante.resapi.controller.Persona;
import com.restaurante.resapi.entity.E_Persona;
import com.restaurante.resapi.model.Camareros_model;
import com.restaurante.resapi.model.Persona_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;

@Repository("PersonaRepository")
public interface PersonaRepository extends JpaRepository<E_Persona, Serializable> {

    public abstract List<Persona_model> findByNombreIsLike(String nombre);

    public abstract List<Persona_model> findByTipo(String tipo);

    public abstract List<Persona_model> findByNombreContaining(String nombre);

    public abstract List<Persona_model> findByTipoAndNombreContaining(String tipo,String nombre);

    public abstract E_Persona findById(Integer id);

    @Query(value = "SELECT * FROM persona p WHERE nombre LIKE  %:ape%",nativeQuery = true)
    public abstract List<E_Persona> caca(@Param("ape") String ape);


    @Query(value = "SELECT\n" +
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
            "        GROUP BY MONTH(`factura`.`fecha_factura`), `persona`._id", nativeQuery = true)
    public  abstract List<Camareros_model> camareros();


}
