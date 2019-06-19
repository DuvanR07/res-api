package com.restaurante.resapi.repository;

import com.restaurante.resapi.entity.E_Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository("PersonaRepository")
public interface PersonaRepository extends JpaRepository<E_Persona, Long> {

    public abstract List<E_Persona> findByNombreIsLike(String nombre);

    public abstract List<E_Persona> findByTipo(String tipo);

    public abstract List<E_Persona> findByNombreContaining(String nombre);

    public abstract List<E_Persona> findByTipoAndNombreContaining(String tipo,String nombre);

    public abstract E_Persona findById(Integer id);

    @Query(value = "SELECT * FROM persona p WHERE nombre LIKE  %:ape%",nativeQuery = true)
    public abstract List<E_Persona> caca(@Param("ape") String ape);





}
