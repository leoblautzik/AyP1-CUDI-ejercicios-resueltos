package c2_inventarioDeUnaLibreria;

import java.util.Arrays;

public class Libreria {
	
	private Libro[] libros; 
	
	public Libreria(Libro[] libros) {
		this.libros = libros;
	}
	
	public void librosConStockCritico() {
		System.out.println("Libros con stock critico (menos de 3 ejemplares):");
		for (Libro libro : libros) {
			if(libro.getEjemplaresDisponibles() < 3) {
				System.out.println(libro.getTitulo());
			}
		}
	}
	
	public int totalDeEjemplares() {
		return this.libros.length;
	}
	
	public Libro[] librosDelAutor(String autor) {
		int tamanio=0;
		int i=0;
		Libro[] librosDeAutor;
		for (Libro libro : libros) {
			if (libro.getAutor().equals(autor)){
				tamanio++;
			}
		}
		librosDeAutor = new Libro[tamanio];
		
		for (Libro libro : libros) {
			if(libro.getAutor().equals(autor)) {
				librosDeAutor[i]= libro;
				i++;
			}
		}
		return librosDeAutor;
	}
	
	public void autorConMasTitulosDistintos() {
		String[] autores = new String[libros.length];
		int[] titulosDistintos = new int[libros.length];
		int posAutor;
		int cantTitulosDistintos = 0;
		
		//solucion con 2 vectores paralelos, uno para los autores y otro para los titulos distintos de ese autor
		for (Libro libro : libros) {
			posAutor = buscarAutorEn(libro.getAutor(),autores, cantTitulosDistintos);
			if(posAutor != -1) {
				titulosDistintos[posAutor]++;
			}
			else {
				autores[cantTitulosDistintos]=libro.getAutor();
				titulosDistintos[cantTitulosDistintos]= 1;
				cantTitulosDistintos++;
			}
		}
		//busco el maximo en el arreglo de titulos distintos
		int indiceMax = 0;
		for (int j = 1; j < cantTitulosDistintos; j++) {
			if(titulosDistintos[j] > titulosDistintos[indiceMax]) {
				indiceMax = j;
			}
		}
		System.out.println("Autor: " + autores[indiceMax] + " con " + titulosDistintos[indiceMax] + " titulos distintos");
	}
	
	public int buscarAutorEn(String autorBuscado, String[] v, int ce ) {
		int pos = -1;
		
		for (int i = 0; i < ce && pos == -1; i++) {
		    if (v[i] == autorBuscado ) {
		        pos = i;
		    }
		}
		return pos;
	}
	

	public static void main(String[] args) {
		Libro[] inventario = {
			    new Libro("Ficciones",              "Borges",         5),
			    new Libro("El Aleph",               "Borges",         2),
			    new Libro("Rayuela",                "Cortázar",       4),
			    new Libro("Bestiario",              "Cortázar",       1),
			    new Libro("Final del juego",        "Cortázar",       3),
			    new Libro("Cien años de soledad",   "García Márquez", 7),
			    new Libro("El amor en los tiempos", "García Márquez", 2)
			};
		
		Libreria cuspide = new Libreria(inventario);
		cuspide.librosConStockCritico();
		cuspide.autorConMasTitulosDistintos();
		
	}

}
