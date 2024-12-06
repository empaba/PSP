package es.EmmaParís.com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimuladorMP {

	public double simulation(int type) {
		double calc = 0.0;
		double simulationTime = Math.pow(5, type);
		double startTime = System.currentTimeMillis();
		double endTime = startTime + simulationTime;
		while (System.currentTimeMillis() < endTime) {
			calc = Math.sin(Math.pow(Math.random(), 2));
		}
		return calc;
	}

	/**Este método permite guardar en ficheros los resultados obtenidos
	 * de la simulación MultiProceso.
	 * @param tipo
	 * @param resultado
	 * @param tiempoInicio
	 */
	public void guardarResultado(int tipo, double resultado, long tiempoInicio) {
		String tiempoEjecucion = new SimpleDateFormat("ddMMyyyy_HHmmss_SSS").format(new Date());
		String nombreFichero = "PROT_MP_" + tipo + "_n" + tiempoEjecucion + ".sim";
		File fichero = new File(nombreFichero);

		try (FileWriter w = new FileWriter(fichero)) {
			w.write(tiempoEjecucion + "\n");
			long tiempoFinal = System.currentTimeMillis();
			String tiempoFinalEjecucion = new SimpleDateFormat("ddMMyyyy_HHmmss_SSS").format(new Date());
			w.write(tiempoFinalEjecucion + "\n");

			double tiempoSegundos = (tiempoFinal - tiempoInicio) / 1000.0;
			String formattedTime = String.format("%.2f", tiempoSegundos);
			w.write(formattedTime + "\n");

			w.write(resultado + "\n");
			System.out.println("Resultado guardadao" + nombreFichero);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		SimuladorMP s = new SimuladorMP();
		int tipo = Integer.parseInt(args[0]);
		long tiempoInicio = System.currentTimeMillis();
		double resultado = s.simulation(tipo);
		s.guardarResultado(tipo, resultado, tiempoInicio);
		System.out.println(resultado);

	}

}
