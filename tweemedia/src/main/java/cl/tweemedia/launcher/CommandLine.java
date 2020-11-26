package cl.tweemedia.launcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.social.twitter.api.Trends;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

/**
 * Se ejecuta automaticamente
 * 
 * @author camilo
 *
 */
@Component
public class CommandLine implements CommandLineRunner {

	
	@Autowired
	private Twitter twitter;
	
	/**
	 * Automatico
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ejecucion automatica");
		System.out.println("Inicializando logica para Twitter...");
		
		Trends trends = twitter.searchOperations().getLocalTrends(23424782);
		System.out.println("Trending para Chile: " + trends.getTime());
	}
	

}
