package starwars;

public class Simulador {
	private Nave[] naves;
	private Piloto[] pilotos;
	
	
	public Simulador(Nave[] naves, Piloto[] pilotos) {
		this.naves = naves;
		this.pilotos = pilotos;
	}
	
	private void asignarPilotos() {
		int tam = Math.min(this.pilotos.length, this.naves.length);
		for(int i = 0; i<tam; i++) {
			//pilotos[i].subirseNave(naves[i]);
			naves[i].asignarPiloto(pilotos[i]);
		}
		
	}
	
	public static void main(String[] args) {
		Nave[] naves = {
			    new Nave("X-Wing"),
			    new Nave("Halcón Milenario"),
			    new Nave("TIE Fighter")
			};
		Piloto[] pilotos = {
			    new Piloto("Luke Skywalker"),
			    new Piloto("Han Solo"),
			    new Piloto("Darth Vader")
			};
		
		Simulador simulador = new Simulador(naves, pilotos);
		simulador.asignarPilotos();
		System.out.println(naves[0]);
		System.out.println(pilotos[0]);
		
		//pilotos[0].bajarseNave();
		naves[0].bajarPiloto();
		System.out.println(naves[0]);
		System.out.println(pilotos[0]);


	}


	
	

}
