package com.restaurante.resapi.repository;

import com.restaurante.resapi.controller.Persona;
import com.restaurante.resapi.entity.E_Persona;
import com.restaurante.resapi.model.Persona_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("PersonaRepository")
public interface PersonaRepository extends JpaRepository<E_Persona, Serializable> {

    public abstract List<Persona_model> findByNombre(String nombre);

    public abstract List<Persona_model> findByTipo(String tipo);


}
