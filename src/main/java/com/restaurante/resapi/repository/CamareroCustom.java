package com.restaurante.resapi.repository;

import com.restaurante.resapi.model.Camareros_model;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CamareroCustom {
    public List<Camareros_model> camareros();
}
