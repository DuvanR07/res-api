package com.restaurante.resapi.repository;

import com.restaurante.demo.entity.E_Persona;
import com.restaurante.demo.model.Camareros_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("CamarerosRepository")
public interface CamarerosRepository extends JpaRepository<E_Persona, Object> {


    @Transactional
    @Procedure(procedureName = "camareros")
    public List<Camareros_model> TraerCamareros();


}
