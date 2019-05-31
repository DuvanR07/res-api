package com.restaurante.demo.controller;

import com.restaurante.demo.config.Response_data;
import com.restaurante.demo.entity.E_Persona;
import com.restaurante.demo.model.Camareros_model;
import com.restaurante.demo.repository.CamarerosRepository;
import com.restaurante.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController     // This means that this class is a Controller
@RequestMapping(path = "/Persona")
public class Persona {
    @Autowired
    private PersonaRepository personaRepository;
    private CamarerosRepository camarerosRepository;

    @PostMapping(path = "/guardar")
    public @ResponseBody Response_data crearUsuario(E_Persona persona) {
        Response_data response_data;
        try {
            personaRepository.save(persona);
             response_data = new Response_data("Registro guardado exitosamente",false,null);

        }catch (Exception ex){
            personaRepository.save(persona);
             response_data = new Response_data("Error al guardar el registro",true,null);
        }
        return  response_data;

    }


    @GetMapping(path = "/listar")
    public @ResponseBody Iterable<E_Persona> listarUsuarios() {
           return personaRepository.findAll();
    }

    @GetMapping(path = "/eliminar/{id}")
    public @ResponseBody  Response_data eliminarUsuario(@PathVariable(name="id") long id) {
        E_Persona usuarioParaEliminar = personaRepository.findById(id).get();
        personaRepository.delete(usuarioParaEliminar);

        Response_data response_data;
        try {
            personaRepository.delete(usuarioParaEliminar);
            response_data = new Response_data("Registro borrado exitosamente",false,null);

        }catch (Exception ex){
            personaRepository.delete(usuarioParaEliminar);
            response_data = new Response_data("Error al borrar el registro",true,null);
        }
        return  response_data;

    }


    @GetMapping(path = "/camareros")
    public List<Camareros_model> listarCamareros() {
        return camarerosRepository.TraerCamareros();
    }
}
