package computandoPatentes;

import java.util.Objects;

public class Patente {

	private String numeroDePatente;
	
	public Patente(String numeroDePatente) {
		this.setNumeroDePatente(numeroDePatente);
	}

	public String getNumeroDePatente() {
		return numeroDePatente;
	}

	public void setNumeroDePatente(String numeroDePatente) {
		numeroDePatente = numeroDePatente.toUpperCase();
		if (numeroDePatente.length() != 6 && numeroDePatente.length() != 7)
			throw new Error("Patente incorrecta");
		if (numeroDePatente.length() == 6)
			if (!esLetra(numeroDePatente.charAt(0)) || !esLetra(numeroDePatente.charAt(1))
					|| !esLetra(numeroDePatente.charAt(2)) || !esDigito(numeroDePatente.charAt(3))
					|| !esDigito(numeroDePatente.charAt(4)) || !esDigito(numeroDePatente.charAt(5)))
				throw new Error("Patente incorrecta");
		if (numeroDePatente.length() == 7)
			if (!esLetra(numeroDePatente.charAt(0)) || !esLetra(numeroDePatente.charAt(1))
					|| !esDigito(numeroDePatente.charAt(2)) || !esDigito(numeroDePatente.charAt(3))
					|| !esDigito(numeroDePatente.charAt(4)) || !esLetra(numeroDePatente.charAt(5))
					|| !esLetra(numeroDePatente.charAt(5)))
				throw new Error("Patente incorrecta");
		this.numeroDePatente = numeroDePatente;
	}

	

	@Override
	public String toString() {
		return "[" + numeroDePatente + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroDePatente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patente other = (Patente) obj;
		return Objects.equals(numeroDePatente, other.numeroDePatente);
	}

	private boolean esLetra(char c) {
		return c >= 'A' && c <= 'Z';
	}

	private boolean esDigito(char c) {
		return c >= '0' && c <= '9';
	}

}
