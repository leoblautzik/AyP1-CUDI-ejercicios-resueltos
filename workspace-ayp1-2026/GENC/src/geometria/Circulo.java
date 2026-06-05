package geometria;

public class Circulo {
	private double radio;
	private Punto centro;

	

	public Circulo(double radio, double xCentro, double yCentro) {
		this.radio = radio;
		this.centro = new Punto(xCentro, yCentro);
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radio, 2);
	}
	
	public double getPerimetro() {
		return 2 * Math.PI * radio;
	}
	
	
	
}
