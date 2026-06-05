package filaDeEscolares;

public class FilaDeEscolares {
	
	private int[] alturas;
	
	public FilaDeEscolares(int[] alturas) {
		this.alturas = alturas;
	}
	
	public int cantidadDeAlumnos() {
		return this.alturas.length;
	}
	
	int alturaDelMasAlto() {
		int alturaDelMasAlto = this.alturas[0];
		for (int i = 1; i < alturas.length; i++) {
			if(alturas[i] > alturaDelMasAlto)
				alturaDelMasAlto = alturas[i];
		}
		return alturaDelMasAlto;
	}
	
	int alturaDelMasBajo() {
		int alturaDelMasBajo = this.alturas[0];
		for (int i = 1; i < alturas.length; i++) {
			if(alturas[i] < alturaDelMasBajo)
				alturaDelMasBajo = alturas[i];
		}
		return alturaDelMasBajo;
	}
	
	int[] ubicaciónDelosMasBajos() {
		int cantidadDeBajitos = 0;
		int alturaDelMasBajo = this.alturaDelMasBajo();
		for (int i = 0; i < alturas.length; i++) {
			if(this.alturas[i] == alturaDelMasBajo)
				cantidadDeBajitos ++;
		}
		
		int[]posicionesDeLosBajitos = new int[cantidadDeBajitos];
		int j = 0; 
		
		for (int i = 0; i < alturas.length; i++) {
			if(this.alturas[i] == alturaDelMasBajo) {
				posicionesDeLosBajitos[j] = i+1;
				j++;
			}
		}
		
		return posicionesDeLosBajitos;
	}
	int mayorDiferenciaDeAlturas() {
		int mayorDifAltura = Math.abs(this.alturas[0] - this.alturas[1]);
		
		for (int i = 1; i < alturas.length-1; i++) {
			
			if(Math.abs(this.alturas[i] - this.alturas[i+1]) > mayorDifAltura) {
				mayorDifAltura = Math.abs(this.alturas[i] - this.alturas[i+1]);
			}
		}
		return mayorDifAltura;
	}
	
	public int promedioDeLAsAlturas() {
		int sumaAlturas = 0;
		if(this.alturas.length == 0)
			throw new Error("No hay alumnos");
		for (int i = 0; i < alturas.length; i++) {
			sumaAlturas += this.alturas[i];
		}
		return sumaAlturas / this.alturas.length;
	}

}
