package cuartoParcial;

public class Tribuna {
	private Asiento[][] tribuna;

	/**
	 * pre: asientos no puede ser null y debe contener al menos un Asiento
	 * 
	 * @param asientos es una matriz de Asiento.
	 */
	public Tribuna(Asiento[][] asientos) {
		if (asientos == null || asientos.length < 1 || asientos[0].length < 1) {
			throw new Error("Matriz incompatible");
		}
		this.tribuna = asientos;
	}

	/**
	 * pre: fila esta dentro de los limites de la matriz
	 * 
	 * @param fila: int pos: deviende la cantidad de asientos libres en la fila
	 */
	public int libresPorFila(int fila) {
		int contadorDeLibres = 0;
		for (Asiento[] filaDeAsientos : tribuna) {
			for (Asiento asiento : filaDeAsientos) {
				if (asiento.estaLibre()) {
					contadorDeLibres++;
				}
			}
		}
		return contadorDeLibres;
	}

	/**
	 * pre: Debe haber al menos un asiento libre en alguna fila o lanza un error
	 * @return la fila con mas asientos libres.
	 */
	public int filaConMasAsientosLibres() {
		int filaMasLibre = 0;
		for (int i = 1; i < tribuna.length; i++) {
			if (libresPorFila(i) > libresPorFila(filaMasLibre)) {
				filaMasLibre = i;
			}
		}
		if (libresPorFila(filaMasLibre) == 0)
			throw new Error("No hay asientos libres");
		
		return filaMasLibre;
	}

}
