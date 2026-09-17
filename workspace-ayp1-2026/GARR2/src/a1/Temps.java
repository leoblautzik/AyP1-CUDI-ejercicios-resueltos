package a1;

public class Temps {

	public static void main(String[] args) {

		double[][] temps = 	{ 
								{ 22.0, 18.5, 31.0, 27.3 }, 
								{ 15.0, 29.0, 24.1, 20.8 }, 
								{ 30.2, 33.0, 28.7, 25.5 } 
							};
		for (int i = 0; i < temps.length; i++) {
			for (int j = 0; j < temps[i].length; j++) {
				System.out.printf("temps[%d][%d] = %.2f\n", i, j, temps[i][j]);
			}

		}
	}
}
