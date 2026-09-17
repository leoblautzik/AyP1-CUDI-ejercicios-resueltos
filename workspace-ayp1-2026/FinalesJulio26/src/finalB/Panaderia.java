package finalB;

public class Panaderia {
	private Pan[][] panes;

	/**
	 *  
	 * @param pan
	 * @param temperaturaDelHorno   debe ser un valor entero positivo
	 * @param tiempoMaximoPermitido debe ser un valor entero positivo
	 * @return true si el pan esta quemado.
	 */
	private boolean panQuemado(Pan pan, int temperaturaDelHorno, int tiempoMaximoPermitido) {
		if (temperaturaDelHorno <= 0 || tiempoMaximoPermitido <= 0)
			throw new Error("Parametros inválidos");

		return temperaturaDelHorno > pan.getTemperaturaIdeal() && pan.getTiempoDeCoccion() > tiempoMaximoPermitido;
	}

	/**
	 * 
	 * @param bandeja               debe estar comprendida entre 0 y la cantidad de
	 *                              bandejas-1
	 * @param temperaturaDelHorno   entero positivo
	 * @param tiempoMaximoPermitido entero positivo
	 * @return devuelve la cantidad de panes quemados en esa bandeja
	 */
	public int cantidadDePanesQuemadosEnBandeja(int bandeja, int temperaturaDelHorno, int tiempoMaximoPermitido) {
		if (!esBandejaValida(bandeja))
			throw new Error("Bandeja inexistente");

		int cantidadDePaneQuemados = 0;
		for (Pan pan : panes[bandeja]) {
			if (panQuemado(pan, temperaturaDelHorno, tiempoMaximoPermitido))
				cantidadDePaneQuemados++;
		}
		return cantidadDePaneQuemados;
	}

	private boolean esBandejaValida(int bandeja) {
		return bandeja >= 0 && bandeja < panes.length;
	}

	/**
	 * 
	 * @param bandeja debe estar comprendida entre 0 y la cantidad de bandejas-1
	 * @return tiempo acumulado de coccion de todos los panes de la bandeja
	 */
	public int tiempoTotalDeHorneadoEnBandeja(int bandeja) {
		if (!esBandejaValida(bandeja))
			throw new Error("Bandeja inexistente");

		int tiempoAcumuladoBandeja = 0;
		for (Pan pan : panes[bandeja]) {
			tiempoAcumuladoBandeja += pan.getTiempoDeCoccion();
		}
		return tiempoAcumuladoBandeja;
	}

}
