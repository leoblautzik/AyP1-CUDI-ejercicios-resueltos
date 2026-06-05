package holaMundo;

public class HolaMundo {

	public static void main(String[] args) {
		
		int[][] cuadradoMagico = {{6,1,8},{7,5,3},{2,9,4}};
		
		for (int i = 0; i<cuadradoMagico.length; i++) {
			for(int j=0; j< cuadradoMagico[i].length; j++) {
				System.out.print(cuadradoMagico[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("------------");
				
		for (int[] fila : cuadradoMagico) {
			for (int dato : fila) {
				System.out.print(dato + " ");
			}
			System.out.println();
		}
	}

}
