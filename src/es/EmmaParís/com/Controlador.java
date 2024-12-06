package es.EmmaParís.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Controlador {

	private Simulador simulador;

	public Controlador(Simulador simulador, SimuladorMT simuladorMT, SimuladorMP simuladorMP) {

		this.simulador = simulador;
		simulador.getBtnMultihilo().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				procesarMultihilo();
			}
		});

		simulador.getBtnMultiproceso().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				procesarMultiproceso();
			}
		});

	}

	/**Metodo que permite obtener las cantidades de las proteinas ingresadas por el usuario
	 * @return
	 */
	private int[] obtenerCantidadesProteinas() {
		int[] cantidades = new int[4];
		try {
			cantidades[0] = Integer.parseInt(simulador.getTextField_1().getText().trim());
			cantidades[1] = Integer.parseInt(simulador.getTextField_2().getText().trim());
			cantidades[2] = Integer.parseInt(simulador.getTextField_3().getText().trim());
			cantidades[3] = Integer.parseInt(simulador.getTextField_4().getText().trim());
		} catch (NumberFormatException e) {
			mostrarResultado("Por favor, introduce numeros válidos en todas las casillas");
		}
		return cantidades;
	}

	/**Metodo que permite que se muestre el resultado en el textArea.
	 * @param mensaje
	 */
	private void mostrarResultado(String mensaje) {
		simulador.getTextArea().append(mensaje + System.lineSeparator());// formatea contenido
	}

	/**
	 * Este método permite que al pulsar boton "Simulación Multihilo" con un grupo de 4 hilos 
	 * se ejecutan las tareas paralelamente
	 */
	private void procesarMultihilo() {
		int[] cantidades = obtenerCantidadesProteinas();
		long inicio = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(4);

		for (int tipo = 1; tipo <= 4; tipo++) {
			for (int i = 0; i < cantidades[tipo - 1]; i++) {
				executor.submit(new SimuladorMT(tipo));
			}
		}
		executor.shutdown();
		try {
			if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
				executor.shutdown();
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
			Thread.currentThread().interrupt();

		}

		long fin = System.currentTimeMillis();
		double tiempoTotal = (fin - inicio) / 1000.0;
		mostrarResultado("Simulación Multihilo completada en " + String.format("%.2f", tiempoTotal) + " segundos");

	}

	/**
	 * El metódo permite ejecutar el procedimiento "Simulación Multiproceso" al pulsar el botón, 
	 * que hace que se ejecute de manera separada cada simulación
	 */
	private void procesarMultiproceso() {
		int[] cantidades = obtenerCantidadesProteinas();
		long inicio = System.currentTimeMillis();
		for (int tipo = 1; tipo <= 4; tipo++) {
			for (int i = 0; i < cantidades[tipo - 1]; i++) {
				LanzadorSimuladorMP.lanzarSimuladorMP(tipo);
			}
		}
		long fin = System.currentTimeMillis();
		double tiempoTotal = (fin - inicio) / 1000.0;
		mostrarResultado("Simulación Multiproceso completada en " + String.format("%.2f", tiempoTotal) + " segundos");

	}
}
