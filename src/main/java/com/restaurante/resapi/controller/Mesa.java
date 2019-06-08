package com.restaurante.resapi.controller;

import com.restaurante.resapi.config.Response_data;
import com.restaurante.resapi.entity.E_Mesa;
import com.restaurante.resapi.entity.E_Persona;
import com.restaurante.resapi.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Mesa")
public class Mesa {
    @Autowired
    private MesaRepository mesaRepository;

    //buscar la manera de recibir cada dato
    @PostMapping(path = "/guardar")
    public @ResponseBody
    Response_data crearUsuario(E_Mesa mesa) {
        Response_data response_data;
        try {
            mesaRepository.save(mesa);
            response_data = new Response_data("Registro guardado exitosamente", false, null);

        } catch (Exception ex) {
          //  mesaRepository.save(mesa);
            response_data = new Response_data("Error al guardar el registro", true, mesa);
        }
        return response_data;

    }


    @GetMapping(path = "/listar")
    public @ResponseBody
    Iterable<E_Mesa> listarUsuarios() {
        return mesaRepository.findAll();
    }

    @GetMapping(path = "/eliminar/{id}")
    public @ResponseBody
    Response_data eliminarUsuario(@PathVariable(name = "id") long id) {
        E_Mesa mesaParaEliminar = mesaRepository.findById(id).get();
        mesaRepository.delete(mesaParaEliminar);

        Response_data response_data;
        try {
            mesaRepository.delete(mesaParaEliminar);
            response_data = new Response_data("Registro borrado exitosamente", false, null);

        } catch (Exception ex) {
          //  mesaRepository.delete(mesaParaEliminar);
            response_data = new Response_data("Error al borrar el registro", true, null);
        }
        return response_data;

    }
}
