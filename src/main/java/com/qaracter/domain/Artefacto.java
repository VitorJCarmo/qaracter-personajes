package com.qaracter.domain;

import lombok.Data;

@Data
public class Artefacto {
	private String nombre;
	private Integer vida;
	private Integer ataque;
	private Integer defensa;
	private Integer velocidad;
	private boolean enUso;
	private Personaje personaje;

	public Artefacto(String nombre, Integer vida, Integer ataque, Integer defensa, Integer velocidad) {
		super();
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.velocidad = velocidad;
	}
}
