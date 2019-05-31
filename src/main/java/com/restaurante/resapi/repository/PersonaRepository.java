package com.restaurante.resapi.repository;

import com.restaurante.demo.entity.E_Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("PersonaRepository")
public interface PersonaRepository extends CrudRepository<E_Persona, Serializable> {
}
