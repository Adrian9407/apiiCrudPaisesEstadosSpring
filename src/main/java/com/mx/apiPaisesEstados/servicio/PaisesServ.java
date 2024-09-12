package com.mx.apiPaisesEstados.servicio;

import java.util.List;

import com.mx.apiPaisesEstados.dominio.Paises;

public interface PaisesServ {

	public List<Paises> listar();
	
	public String guardar(Paises pais);//Validar que el id y nombre no se repita
	
	public Paises buscar(Long id);
	
	public boolean editar(Paises pais);//Validar que el id exista
	
	public boolean eliminar(Long id);// Validar que el id exista 
}
