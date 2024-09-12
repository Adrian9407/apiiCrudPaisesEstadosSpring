package com.mx.apiPaisesEstados.dominio;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*CREATE TABLE PAISES(
ID NUMBER PRIMARY KEY,
NOMBRE VARCHAR2(80) NOT NULL,
IDIOMA VARCHAR2(70) NOT NULL
);*/

@Entity
@Table(name = "PAISES")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Paises {
	
	//Mapear los campos de la tabla
	
	@Id
    @Column(name="ID")
	private Long id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="IDIOMA")
	private String idioma;
	
	
	//Con esto realizamos la relacion de las entidades 
	//Cardinalidad -----1 pais tiene muchos estados
	//@JsonIgnore ---con esto le decimos que vamos a ignorar una lista de propiedades
	@OneToMany(mappedBy = "pais", cascade=CascadeType.ALL)
	@JsonIgnore
	List<Estados> lista = new ArrayList<>();

	
	
}
