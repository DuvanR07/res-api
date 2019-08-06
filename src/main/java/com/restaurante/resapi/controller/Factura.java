package com.restaurante.resapi.controller;

import com.restaurante.resapi.entity.E_Detalle_Factura;
import com.restaurante.resapi.entity.E_Factura;
import com.restaurante.resapi.entity.E_Mesa;
import com.restaurante.resapi.entity.E_Persona;
import com.restaurante.resapi.service.DetalleFacturaService;
import com.restaurante.resapi.service.FacturaService;
import com.restaurante.resapi.service.MesaService;
import com.restaurante.resapi.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/Factura")
public class Factura {
    @Autowired
private PersonaService personaService;

    @Autowired
    private DetalleFacturaService detalleFacturaService;

    @Autowired
    private MesaService mesaService;

    @Autowired
    private FacturaService facturaService;


    @PostMapping(path = "/guardar")
    ResponseEntity<?> crearFactura(@RequestBody Map<String,Object> request) {

        Map<String, Object> response = new HashMap<>();

        E_Persona cliente = new E_Persona();
        E_Persona camarero = new E_Persona();
        E_Mesa mesa = new E_Mesa();
        E_Factura factura = new E_Factura();

        try {
            cliente = personaService.findById(Long.parseLong(request.get("id_cliente").toString()));
            camarero = personaService.findById(Long.parseLong(request.get("id_camarero").toString()));
            mesa = mesaService.findById(Long.parseLong(request.get("id_mesa").toString()));

        }catch (Exception ex){
            System.err.println(ex.getMessage());
            response.put("message", "Error al comprobar las llaves foraneas");
            response.put("err", true);
            response.put("info", ex.getMessage().concat(": ").concat(ex.getCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        factura.setFecha_factura(new Date());
        factura.setCliente(cliente);
        factura.setCamarero(camarero);
        factura.setMesa(mesa);

        List<Object> lista = (List<Object>) request.get("detalle");
       // JsonParser strParser = JsonParserFactory.getJsonParser();
       // List<Object> lista = strParser.parseList(request.getParameter("detalle"));

        if (lista.isEmpty()){
            response.put("message", "El detalle de la factura no puede estar vacio");
            response.put("err", true);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_ACCEPTABLE);
        }

        try {

            factura = facturaService.save(factura);

            for (Object o : lista) {
                if (o instanceof Map) {
                    HashMap<String, Object> item = (HashMap<String, Object>) o;
                    E_Detalle_Factura detalle_factura = new E_Detalle_Factura();
                    detalle_factura.setPlato(item.get("plato").toString());
                    detalle_factura.setValor(Integer.parseInt(item.get("valor").toString()));
                    detalle_factura.setCocinero(personaService.findById(Long.parseLong(item.get("id_cocinero").toString())));
                    detalle_factura.setFactura(factura);
                    detalleFacturaService.save(detalle_factura);
                }
            }

        } catch (DataAccessException ex) {
            response.put("message", "Error al guardar la factura");
            response.put("err", true);
            response.put("info", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", "Guardado exitosamente");
        response.put("err", false);
        response.put("data", factura);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);


    }





}
