package pokedesk;

public class Monstruo {

	private String nombre;
	private String tipo;
	private int puntosVida;
	private boolean capturado;
	
	public Monstruo(String nombre, String tipo, int puntosVida, boolean capturado) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.puntosVida = puntosVida;
		this.capturado = capturado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public boolean isCapturado() {
		return capturado;
	}

	@Override
	public String toString() {
		return "Monstruo [nombre=" + nombre + ", tipo=" + tipo + ", puntosVida=" + puntosVida + ", capturado="
				+ capturado + "]";
	}
	
	
	
	
	

}
