package com.restaurante.resapi.repository;

import com.restaurante.resapi.config.Global;
import com.restaurante.resapi.model.Camareros_model;
import com.restaurante.resapi.model.Clientes_model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ConsultasRepository {
    @Autowired
    private EntityManager em;

    public List<Camareros_model> camareros() {

        List<Object[]> lista = em.createNativeQuery(Camareros_model.sql).getResultList();
        List<Camareros_model> listaCamareros = new ArrayList<>();
        Map<String, Object> data = new HashMap<>();

        for (Object[] ob : lista) {
            Camareros_model camarero = new Camareros_model();
            camarero.setNombre(ob[0].toString());
            camarero.setApellido1(ob[1].toString());
            camarero.setApellido2(ob[2].toString());
            camarero.setTipo(ob[3].toString());
            // camarero.setMes(Global.mes(Integer.parseInt(ob[4].toString())));
            //  camarero.setTotal(Integer.parseInt( ob[5].toString()));

            listaCamareros.add(camarero);
        }

        return listaCamareros;
    }


    public List<Clientes_model> clientes() {

        List<Object[]> lista = em.createNativeQuery(Clientes_model.sql).getResultList();
        List<Clientes_model> listaClientes = new ArrayList<>();
        Map<String, Object> data = new HashMap<>();

        for (Object[] ob : lista) {
            Clientes_model cliente = new Clientes_model();
            cliente.setNombre(ob[0].toString());
            cliente.setApellido1(ob[1].toString());
            cliente.setTipo(ob[3].toString());
            cliente.setTotal(Integer.parseInt(ob[5].toString()));
            listaClientes.add(cliente);
        }

        return listaClientes;
    }
}
