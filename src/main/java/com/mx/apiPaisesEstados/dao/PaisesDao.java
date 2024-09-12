package com.mx.apiPaisesEstados.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.apiPaisesEstados.dominio.Paises;

public interface PaisesDao extends JpaRepository<Paises, Long> {
	
	

}
