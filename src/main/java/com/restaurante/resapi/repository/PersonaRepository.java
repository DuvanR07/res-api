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



}
