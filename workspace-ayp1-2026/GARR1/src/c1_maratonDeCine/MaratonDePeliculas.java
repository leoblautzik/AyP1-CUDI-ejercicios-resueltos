package c1_maratonDeCine;

public class MaratonDePeliculas {

	private Pelicula[] peliculas;

	public MaratonDePeliculas(Pelicula[] peliculas) {
		this.peliculas = peliculas;
	}

	public Pelicula[] peliculasLargas(int minutos) {

		int cantPeliculasLargas = 0;
		Pelicula[] pelisLargas;
		int pos = 0;

		// recorremos el arreglo de peliculas contando cuantas son mas largas en minutos
		// que el parametro
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getDuracion() > minutos) {
				cantPeliculasLargas++;
			}
		}
		// creamos el arreglo que se va a devolver
		pelisLargas = new Pelicula[cantPeliculasLargas];

		// lo llenamos con las peliculas largas
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getDuracion() > minutos) {
				pelisLargas[pos] = pelicula;
				pos++;
			}
		}

		return pelisLargas;

	}

	public int duracionTotal() {
		int tiempoTotal = 0;
		for (Pelicula pelicula : peliculas) {
			tiempoTotal += pelicula.getDuracion();
		}

		return tiempoTotal;

	}

	public Pelicula masCorta() {
		// solucion que solo usa el indice
		int indiceMasCorta = 0;
		for (int i = 1; i < peliculas.length; i++) {
			if (peliculas[i].getDuracion() < peliculas[indiceMasCorta].getDuracion()) {
				indiceMasCorta = i;
			}
		}

		return this.peliculas[indiceMasCorta];
	}

	public int rachaMasLargaPorGenero(String genero) {
		int rachaActual = 0;
		int rachaMasLarga = 0;

		for (Pelicula pelicula : peliculas) {
			if (pelicula.getGenero().equals(genero)) {
				rachaActual++;
				if (rachaActual > rachaMasLarga) {
					rachaMasLarga = rachaActual;
				}
			} else {
				rachaActual = 0;
			}
		}

		return rachaMasLarga;

	}

	public String generoRachaMasLarga() {
		// solucion usando 4 valiables auxiliares
		String generoRachaMasLarga = "";
		String generoActual = this.peliculas[0].getGenero();
		int rachaActual = 1;
		int rachaMasLarga = 1;

		for (int i = 1; i < peliculas.length; i++) {
			if (peliculas[i].getGenero().equals(generoActual)) {
				rachaActual++;
				if (rachaActual > rachaMasLarga) {
					rachaMasLarga = rachaActual;
					generoRachaMasLarga = generoActual;
				}
			} else {
				generoActual = peliculas[i].getGenero();
				rachaActual = 1;

			}
		}

		return generoRachaMasLarga;
	}

}
