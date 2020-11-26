package cl.tweemedia.launcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.social.twitter.api.Stream;
import org.springframework.social.twitter.api.Tweet;
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

	/**
	 * Nombre del perfil a obtener la data
	 */
	private static final String PROFILE_ID = "";

	/**
	 * Conector de Twitter
	 */
	@Autowired
	private Twitter twitter;

	private Stream userStream;

	/**
	 * Automatico
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ejecucion automatica");
		System.out.println("Inicializando logica para Twitter...");

		System.out.println("Obteniendo la información de perfil [" + PROFILE_ID + "]");
		List<Tweet> tweets = twitter.timelineOperations().getUserTimeline(PROFILE_ID);
		System.out.println("Data obtenida correctamente");
		System.out.println("Obteniendo media de tweets...");
		
		for ( Tweet t : tweets ) {
		
			if ( t.hasMedia() && !t.isRetweet() && !t.isRetweet() ) {
				System.out.println("OK!");
			}
			
		}
		
	}

}
