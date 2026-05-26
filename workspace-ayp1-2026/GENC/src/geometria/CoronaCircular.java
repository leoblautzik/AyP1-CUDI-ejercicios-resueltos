package geometria;

public class CoronaCircular {

	private Circulo grande;
	private Circulo agujero;
	private Punto centro;


	public CoronaCircular(double radioGrande, double radioChico, double xCentro, double yCentro) {
		this.grande = new Circulo(radioGrande, xCentro, yCentro);
		this.agujero = new Circulo(radioChico, xCentro, yCentro);
		this.centro = new Punto(xCentro, yCentro);
	}

	public double getArea() {
		return this.grande.getArea() - this.agujero.getArea();
	}

	public double getPerimetroExterior() {
		return this.grande.getPerimetro();
	}

	public double getPerimetroInterior() {
		return this.agujero.getPerimetro();
	}

	

}
