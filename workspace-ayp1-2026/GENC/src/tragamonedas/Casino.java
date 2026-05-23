package tragamonedas;

public class Casino {
	public static void main(String[] args) {
		Tragamonedas tramposito = new Tragamonedas();
		System.out.println("Mostramos el estado inicial del tragamonedas");
		System.out.println(tramposito);
		
		int aciertos = 0;
		System.out.println("Jugamos 100 veces a ver que sale");
		for (int i = 0; i < 100; i++) {
				tramposito.activar();
				if(tramposito.entregaPremio()) {
					aciertos ++;
					System.out.println("En el intento " + i + " salio: " + tramposito);
				}
		}
		System.out.println("Tuviste " + aciertos + " aciertos.");
		
		System.out.println("-------------------------");
		
		int intentos = 0;
		
		System.out.println("Ahora Jugamos hasta acertar");
		while(!tramposito.entregaPremio()) {
			tramposito.activar();
			intentos ++;
		}
		System.out.println(tramposito + " Acierto luego de " + intentos + " intentos");
		
		
				
	}

}
