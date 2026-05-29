package pokedesk;

import java.util.Arrays;

public class Pokedesk {

	private Monstruo[] monstruos;

	public Pokedesk(Monstruo[] monstruos) {
		this.monstruos = monstruos;
	}
	
	public void listarMonstruos() {
		for (Monstruo monstruo : monstruos) {
			System.out.println(monstruo);
		}
	}
	
	public Monstruo buscarPorNombre(String nombre) {
		boolean encontrado = false;
		int i = 0;
		Monstruo aux = null;
		while (i<this.monstruos.length && !encontrado) {
			if(this.monstruos[i].getNombre().equals(nombre)) {
				encontrado = true;
				aux = this.monstruos[i];
			}
			i++;
		}
		return aux;
	}
	
	public int contarCapturados() {
		int contador = 0;
		for (Monstruo monstruo : monstruos) {
			if(monstruo.isCapturado()) {
				contador++;
			}
		}
		
		return contador;
	}
	
	public Monstruo monstruoMasFuerte() {
		Monstruo masFuerte = this.monstruos[0];
		
		for (int i = 1; i < monstruos.length; i++) {
			if(monstruos[i].getPuntosVida() > masFuerte.getPuntosVida()) {
				masFuerte = monstruos[i];
			}
			
		}
		return masFuerte;
		
	}
	
	public boolean hayCapturados() {
		int i =	0;
		while(i < monstruos.length && !monstruos[i].isCapturado()) 
			i++;
		
		return i != monstruos.length;
	}
	
	public Monstruo[] monstruosCapturados() {
		int cantidadDeCapturados = this.contarCapturados();
		Monstruo[] capturados = new Monstruo[cantidadDeCapturados];
		int j=0;
		for (Monstruo monstruo : this.monstruos) {
			if (monstruo.isCapturado()) {
				capturados[j]=monstruo;
				j++;
			}
		}
		return capturados;
		
	}


	public static void main(String[] args) {
		Monstruo[] monstruos = {
			    new Monstruo("Drako", "Fuego", 120, true),
			    new Monstruo("Aquar", "Agua", 90, false),
			    new Monstruo("Terron", "Tierra", 150, true),
			    new Monstruo("Voltix", "Electrico", 110, false),
			    new Monstruo("Frost", "Hielo", 80, true),
			    new Monstruo("Shadow", "Oscuridad", 200, true),
			    new Monstruo("Leafy", "Planta", 70, false),
			    new Monstruo("Zephyr", "Aire", 130, true)
			};
		
		Pokedesk misMonstruos = new Pokedesk(monstruos);
		//misMonstruos.listarMonstruos();
		Monstruo buscado = misMonstruos.buscarPorNombre("Orco");
		System.out.println(buscado);
		
		System.out.println("Cantidad de capturados: " + misMonstruos.contarCapturados());
		System.out.println("Mas fuerte: " + misMonstruos.monstruoMasFuerte());
		System.out.println("Hay capturados? " + misMonstruos.hayCapturados());
		System.out.println(Arrays.toString(misMonstruos.monstruosCapturados()));
		
	}
	
	
}
