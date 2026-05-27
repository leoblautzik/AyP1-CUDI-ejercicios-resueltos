package bigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class InteresCompuesto {

	public BigDecimal obtenerMontoFinal(BigDecimal capital, BigDecimal tasa, int periodos) {

		// A = P × (1 + r)^(n)
		BigDecimal tasaDecimal = tasa.divide(new BigDecimal("100"));
		BigDecimal base = BigDecimal.ONE.add(tasaDecimal);
		BigDecimal factor = base.pow(periodos);
		BigDecimal monto = capital.multiply(factor);
		
		return monto.setScale(2, RoundingMode.HALF_UP);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("No usar separadores de miles y solo usar . para separar decimales");
		System.out.print("Capital inicial: ");
		BigDecimal capital = new BigDecimal(scanner.nextLine().trim().replace(",", "."));
		//BigDecimal capital = scanner.nextBigDecimal();

		System.out.print("Tasa de interés anual (%): ");
		BigDecimal tasa = new BigDecimal(scanner.nextLine().trim().replace(",", "."));
		//BigDecimal tasa = scanner.nextBigDecimal();

		System.out.print("Cantidad de años: ");
		int anios = Integer.parseInt(scanner.nextLine().trim());
		//int anios = scanner.nextInt();
		
		scanner.close();
		
		InteresCompuesto calculadora = new InteresCompuesto();

		BigDecimal montoFinal = calculadora.obtenerMontoFinal(capital, tasa, anios);
		
		System.out.println(montoFinal);
		
		

	}

}
