package b1_controlDeCalidad;
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

	static boolean esDefectuosa(int peso) {
		return peso < 95 || peso > 105;
	}

	public static void main(String[] args) {
		int cantDefecuosas = 0;
		int cantPerfectas = 0;
		int sumaPesosNoDefectuosas = 0;

		int[] pesos = { 102, 98, 100, 87, 105, 100, 111, 99, 103, 94, 100, 101 };

		for (int peso : pesos) {
			if (esDefectuosa(peso))
				cantDefecuosas++;
			else {
				if (peso == 100)
					cantPerfectas++;
				sumaPesosNoDefectuosas += peso;
			}
		}
		System.out.println("Defectuosas: " + cantDefecuosas);
		System.out.println("Perfectas: " + cantPerfectas);
		if (pesos.length != cantDefecuosas) {
			double promedio = (double) sumaPesosNoDefectuosas / (pesos.length - cantDefecuosas);
			System.out.println("Peso promedio de no def: " + promedio);
		}
		
	}

}
