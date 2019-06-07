package com.restaurante.resapi.repository;

import com.restaurante.resapi.entity.E_Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface MesaRepository extends JpaRepository<E_Mesa, Serializable> {

    public abstract E_Mesa findById(Integer id);
}
