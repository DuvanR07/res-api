package com.restaurante.resapi.controller;

import com.restaurante.resapi.config.Response_data;
import com.restaurante.resapi.entity.E_Persona;
import com.restaurante.resapi.model.Camareros_model;
import com.restaurante.resapi.model.Persona_model;
import com.restaurante.resapi.repository.CamarerosRepository;
import com.restaurante.resapi.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController     // This means that this class is a Controller
@RequestMapping(path = "/Persona")
public class Persona {
    @Autowired
    private PersonaRepository personaRepository;
    private CamarerosRepository camarerosRepository;

    @PostMapping(path = "/guardar")
    public @ResponseBody
    Response_data crearUsuario(E_Persona persona) {
        Response_data response_data;
        try {
            personaRepository.save(persona);
            response_data = new Response_data("Registro guardado exitosamente", false, null);

        } catch (Exception ex) {
            personaRepository.save(persona);
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
    @GetMapping(path = "/nombre/{nombre}")
    public @ResponseBody
    Iterable<Persona_model> listarPersonas(@PathVariable(name = "nombre") String nombre) {
        return personaRepository.findByNombre(nombre);
    }

    @GetMapping(path = "/camareros")
    public @ResponseBody
    Iterable<Persona_model> listarCamareros() {
        return personaRepository.findByTipo("Camarero");
    }

    @GetMapping(path = "/clientes")
    public @ResponseBody
    Iterable<Persona_model> listarClientes() {
        return personaRepository.findByTipo("Cliente");
    }

    @GetMapping(path = "/cocineros")
    public @ResponseBody
    Iterable<Persona_model> listarCoconeros() {
        return personaRepository.findByTipo("Cocinero");
    }


    /*
    @GetMapping(path = "/camareros")
    public List<Camareros_model> listarCamareros() {
        return camarerosRepository.TraerCamareros();
    }


    public class ListaestudiantesController {
	  public List <Estudiantes> getEstudiantes(){
		  ArrayList<Estudiantes> est = new ArrayList<>();
		  est.add(new Estudiantes("1124865870","wilson","liñeiro","4205344"));
		  est.add(new Estudiantes("1124462870","darwin","quiroz","4205324"));
		  est.add(new Estudiantes("1124423870","mayra","lopez","4205354"));
		  return est;



	  }

    */
}


