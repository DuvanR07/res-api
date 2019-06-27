package com.restaurante.resapi.controller;

import com.restaurante.resapi.config.Response_data;
import com.restaurante.resapi.entity.E_Mesa;
import com.restaurante.resapi.entity.E_Persona;
import com.restaurante.resapi.repository.MesaRepository;
import com.restaurante.resapi.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(path = "/Mesa")
public class Mesa {
    @Autowired
    private MesaService mesaService;

    @PostMapping(path = "/guardar")
    public @ResponseBody
    ResponseEntity<?> crearUsuario(@RequestBody E_Mesa mesa) {
        E_Mesa mesaNew = null;
        Map<String, Object> response = new HashMap<>();

        try {
            mesaNew = mesaService.save(mesa);

        } catch (DataAccessException ex) {
            response.put("message", "Error al guardar el registro");
            response.put("err", true);
            response.put("info", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Guardado exitosamente");
        response.put("err", false);
        response.put("data", mesaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);


    }

    @DeleteMapping(path = "/eliminar/{id}")
    public @ResponseBody
    ResponseEntity<?> eliminarMesa(@PathVariable(name = "id") long id) {

        Map<String, Object> response = new HashMap<>();
        try {
            mesaService.delete(id);
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


    @GetMapping(path = "/listar")
    public @ResponseBody
    ResponseEntity<?> listarUsuarios() {

        Map<String, Object> response = new HashMap<>();
        List<E_Mesa> mesas = null;

        try {
            mesas = mesaService.findAll();

        } catch (DataAccessException ex) {
            response.put("message", "Error al ejecutar la consulta");
            response.put("err", true);
            response.put("info", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", "Se han encontrado " + mesas.size() + " resultados");
        response.put("err", false);
        response.put("data", mesas);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


    @GetMapping(path = "/page/{page}")
    public @ResponseBody
    Page<?> index(@PathVariable Integer page, @RequestParam(name = "size", defaultValue = "10") Integer size) {

        if (page <= 0 || page == null) {
            page = 1;
        }

        size = (size <= 0) ? 10 : size;

        Pageable pageable = PageRequest.of((page - 1), size);
        Page<E_Mesa> mesas = null;

        try {
            mesas = mesaService.findPage(pageable);

        } catch (DataAccessException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return mesas;

    }

}
