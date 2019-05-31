package com.restaurante.resapi.service;

import com.restaurante.resapi.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("PersonaService")
public class PersonaService {

    @Autowired
    @Qualifier("PersonaRepository")
    private PersonaRepository personaRepository;




}
