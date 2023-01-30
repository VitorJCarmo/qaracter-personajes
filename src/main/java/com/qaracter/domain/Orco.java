package com.qaracter.domain;;

public class Orco extends Personaje {

	public Orco(Integer vida, Integer ataque, Integer defensa, Integer velocidad, String nombre) {
		super(vida, ataque, defensa, velocidad, nombre);
	}

	public void souUnOrco() {
		System.out.println("Soy Un Orco...");
	}
}
