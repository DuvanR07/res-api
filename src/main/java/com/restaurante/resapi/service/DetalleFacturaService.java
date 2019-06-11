package com.restaurante.resapi.service;

import com.restaurante.resapi.entity.E_Detalle_Factura;
import com.restaurante.resapi.repository.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    public E_Detalle_Factura save(E_Detalle_Factura detalle_factura) {
        return detalleFacturaRepository.save(detalle_factura);
    }
}
