package com.restaurante.resapi.controller;

import com.restaurante.resapi.config.Response_data;
import com.restaurante.resapi.entity.E_Persona;
import com.restaurante.resapi.model.Camareros_model;
import com.restaurante.resapi.model.Persona_model;
import com.restaurante.resapi.repository.CamarerosRepository;
import com.restaurante.resapi.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController     // This means that this class is a Controller
@RequestMapping(path = "/Persona")
public class Persona {
    @Autowired
    private PersonaRepository personaRepository;


    private CamarerosRepository camarerosRepository;


    //buscar la manera de recibir cada dato
    @PostMapping(path = "/guardar")
    public @ResponseBody
    Response_data crearUsuario(E_Persona persona) {
        Response_data response_data;
        try {
            personaRepository.save(persona);
            response_data = new Response_data("Registro guardado exitosamente", false, null);

        } catch (Exception ex) {
            //personaRepository.save(persona);
            response_data = new Response_data("Error al guardar el registro", true, null);
        }
        return response_data;

    }


    @GetMapping(path = "/listar")
    public @ResponseBody
    Iterable<E_Persona> listarUsuarios() {
        return personaRepository.findAll();
    }

    @GetMapping(path = "/eliminar/{id}")
    public @ResponseBody
    Response_data eliminarUsuario(@PathVariable(name = "id") long id) {
        E_Persona usuarioParaEliminar = personaRepository.findById(id).get();
        personaRepository.delete(usuarioParaEliminar);

        Response_data response_data;
        try {
            personaRepository.delete(usuarioParaEliminar);
            response_data = new Response_data("Registro borrado exitosamente", false, null);

        } catch (Exception ex) {
            personaRepository.delete(usuarioParaEliminar);
            response_data = new Response_data("Error al borrar el registro", true, null);
        }
        return response_data;

    }


    //LISTA DE PERSONAS POR TIPO
    @GetMapping(path = "/nombre")
    public @ResponseBody
    E_Persona listarPersonas(@RequestParam(name = "name") long nombre) {
        return personaRepository.findById(nombre).get();
    }

    @GetMapping(path = "/camareros")
    public @ResponseBody
    Iterable<Persona_model> listarCamareros(@RequestParam(name = "search") String nombre) {
        return personaRepository.findByTipoAndNombreContaining("Camarero", nombre);
    }

    @GetMapping(path = "/clientes")
    public @ResponseBody
    Iterable<Persona_model> listarClientes(@RequestParam(name = "search") String nombre) {
        return personaRepository.findByTipoAndNombreContaining("Cliente", nombre);
    }

    @GetMapping(path = "/cocineros")
    public @ResponseBody
    Iterable<Persona_model> listarCoconeros(@RequestParam(name = "search") String nombre) {
        return personaRepository.findByTipoAndNombreContaining("Cocinero", nombre);
    }


    @GetMapping(path = "/cama")
    public @ResponseBody
    Iterable<Camareros_model> camareros() {

        try {
            return camarerosRepository.camareros();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return null;

    }



}


