package pokedesk;

import java.util.Arrays;

public class Pokedesk {

	private Monstruo[] monstruos;

	public Pokedesk(Monstruo[] monstruos) {
		this.monstruos = monstruos;
	}

	/**
	 * 
	 */
	public void listarMonstruos() {
		for (Monstruo monstruo : monstruos) {
			System.out.println(monstruo);
		}
	}

	/**
	 * 
	 * @param nombre
	 * @return El monstruo buscado o null si no lo encuentra
	 */
	public Monstruo buscarPorNombre(String nombre) {
		boolean encontrado = false;
		int i = 0;
		Monstruo aux = null;
		while (i < this.monstruos.length && !encontrado) {
			if (this.monstruos[i].getNombre().equals(nombre)) {
				encontrado = true;
				aux = this.monstruos[i];
			}
			i++;
		}
		return aux;
	}

	/**
	 * 
	 * @return La cantidad de monstruos capturados
	 */
	public int contarCapturados() {
		int contador = 0;
		for (Monstruo monstruo : monstruos) {
			if (monstruo.isCapturado()) {
				contador++;
			}
		}

		return contador;
	}

	/**
	 * 
	 * @return El monstruo mas fuerte
	 */
	public Monstruo monstruoMasFuerte() {
		Monstruo masFuerte = this.monstruos[0];

		for (int i = 1; i < monstruos.length; i++) {
			if (monstruos[i].getPuntosVida() > masFuerte.getPuntosVida()) {
				masFuerte = monstruos[i];
			}

		}
		return masFuerte;

	}

	/**
	 * 
	 * @return El monstruo mas debil
	 */
	public Monstruo monstruoMasDebil() {
		Monstruo masDebil = this.monstruos[0];

		for (int i = 1; i < monstruos.length; i++) {
			if (monstruos[i].getPuntosVida() < masDebil.getPuntosVida()) {
				masDebil = monstruos[i];
			}

		}
		return masDebil;

	}

	public double promedioVida() {
		double sumaVida = 0;
		for (Monstruo monstruo : monstruos) {
			sumaVida += monstruo.getPuntosVida();
		}

		return sumaVida / this.monstruos.length;

	}

	/**
	 * 
	 * @return True si hay algun monstruo capturado y False si no hay ninguno.
	 */
	public boolean hayCapturados() {
		int i = 0;
		while (i < monstruos.length && !monstruos[i].isCapturado())
			i++;

		return i != monstruos.length;
	}

	/**
	 * 
	 * @return Un arreglo de Monstruos, con los monstruos capturados
	 */
	public Monstruo[] monstruosCapturados() {
		int cantidadDeCapturados = this.contarCapturados();
		Monstruo[] capturados = new Monstruo[cantidadDeCapturados];
		int j = 0;
		for (Monstruo monstruo : this.monstruos) {
			if (monstruo.isCapturado()) {
				capturados[j] = monstruo;
				j++;
			}
		}
		return capturados;

	}

	public static void main(String[] args) {
		Monstruo[] monstruos = { new Monstruo("Drako", "Fuego", 120, true), new Monstruo("Aquar", "Agua", 90, false),
				new Monstruo("Terron", "Tierra", 150, true), new Monstruo("Voltix", "Electrico", 110, false),
				new Monstruo("Frost", "Hielo", 80, true), new Monstruo("Shadow", "ad", 200, true),
				new Monstruo("Leafy", "Planta", 70, false), new Monstruo("Zephyr", "Aire", 130, true) };

		Pokedesk misMonstruos = new Pokedesk(monstruos);
		misMonstruos.listarMonstruos();
		System.out.println("Cantidad de capturados: " + misMonstruos.contarCapturados());
		System.out.println("Mas fuerte: " + misMonstruos.monstruoMasFuerte());
		System.out.println("Mas debil: " + misMonstruos.monstruoMasDebil());
		System.out.println("Hay capturados? " + misMonstruos.hayCapturados());
		System.out.println("Promedio de vida: " + misMonstruos.promedioVida());
		System.out.println(Arrays.toString(misMonstruos.monstruosCapturados()));
		Monstruo buscado = misMonstruos.buscarPorNombre("Orco");
		System.out.println(buscado);

	}

}
