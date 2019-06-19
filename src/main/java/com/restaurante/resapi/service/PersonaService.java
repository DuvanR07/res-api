package com.restaurante.resapi.service;

import com.restaurante.resapi.entity.E_Persona;
import com.restaurante.resapi.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("PersonaService")
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    @Transactional(readOnly = true)
    public List<E_Persona> findAll() {
        return (List<E_Persona>) personaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<E_Persona> findPage(Pageable pageable) {
        return personaRepository.findAll(pageable);
    }


    @Transactional
    public E_Persona save(E_Persona persona) {
        return personaRepository.save(persona);
    }

    @Transactional
    public void delete(long id) {
        personaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public E_Persona findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<E_Persona> findByTipoAndNombreContaining(String tipo, String nombre) {
        return personaRepository.findByTipoAndNombreContaining(tipo, nombre);
    }
}
