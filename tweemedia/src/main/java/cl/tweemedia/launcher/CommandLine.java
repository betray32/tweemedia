package cl.tweemedia.launcher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Se ejecuta automaticamente
 * 
 * @author camilo
 *
 */
@Component
public class CommandLine implements CommandLineRunner {

	/**
	 * Automatico
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ejecucion automatica");
	}
	

}
