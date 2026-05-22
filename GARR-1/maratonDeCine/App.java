package maratonDePeliculas;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {

		Pelicula[] cartelera = {
			    new Pelicula("Dune",         "ciencia ficción", 155),
			    new Pelicula("Alien",        "terror",          117),
			    new Pelicula("Hereditary",   "terror",          127),
			    new Pelicula("Get Out",      "terror",          104),
			    new Pelicula("Parasite",     "thriller",        132),
			    new Pelicula("Clue",         "thriller",         94),
			    new Pelicula("Interstellar", "ciencia ficción", 169)
			};
		
		MaratonDePeliculas mdp = new MaratonDePeliculas(cartelera);
		
		int tiempo = 110;
		System.out.println("Peliculas que duran mas de "+ tiempo +":");
		System.out.println(Arrays.toString(mdp.peliculasLargas(110)));
		System.out.println("Duracion total de la maraton:");
		System.out.println(mdp.duracionTotal());
		System.out.println("Pelicula las corta: ");
		System.out.println(mdp.masCorta());
		String genero = "thriller";
		System.out.println("Racha mas larga del genero: " + genero);
		System.out.println(mdp.rachaMasLargaPorGenero(genero));
		System.out.println("Genero de la racha nas larga: ");
		System.out.println(mdp.generoRachaMasLarga());
		
	}

}
