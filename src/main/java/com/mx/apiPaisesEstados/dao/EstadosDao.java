package com.mx.apiPaisesEstados.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.apiPaisesEstados.dominio.Estados;

public interface EstadosDao extends JpaRepository<Estados, Long>{

}
