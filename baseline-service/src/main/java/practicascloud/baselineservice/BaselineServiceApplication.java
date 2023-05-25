package practicascloud.baselineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;


@SpringBootApplication
public class BaselineServiceApplication {

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BaselineServiceApplication.class, args);

		BaselineServiceApplication bsApp = new BaselineServiceApplication();
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("\n");
			System.out.println("//----- The Investor School - Calculo de interes compuesto -----//");

			System.out.println("Ingresar Inversion inicial");
			double inversionInicial = scanner.nextDouble();
			double inicial = inversionInicial;

			System.out.println("Ingresar Aportacion anual");
			double aportacionAnual = scanner.nextDouble();

			System.out.println("Ingresar Incremento anual");
			double porcentajeIncrementoAnual = scanner.nextDouble();

			System.out.println("Ingresar Años de inversion");
			int aniosInversion = scanner.nextInt();

			System.out.println("Rendimiento");
			double rendimientoInversion = scanner.nextDouble();

			bsApp.calcularInteres(inversionInicial, inicial, aportacionAnual, porcentajeIncrementoAnual, aniosInversion, rendimientoInversion);
		} while (true);
	}

	/**
	 *
	 * @param inversionInicial
	 * @param inicial
	 * @param aportacionAnual
	 * @param porcentajeIncrementoAnual
	 * @param aniosInversion
	 * @param rendimientoInversion
	 */
	public void calcularInteres (double inversionInicial, double inicial, double aportacionAnual, double porcentajeIncrementoAnual, int aniosInversion, double rendimientoInversion) {

		if ((inversionInicial >= 1000) && (aportacionAnual >= 0) && (porcentajeIncrementoAnual >= 0) && (aniosInversion > 0) && (rendimientoInversion > 0)) {

			int anio;
			double saldoInicial;
			double aportacion;
			double rendimiento;
			double saldoFinal;

			double sumaAportacionAnual = 0.0;
			double montoFinal = 0;
			double gananciaInversion = 0;


			for (int i = 1; i <= aniosInversion; i++) {
				anio = i;
				saldoInicial = inversionInicial;
				aportacion = aportacionAnual;
				rendimiento = (saldoInicial + aportacion) * (rendimientoInversion / 100);
				saldoFinal = saldoInicial + aportacion + rendimiento;

				sumaAportacionAnual += aportacion;

				montoFinal = saldoFinal;
				gananciaInversion = montoFinal - inicial - sumaAportacionAnual;

				inversionInicial = saldoFinal;
				aportacionAnual = (aportacion) * (1 + (porcentajeIncrementoAnual / 100));

				System.out.println("");
				System.out.println("Año: " +anio);
				System.out.println("Saldo inicial: " +Math.ceil(saldoInicial));
				System.out.println("Aportacion: " +Math.ceil(aportacion));
				System.out.println("Rendimiento: " +Math.ceil(rendimiento));
				System.out.println("Saldo final: " +Math.ceil(saldoFinal));
				System.out.println("");
			}

			System.out.println("Ganancia por inversion: " +Math.ceil(gananciaInversion));
			System.out.println("Monto Final: " +Math.ceil(montoFinal));
		}
		else {
			System.out.println("No es posible procesar su solicitud con los datos proporcionados");
		}
	}
}
