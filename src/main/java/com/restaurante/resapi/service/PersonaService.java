package com.restaurante.demo.service;

import com.restaurante.demo.repository.PersonaRepository;
import convertidor.PersonaConvertidor;
import convertidor.PersonaConvertidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service("PersonaService")
public class PersonaService {

    @Autowired
    @Qualifier("PersonaRepository")
    private PersonaRepository personaRepository;




}
