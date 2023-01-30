package com.mycompany.app;

import java.io.IOException;

import com.qaracter.domain.Artefacto;
import com.qaracter.domain.Elfo;
import com.qaracter.domain.Humano;
import com.qaracter.domain.Orco;

import lombok.var;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
		Humano vitor = new Humano(100, 20, 20, 1, "Vitor");
		Elfo john = new Elfo(100, 15, 25, 2, "John");
		Orco argon = new Orco(120, 25, 15, 1, "Argon");
		
		/*vitor.luchar(argon);
		john.luchar(argon);
		
		System.out.println(vitor.getVida());
		System.out.println(argon.getVida());
		System.out.println(john.getVida());
		
		
		vitor.especialHumano();
		argon.souUnOrco();*/
		
		System.out.println(vitor.toString());
		var espadaOuro = new Artefacto("espada dourada", 0, 15, 5, 0);
		var escudoOuro = new Artefacto("escudo dourado", 0, 5, 15, 0);
		vitor.agarrar(espadaOuro);
		vitor.usar(espadaOuro);
		vitor.agarrar(escudoOuro);
		vitor.usar(escudoOuro);
		john.agarrar(espadaOuro);
		System.out.println(vitor.getArtefactos());
		vitor.verInventario();
		vitor.almacenarPersonaje();
		vitor.soltar(espadaOuro);
		john.agarrar(espadaOuro);
		System.out.println(vitor.getArtefactos());
		System.out.println(john.getArtefactos());
		
    }
}
