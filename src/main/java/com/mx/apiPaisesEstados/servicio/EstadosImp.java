package com.mx.apiPaisesEstados.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.apiPaisesEstados.dao.EstadosDao;
import com.mx.apiPaisesEstados.dao.PaisesDao;
import com.mx.apiPaisesEstados.dominio.Estados;
import com.mx.apiPaisesEstados.dominio.Paises;



@Service
public class EstadosImp implements EstadosServ {
	
	@Autowired
	PaisesDao paisesDao;
	
	@Autowired
	EstadosDao estadosDao;
    
	
	@Transactional(readOnly = true)
	@Override
	public List<Estados> listar() {
		
		return estadosDao.findAll() ;
	}
	
	//Ya viste donde te estabas equivocando? Contesta? en tu mapeo, en estados no tenias tu encapsulamiento lo tenias en pais, por eso no te detectaba los gettes y settesr, nos vemos
    
	@Transactional
	@Override
	public String guardar(Estados estado) {
		
		String respuesta = "";
		boolean banderaPais = false;
		boolean banderaEstado = false;
		
		//Id y nombre no se repita----estado
		//id_pais exista
		
		for(Paises pa:paisesDao.findAll()) {
			//Que id_pais exista
			if(pa.getId().equals(estado.getPais().getId())) {
				banderaPais = true;
				for(Estados es:estadosDao.findAll()) {
					//ese id_estado ya existe 
					if(es.getId().equals(estado.getId())) {
						respuesta = "Id_EstadoExiste";
						banderaEstado = true;
					}else if(es.getNombre().equals(estado.getNombre())) {
						respuesta = "NombreExiste";
						banderaEstado = true;
					}
				}
				
				break;
			}
		}
		if(banderaPais == false) {
			respuesta = "idPaisnoExiste";
			banderaEstado = true;
		}else if(banderaEstado == false) {
			estadosDao.save(estado);
		}
		
		return respuesta;
	}

	@Transactional
	@Override
	public Estados buscar(Long id) {
		
		return estadosDao.findById(id).orElse(null);
	}
    
	@Transactional
	@Override
	public boolean editar(Estados estado) {
		
		for(Estados e: estadosDao.findAll()) {
			if(e.getId().equals(estado.getId())) {
				estadosDao.save(estado);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean eliminar(Long id) {
		for(Estados e: estadosDao.findAll()) {
			if(e.getId().equals(id)) {
				estadosDao.deleteById(id);;
				return  true;
			}
		}
		return false;
	}

	
	

}
