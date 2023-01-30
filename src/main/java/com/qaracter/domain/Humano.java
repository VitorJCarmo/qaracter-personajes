package com.qaracter.domain;;

public class Humano extends Personaje{

	public Humano(Integer vida, Integer ataque, Integer defensa, Integer velocidad, String nombre) {
		super(vida, ataque, defensa, velocidad, nombre);
	}

	public void especialHumano() {
		System.out.println("Especial humano...");
	}
}
