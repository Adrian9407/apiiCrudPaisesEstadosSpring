package com.mx.apiPaisesEstados.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.apiPaisesEstados.dao.PaisesDao;
import com.mx.apiPaisesEstados.dominio.Paises;

@Service
public class PaisesImp implements PaisesServ{
	
	@Autowired
	PaisesDao dao;

	@Transactional(readOnly = true)
	@Override
	public List<Paises> listar() {
		
		return dao.findAll();
	}

	@Transactional
	@Override
	public String guardar(Paises pais) {
		String respuesta = "";
		for(Paises p:dao.findAll()) {
			if(p.getId().equals(pais.getId())) {
				respuesta = "id existe";
				break;
			}else if(p.getNombre().equals(pais.getNombre())) {
				respuesta = "Nombre Existe";
				break;
			}
				
		}
		if(respuesta == "")
			dao.save(pais);
		return null;
	}
    
	@Transactional
	@Override
	public Paises buscar(Long id) {
		
		return dao.findById(id).orElse(null);
	}
    
	@Transactional
	@Override
	public boolean editar(Paises pais) {
		
		for(Paises p: dao.findAll()) {
			if(p.getId().equals(pais.getId())) {
				dao.save(pais);
				return  true;
			}
		}
		return false;
	}

	@Override
	public boolean eliminar(Long id) {
		

		for(Paises p: dao.findAll()) {
			if(p.getId().equals(id)) {
				dao.deleteById(id);;
				return  true;
			}
		}
		return false;
	}
       
}
