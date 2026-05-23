package tragamonedas;

public class Tragamonedas {
	private Tambor t1;
	private Tambor t2;
	private Tambor t3;

    /**
     * post: los 3 Tambores del Tragamonedas están en la posición 1.
     */
    public Tragamonedas() { 
    	this.t1 = new Tambor();
    	this.t2 = new Tambor();
    	this.t3 = new Tambor();
    	this.activar();
    	
    }

    /**
     * post: activa el Tragamonedas haciendo girar sus 3 Tambores.
     */
    public void activar() { 
    	this.t1.girar();
    	this.t2.girar();
    	this.t3.girar();
    }

    /**
     * post: indica si el Tragamonedas entrega un premio a partir de la posición de sus 3 Tambores.
     */
    public boolean entregaPremio() { 
    	return t1.obtenerPosicion() == t2.obtenerPosicion() &&
    			t1.obtenerPosicion() == t3.obtenerPosicion();
    }

	@Override
	public String toString() {
		return "[" + t1.obtenerPosicion() + "]" +"[" + t2.obtenerPosicion() + "]" + 
	"[" + t3.obtenerPosicion() +"]";
	}
}
