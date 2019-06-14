package com.restaurante.resapi.controller;

import com.restaurante.resapi.entity.E_Persona;
import com.restaurante.resapi.model.Camareros_model;
import com.restaurante.resapi.repository.CamarerosRepository;
import com.restaurante.resapi.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController     // This means that this class is a Controller
@RequestMapping(path = "/Persona")
public class Persona {
    @Autowired
    private PersonaService personaService;

    @Autowired
    private CamarerosRepository camarerosRepository;


    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearUsuario(@RequestBody E_Persona persona) {
        E_Persona personaNew = null;
        Map<String, Object> response = new HashMap<>();

        try {
            personaNew = personaService.save(persona);

        } catch (DataAccessException ex) {
            response.put("message", "Error al guardar el registro");
            response.put("err", true);
            response.put("info", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        response.put("message", "Guardado exitosamente");
        response.put("err", false);
        response.put("data", personaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }


    @GetMapping(path = "/listar")
    public @ResponseBody
    Iterable<E_Persona> listarUsuarios() {
        return personaService.findAll();
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable long id) {
        Map<String, Object> response = new HashMap<>();

        try {
           // E_Persona usuarioParaEliminar = personaRepository.findById(id).get();
            personaService.delete(id);

        } catch (DataAccessException ex) {
            response.put("message", "No se ha podido eliminar");
            response.put("err", true);
            response.put("info", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Borrado exitosamente");
        response.put("err", false);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }


    //LISTA DE PERSONAS POR TIPO

    @GetMapping(path = "/camareros")
    public @ResponseBody
    Iterable<E_Persona> listarCamareros(@RequestParam(name = "search") String nombre) {
        return personaService.findByTipoAndNombreContaining("Camarero", nombre);
    }

    @GetMapping(path = "/clientes")
    public @ResponseBody
    Iterable<E_Persona> listarClientes(@RequestParam(name = "search") String nombre) {
        return personaService.findByTipoAndNombreContaining("Cliente", nombre);
    }

    @GetMapping(path = "/cocineros")
    public @ResponseBody
    Iterable<E_Persona> listarCoconeros(@RequestParam(name = "search") String nombre) {
        return personaService.findByTipoAndNombreContaining("Cocinero", nombre);
    }

    //CONSULTAS CON NATIVE QUERY

    /*
    @GetMapping(path = "/camareroslista")
    public  @ResponseBody
    List<?> cam(){
        return camarerosRepository.camareros();
    }

     */



}


