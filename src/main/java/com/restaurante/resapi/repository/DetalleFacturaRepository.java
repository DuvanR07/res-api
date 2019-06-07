package com.restaurante.resapi.repository;

import com.restaurante.resapi.entity.E_Detalle_Factura;
import com.restaurante.resapi.entity.E_Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface DetalleFacturaRepository extends JpaRepository<E_Detalle_Factura, Serializable> {

}
