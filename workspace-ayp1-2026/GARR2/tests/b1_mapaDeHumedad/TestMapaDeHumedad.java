package b1_mapaDeHumedad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMapaDeHumedad {

	@Test
	void humedadPromedioEnunciadoTest() {
		double[][] muestras = { { 45.0, 60.0, 72.0, 55.0 }, { 38.0, 91.0, 83.0, 47.0 }, { 50.0, 66.0, 74.0, 52.0 } };
		MapaDeHumedad terreno = new MapaDeHumedad(muestras);
		assertEquals(61.08333, terreno.humedadPromedio(), 0.001);
	}

	@Test
	void humedadPromedioSinMuestrasTest() {
		double[][] muestras = { { }, { }, { } };
		MapaDeHumedad terreno = new MapaDeHumedad(muestras);
		Error thrown = assertThrows(
	            Error.class,
	            () -> terreno.humedadPromedio()
	        );

	}
	@Test
	void humedadPromedioMatrizNulaTest() {
		double[][] muestras = null;
		Error thrown = assertThrows(
	            Error.class,
	            () -> new MapaDeHumedad(muestras)
	        );

	}
}
