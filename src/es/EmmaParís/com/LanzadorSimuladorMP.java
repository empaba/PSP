package es.EmmaParís.com;


import java.util.ArrayList;
import java.util.List;

public class LanzadorSimuladorMP {

	/**Este método permite ejecutar simulaciones en procesos
	 * independientes .
	 * @param tipo
	 */
	public static void lanzarSimuladorMP(int tipo ) {
	
		try {
		   	String classpath="bin";
		   	String clase="es.EmmaParís.com.SimuladorMP";
		   	
		    List<String> command = new ArrayList<>();
		    command.add("java");
		    command.add("-cp");
		    command.add(classpath);
		    command.add(clase);
		    command.add(String.valueOf(tipo));
		
		    
		    ProcessBuilder builder = new ProcessBuilder(command);
			Process process=builder.start();
			
			int exitCode= process.waitFor();
			if(exitCode == 0) {
				System.out.println("Simulación para el tipo " + tipo +"completada");
			}else {
				System.out.println("Error al ejecutar proceso");
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
