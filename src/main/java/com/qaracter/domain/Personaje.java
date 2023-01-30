package com.qaracter.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.qaracter.exceptions.ItemInUseException;

import lombok.Data;
import lombok.var;

@Data
public class Personaje {
	private Integer vida;
	private Integer ataque;
	private Integer defensa;
	private Integer velocidad;
	private String nombre;
	private Integer randomNum;
	private List<Artefacto> artefactos;
	private final String PATH = "C:\\ficheroDetexto.txt";

	public Personaje(Integer vida, Integer ataque, Integer defensa, Integer velocidad, String nombre) {
		super();
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.velocidad = velocidad;
		this.nombre = nombre;
		this.randomNum = randomNum();
		this.artefactos = new ArrayList<Artefacto>();
	}

	public void luchar(Personaje p) {
		calculaAtaque(p);
		calculaDefensa(p);
	}

	@Override
	public String toString() {
		return "Personage " + nombre + "\nvida: " + vida + "\nataque: " + ataque + "\ndefensa: " + defensa
				+ "\nvelocidad: " + velocidad + "\nclasse: " + this.getClass().getSimpleName();

	}

	private Integer randomNum() {
		Random random = new Random();
		return random.nextInt(10 + 10) - 10;
	}

	private void calculaAtaque(Personaje p) {
		Integer dano;
		Integer golpes = getVelocidad() / p.getVelocidad();
		golpes = golpes < 1 ? 1 : golpes + 1;
		System.out.println("golpes ataque: " + golpes);
		dano = getAtaque() - p.getDefensa() + getRandomNum();
		dano = dano < 0 ? 0 : dano;
		System.out.println("dano ataque: " + dano);
		setVida(vida - (dano * golpes));
	}

	private void calculaDefensa(Personaje p) {
		Integer dano;
		Integer golpes = p.getVelocidad() / getVelocidad();
		golpes = golpes < 1 ? 1 : golpes;
		System.out.println("golpes defensa: " + golpes);
		dano = p.getAtaque() - getDefensa() + getRandomNum();
		dano = dano < 0 ? 0 : dano;
		System.out.println("dano defensa: " + dano);
		p.setVida(vida - (dano * golpes));
	}

	public void agarrar(Artefacto a) {
		if (a.getPersonaje() == null) {
			a.setEnUso(true);
			a.setPersonaje(this);
			getArtefactos().add(a);
		} else {
			new ItemInUseException("En uso por: " + a.getPersonaje().getNombre());
		}
	}

	public void soltar(Artefacto a) {
		if (a.getPersonaje().equals(this)) {
			a.setEnUso(false);
			a.setPersonaje(null);
			getArtefactos().removeIf(i -> i.equals(a));
		} else {
			new ItemInUseException("En uso por: " + a.getPersonaje().getNombre());
		}
	}

	public void usar(Artefacto a) {
		if (a.getPersonaje() != null && a.getPersonaje().equals(this)) {
			var artefacto = findArtefactoById(a);
			setAtaque(getAtaque() + artefacto.getAtaque());
			setDefensa(getDefensa() + artefacto.getDefensa());
			setVida(getVida() + artefacto.getVida());
			setVelocidad(getVelocidad() + artefacto.getVelocidad());
		} else {
			new ItemInUseException("En uso por: " + a.getPersonaje().getNombre());
		}
	}

	public void dejarDeUsar(Artefacto a) {
		if (a.getPersonaje().equals(this)) {
			var artefacto = findArtefactoById(a);
			setAtaque(getAtaque() - artefacto.getAtaque());
			setDefensa(getDefensa() - artefacto.getDefensa());
			setVida(getVida() - artefacto.getVida());
			setVelocidad(getVelocidad() - artefacto.getVelocidad());
		} else {
			 new ItemInUseException("En uso por: " + a.getPersonaje().getNombre());
		}
	}

	public String verInventario() {
		StringBuilder sb = new StringBuilder();
		getArtefactos().forEach(i -> sb.append(i.getNombre() + "|"));
		return sb.toString();
	}

	private Artefacto findArtefactoById(Artefacto a) {
		var index = getArtefactos().indexOf(a);
		return getArtefactos().get(index);
	}

	public void almacenarPersonaje() throws IOException {
		File file = new File(PATH);
		FileOutputStream os = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(os);

		osw.write(toString());
		osw.write("\nArtefactos: " + verInventario());
		osw.close();

	}

}
