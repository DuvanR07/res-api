package com.restaurante.resapi.service;

import com.restaurante.resapi.entity.E_Mesa;
import com.restaurante.resapi.entity.E_Persona;
import com.restaurante.resapi.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MesaService  {

    @Autowired
    private MesaRepository mesaRepository;

    @Transactional(readOnly = true)
    public List<E_Mesa> findAll() {
        return (List<E_Mesa>)  mesaRepository.findAll();
    }

    public E_Mesa save(E_Mesa mesa){
        return  mesaRepository.save(mesa);
    }

    public  void  delete(Long id){
        mesaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public E_Mesa findById(Long id){
        return mesaRepository.findById(id).orElse(null);
    }


}
