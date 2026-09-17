package starwars;

public class Piloto {

	private String nombre;
	private Nave nave;

	public Piloto(String modelo) {
		this.nombre = modelo;
		this.nave = null;
	}

	@Override
	public String toString() {
		if (this.nave == null)
			return "Piloto [nombre=" + nombre + ", nave=" + "Sin nave asignada" + "]";
		return "Piloto [nombre=" + nombre + ", nave=" + nave.getModelo() + "]";
	}

	public void subirseNave(Nave nave) {
		if (this.nave != null) {
			throw new Error("Ya tiene nave asignada");
		}
		this.nave = nave;
		if (!nave.tienePilotoAsignado())
			nave.asignarPiloto(this);
	}

	public void bajarseNave() {
		if (this.nave != null) {
			this.nave.bajarPiloto();
			this.nave = null;
		}
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public boolean tieneNaveAsignada() {
		return this.nave != null;
	}

}
