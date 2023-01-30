package com.qaracter.domain;

import lombok.Data;

@Data
public class Elfo extends Personaje{
	private Integer vidaInicial;

	public Elfo(Integer vida, Integer ataque, Integer defensa, Integer velocidad, String nombre) {
		super(vida, ataque, defensa, velocidad, nombre);
		vidaInicial = vida;
	}

	public void especialElfo() {
		System.out.println("Especial elfo ...");
	}
	
	public void meditar() {
		setVida(getVidaInicial());
	}
}
