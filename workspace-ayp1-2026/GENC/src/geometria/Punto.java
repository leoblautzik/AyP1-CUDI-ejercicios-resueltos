package geometria;

/*Implementar la clase Punto.
 * Un Punto en el plano posee coordenada X y coordenada Y. 
 * Proporcionar métodos para:
 * obtener y cambiar cada una de sus coordenadas:
*/

/**
 * 
 */
public class Punto {

	private double x;
	private double y;

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}


	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}


	public double obtenerX() {
		return this.x;
	}

	public double obtenerY() {
		return this.y;
	}

	public void cambiarX(double nuevoX) {
		this.x = nuevoX;
	}

	public void cambiarY(double nuevoY) {
		this.y = nuevoY;
	}

	//

	/**
	 * saber si el punto está sobre el eje de las X:
	 * 
	 * @return devuelve true o false si el punto está sobre el eje x o no
	 */
	public boolean estaSobreEjeX() {
		return this.y == 0;

	}

	// saber si el punto está sobre el eje de las Y:
	public boolean estaSobreEjeY() {
		return this.x == 0;
	}

	// saber si el punto es el origen de coordenadas:
	public boolean esElOrigen() {
		//return this.x == 0 && this.y == 0;
		return this.estaSobreEjeX() && this.estaSobreEjeY();
	}
	
	
	/**
	 * @return Distancia al origen
	 */
	public double distanciaAlOrigen() {
		//return Math.sqrt(Math.pow(this.x, 2)+ Math.pow(this.y, 2));
		return Math.hypot(this.x, this.y);
	}
	
	public double distancia(Punto otroPunto) {
		return Math.hypot(this.x - otroPunto.x, this.y- otroPunto.y);
		
	}

	public static void main(String[] args) {

		Punto puntito;
		puntito = new Punto(4, 6);
		System.out.println(puntito);
//		System.out.println(puntito.obtenerX());
//		System.out.println(puntito.obtenerY());
//		puntito.cambiarX(0);
//		System.out.println(puntito.estaSobreEjeY());
//		
//		Punto p1 = new Punto(-1,-1);
//		Punto p2 = new Punto(2,3);
//		double distanciaP1P2;
//		distanciaP1P2 = p1.distancia(p2);
//		System.out.println(distanciaP1P2);
//		System.out.println(p2.distancia(p1));
//		System.out.println(p2.distancia(p2));
	}

}
