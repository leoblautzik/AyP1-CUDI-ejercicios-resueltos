package cerradura;

class Cerradura {

	private int claveDeApertura;
	private int cfcqlb;
	private boolean abierta = true;
	private boolean bloqueada = false;
	private int aperturasExitosas = 0;
	private int aperturasFallidas = 0;
	private int intentosConsFallidos = 0;

	/**
	 * @param claveDeApertura
	 * @param cantidadDeFallosConsecutivosQueLaBloquean
	 * @post Se crea la cerradura con su clave de apertura, su indicador de fcqlb y
	 *       en estado abierta.
	 */
	public Cerradura(int claveDeApertura, int cantidadDeFallosConsecutivosQueLaBloquean) {
		this.claveDeApertura = claveDeApertura;
		this.cfcqlb = cantidadDeFallosConsecutivosQueLaBloquean;

	}

	public boolean abrir(int clave) {
		boolean flag = true;

		if (this.fueBloqueada()) {
			throw new Error("La cerradura esta bloqueada");
		}

		if (this.estaAbierta()) {
			throw new Error("La cerradura esta abierta");
		}
		if (this.estaCerrada()) {
			if (this.claveDeApertura == clave) {
				this.abierta = true;
				this.aperturasExitosas++;
				this.intentosConsFallidos = 0;
				flag = true;
			} else {
				this.aperturasFallidas++;
				this.intentosConsFallidos++;
				if (this.intentosConsFallidos == this.cfcqlb) {
					this.bloqueada = true;
				}
				flag = false;
			}
		}

		return flag;
	}

	public void cerrar() {
		this.abierta = false;
	}

	public boolean estaAbierta() {
		return this.abierta;
	}

	public boolean estaCerrada() {
		return !this.estaAbierta();
	}

	public boolean fueBloqueada() {
		return this.bloqueada;
	}

	public int contarAperturasExitosas() {
		return this.aperturasExitosas;
	}

	public int contarAperturasFallidas() {
		return this.aperturasFallidas;
	}

}
