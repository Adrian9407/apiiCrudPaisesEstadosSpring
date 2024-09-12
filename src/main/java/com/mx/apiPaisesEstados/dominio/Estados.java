package com.mx.apiPaisesEstados.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 CREATE TABLE ESTADOS(
ID NUMBER PRIMARY KEY,
NOMBRE VARCHAR2(80) NOT NULL,
CLIMA VARCHAR2(70) NOT NULL,
ID_PAIS NUMBER NOT NULL,
FOREIGN KEY(ID_PAIS) REFERENCES PAISES(ID)
ON DELETE CASCADE
);
 */


@Entity
@Table(name = "ESTADOS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Estados {
	
	//Mapear los campos
	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name  = "CLIMA")
	private String clima;
	
	//FetchType --- Con esto le indicamos que la relacion debe ser cargada al momento
	//Cardinalidad --- Muchos estados pertenecen a un pais
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PAIS")
	Paises pais;

}
