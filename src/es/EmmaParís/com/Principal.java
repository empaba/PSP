package es.EmmaParís.com;

/**El siguiente codigo uso MVC, La interfaz grafica(vista) es Simulador.java.
 * Luego, el modelo estaria dividido en dos: simulador Multiproceso y Simulador Multihilo.
 * Finalmente controlador que permite que interactuen ambos.
 * 
 * @author Emma París
 *
 */
public class Principal {

	public static void main(String[] args) {
		 Simulador simulador = new Simulador();//vista
		 SimuladorMT simuladorMT = new SimuladorMT(0); 
		 SimuladorMP simuladorMP= new SimuladorMP();
		 Controlador controlador= new Controlador(simulador,simuladorMT,simuladorMP);

	}

}
