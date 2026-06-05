package a4_arrayDeObjetos;

public class Producto {
	String nombre;
	double precio;

	Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", precio=" + precio;
	}

	public static void main(String[] args) {
		Producto[] productos = { 
				new Producto("leche", 150.0), 
				new Producto("pan", 80.0), 
				new Producto("queso", 420.0),
				new Producto("yogur", 95.0) };

		// Recorrelo con for-each e imprimí nombre y precio de cada producto.
		double precioCarrito = 0;
		for (Producto cadaProducto : productos) {
			precioCarrito += cadaProducto.precio;
			System.out.println(cadaProducto);
		}
		System.out.println("Precio del carrito: " + precioCarrito);

		if (productos.length == 0)
			throw new Error("Carrito vacío");

		Producto masCaro = productos[0];
		int posMasCaro = 0;
		for (int i = 1; i < productos.length; i++) {
			if (productos[i].precio > masCaro.precio) {
				masCaro = productos[i];
				posMasCaro = i;
			}
		}
		for (Producto cadaProducto : productos) {
			int pos = 0;
			if(cadaProducto.precio > masCaro.precio) {
				masCaro = cadaProducto;
				posMasCaro = pos;
			}
			pos++;
		}
		
		System.out.println("El más caro es: " + masCaro);
		
		productos[1].precio = 90;
		
		System.out.println(productos[1]);

	}

}
