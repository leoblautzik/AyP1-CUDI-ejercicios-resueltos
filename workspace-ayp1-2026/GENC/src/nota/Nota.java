package nota;

import java.util.Objects;

public class Nota {

	@Override
	public int hashCode() {
		return Objects.hash(valorNota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return valorNota == other.valorNota;
	}

	private int valorNota;

	/**
	 * pre : valorInicial está comprendido entre 0 y 10. 
	 * post: inicializa la Nota con el valor indicado.
	 */
	public Nota(int valorInicial) {
		if (valorInicial < 0 || valorInicial > 10) {
			throw new Error("Nota inválida");
		}
		valorNota = valorInicial;
	}

	/**
	 * post: devuelve el valor numérico de la Nota, comprendido entre 0 y 10.
	 */
	public int obtenerValor() {
		return valorNota;
	}

	/**
	 * post: indica si la Nota permite o no la aprobación.
	 */
	public boolean aprobado() {
		return valorNota >= 4;
	}

	/**
	 * post: indica si la Nota implica desaprobación.
	 */
	public boolean desaprobado() {
		return !aprobado();
	}
	
	public static void main(String[] args) {
		
		Nota p1 = new Nota(7);
		System.out.println(p1.aprobado());
		System.out.println(p1.desaprobado());
		
		Nota p2 = new Nota(4);
		System.out.println(p2.aprobado());
		
		
	}
	

}
