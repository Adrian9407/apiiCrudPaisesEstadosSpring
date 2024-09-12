package com.mx.apiPaisesEstados.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.apiPaisesEstados.dominio.Estados;

import com.mx.apiPaisesEstados.servicio.EstadosImp;

@RestController
@RequestMapping(path = "EstadosWs")
@CrossOrigin

public class EstadosWs {

	@Autowired
	EstadosImp imp;
	
	
	//http://localhost:9000/EstadosWs/listar
	@GetMapping("listar")
	public List<Estados> listar(){
		return imp.listar();
	}
	
	
	//http://localhost:9000/EstadosWs/guardar
	@PostMapping("guardar")
	public ResponseEntity<String> guardar(@RequestBody Estados estado) {
		String respond = imp.guardar(estado);
		
		if(respond.equals("Id_EstadoExiste"))
			return new ResponseEntity<String>("No se puede guardar por que el IdEstado ya existe", HttpStatus.OK);
		else if(respond.equals("nombreExiste"))
			return new ResponseEntity<String>("No se puede guardar por que el nombreEstado ya existe",HttpStatus.OK);
		else if(respond.equals("idPaisNoExiste"))
			return new ResponseEntity<String>("No se puede guardar por que la IdPais no existe",HttpStatus.OK);
		else {
			return new ResponseEntity<String>("Guardado correctamente", HttpStatus.OK);
		}
	}
	
	
	//http://localhost:9000/EstadosWs/buscar
	@PostMapping(path = "buscar")
	public Estados buscar(@RequestBody Estados estado) {
		return imp.buscar(estado.getId());
	}
	
	
	
	
	//http://localhost:9000/EstadosWs/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Estados estado){
		boolean respon = imp.eliminar(estado.getId());
		if(respon == false)
			return new ResponseEntity<String>("Ese id no existe", HttpStatus.OK);
		else {
			return new ResponseEntity<String>("Registro eliminado con exito", HttpStatus.OK);
		}
	}
}

