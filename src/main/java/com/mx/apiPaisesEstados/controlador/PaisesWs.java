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

import com.mx.apiPaisesEstados.dominio.Paises;
import com.mx.apiPaisesEstados.servicio.PaisesImp;

@RestController
@RequestMapping(path = "PaisesWs")
@CrossOrigin
public class PaisesWs {
	
	@Autowired
	PaisesImp imp;
	
	//http://localhost:9000/PaisesWs/listar
	@GetMapping(path = "listar")
	public List<Paises> listar(){
		return imp.listar();
	}
	
	//http://localhost:9000/PaisesWs/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Paises pais){
   
		String respon = imp.guardar(pais);
	if(respon.equals("id existe"))
		return new ResponseEntity<>("Ese id ya existe",HttpStatus.OK);
	else if(respon.equals("Nombre Existe"))
		return new ResponseEntity<>("Ese nombre ya existe",HttpStatus.OK);
	else {
		return new ResponseEntity<>(pais,HttpStatus.CREATED);
	}
		
}
	
	//http://localhost:9000/PaisesWs/buscar
	@PostMapping(path = "buscar")
	public Paises buscar(@RequestBody Paises pais) {
		return imp.buscar(pais.getId());
	}
	
	//http://localhost:9000/PaisesWs/editar
	@PostMapping(path = "editar")
	public ResponseEntity<?>editar(@RequestBody Paises pais){
		boolean respon = imp.editar(pais);
		
		if(respon == false)
			return new ResponseEntity<>("Ese id no existe", HttpStatus.OK);
		else {
			return new ResponseEntity<>(pais, HttpStatus.CREATED);
	}
	}
	
	
	//http://localhost:9000/PaisesWs/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Paises pais){
		boolean respon = imp.eliminar(pais.getId());
		if(respon == false)
			return new ResponseEntity<String>("Ese id no existe", HttpStatus.OK);
		else {
			return new ResponseEntity<String>("Registro eliminado con exito", HttpStatus.OK);
		}
	}
	
}
