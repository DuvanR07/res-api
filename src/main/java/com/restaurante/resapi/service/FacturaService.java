package com.restaurante.resapi.service;

import com.restaurante.resapi.entity.E_Factura;
import com.restaurante.resapi.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

   public E_Factura save(E_Factura factura){
        return facturaRepository.save(factura);
    }
}
