package b1_mapaDeHumedad;

public class MapaDeHumedad {

	private double[][] muestras;

	public MapaDeHumedad(double[][] muestras) {
		if (muestras == null) {
			throw new Error("Matriz nula");
		}
		this.muestras = muestras;
	}

	public double humedadPromedio() {
		if (this.muestras.length == 0) {
			throw new Error("Matriz vacía");
		}
		for (double[] ds : muestras) {
			if (ds.length == 0) {

				throw new Error("Matriz con fila vacía");
			}
		}
		double suma = 0;
		double promedio;
		for (double[] ds : muestras) {
			for (double d : ds) {
				suma += d;
			}
		}
		promedio = suma / (this.muestras.length * this.muestras[0].length);

		return promedio;
	}

}
