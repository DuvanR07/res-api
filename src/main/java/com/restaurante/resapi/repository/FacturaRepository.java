package com.restaurante.resapi.repository;

import com.restaurante.resapi.entity.E_Detalle_Factura;
import com.restaurante.resapi.entity.E_Factura;
import com.restaurante.resapi.entity.E_Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface FacturaRepository extends JpaRepository<E_Factura, Long> {
}
