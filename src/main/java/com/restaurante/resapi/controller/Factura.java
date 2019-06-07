package com.restaurante.resapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.restaurante.resapi.config.Response_data;
import com.restaurante.resapi.entity.E_Detalle_Factura;
import com.restaurante.resapi.entity.E_Factura;
import com.restaurante.resapi.entity.E_Mesa;
import com.restaurante.resapi.entity.E_Persona;
import com.restaurante.resapi.model.Factura_model;
import com.restaurante.resapi.model.Persona_model;
import com.restaurante.resapi.repository.DetalleFacturaRepository;
import com.restaurante.resapi.repository.FacturaRepository;
import com.restaurante.resapi.repository.MesaRepository;
import com.restaurante.resapi.repository.PersonaRepository;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping(path = "/Factura")
public class Factura {
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private MesaRepository mesaRepository;
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;


    @PostMapping(path = "/guardar")
    public @ResponseBody
    Response_data crearFactura(HttpServletRequest request, @RequestParam(name = "id_camarero") long id_camarero, @RequestParam(name = "id_cliente") long id_cliente, @RequestParam(name = "id_mesa") long id_mesa) {


        Response_data response_data = new Response_data();
        E_Persona cliente = new E_Persona();
        E_Persona camarero = new E_Persona();
        E_Mesa mesa = new E_Mesa();
        E_Factura factura = new E_Factura();


        try {
            cliente = personaRepository.findById(id_cliente).get();
            camarero = personaRepository.findById(id_camarero).get();
            mesa = mesaRepository.findById(id_mesa).get();

            LocalDateTime ldt = LocalDateTime.now();
        //    String fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt);

            factura.setFecha_factura(new Date());
            factura.setCliente(cliente);
            factura.setCamarero(camarero);
            factura.setMesa(mesa);

            factura = facturaRepository.save(factura);


            JsonParser strParser = JsonParserFactory.getJsonParser();
            List<Object> lista = strParser.parseList(request.getParameter("detalle"));

            for (Object o : lista) {
                if (o instanceof Map) {
                    HashMap<String, Object> item = (HashMap<String, Object>) o;
                    E_Detalle_Factura detalle_factura = new E_Detalle_Factura();
                    detalle_factura.setPlato(item.get("plato").toString());
                    detalle_factura.setValor(Integer.parseInt(item.get("valor").toString()));
                    detalle_factura.setCocinero(personaRepository.findById(Long.parseLong(item.get("id_cocinero").toString())).get());
                    detalle_factura.setFactura(factura);
                    System.out.println("ID DETALLE: " + factura.getId());
                    detalleFacturaRepository.save(detalle_factura);

                }
            }

            response_data = new Response_data("Registro guardado exitosamente " + id_cliente, false, factura);

        } catch (Exception ex) {
            response_data = new Response_data("Error al guardar el registro " + id_cliente, true, factura);
            System.err.println(ex);
        }

        return response_data;

    }


}
