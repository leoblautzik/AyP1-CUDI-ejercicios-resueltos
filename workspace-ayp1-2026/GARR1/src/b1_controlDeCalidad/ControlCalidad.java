package b1_controlDeCalidad;

import java.util.ResourceBundle.Control;

/*
 * Una fábrica de piezas metálicas registra el peso 
 * (en gramos) de cada pieza producida en un turno. 
 * Una pieza se considera defectuosa si su peso es menor a 95g o mayor a 105g. Las piezas con peso exactamente igual a 100 g son perfectas.

Dado el siguiente arreglo de pesos, escribí un programa que informe:

La cantidad de piezas defectuosas.
La cantidad de piezas perfectas.
El peso promedio de las piezas no defectuosas (si las hay).
Si más del 20% de las piezas son defectuosas, imprimí el mensaje "ALERTA: revisar línea de producción".
 */

public class ControlCalidad {

	private int[] pesos;

	public ControlCalidad(int[] pesos) {
		this.pesos = pesos;
	}

	public boolean esDefectuosa(int peso) {
		return peso < 95 || peso > 105;
	}

	public int contarDefectuosas() {
		int cantDefecuosas = 0;
		for (int peso : pesos) {
			if (esDefectuosa(peso))
				cantDefecuosas++;
		}
		return cantDefecuosas;
	}

	public int sumarPesosDefectuosas() {
		int pesosDefecuosas = 0;
		for (int peso : pesos) {
			if (esDefectuosa(peso))
				pesosDefecuosas += peso;
		}
		return pesosDefecuosas;
	}

	public int contarPerfectas() {
		int cantPerfectas = 0;
		for (int peso : pesos) {
			if (peso == 100)
				cantPerfectas++;
		}
		return cantPerfectas;
	}

	public double promedioDeLasNoDefectuosas() {
		int cantidadDeNoDefecuosas = this.pesos.length - this.contarDefectuosas();
		if (cantidadDeNoDefecuosas == 0)
			throw new Error("No hay piezas defectuosas");
		return this.sumarPesosDefectuosas() / (cantidadDeNoDefecuosas);

	}

	public static void main(String[] args) {
		int[] pesos = { 102, 98, 100, 87, 105, 100, 111, 99, 103, 94, 100, 101 };
		ControlCalidad controladora = new ControlCalidad(pesos);

		System.out.println("Defectuosas: " + controladora.contarDefectuosas());
		System.out.println("Perfectas: " + controladora.contarPerfectas());
		System.out.println("Peso promedio de no def: " + controladora.promedioDeLasNoDefectuosas());
	}

}
