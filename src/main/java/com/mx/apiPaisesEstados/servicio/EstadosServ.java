package com.mx.apiPaisesEstados.servicio;

import java.util.List;

import com.mx.apiPaisesEstados.dominio.Estados;

public interface EstadosServ {
	
    public List<Estados> listar();
    
    public String guardar(Estados estado);//Validar que el id y nombre no se repita;id_pais exista
    
    public Estados buscar(Long id);
    
    public boolean editar(Estados estado);//Validar que el id exista y el id_pais exista
    
    public boolean eliminar(Long id);//Validar que el id exista
    
}
