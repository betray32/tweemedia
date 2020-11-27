package cl.tweemedia.launcher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cl.tweemedia.twitter.TwitterFunctions;
import twitter4j.TwitterException;

/**
 * Se ejecuta automaticamente
 * 
 * @author camilo
 *
 */
@Component
public class CommandLine implements CommandLineRunner {

	/**
	 * El id a obtener especifico
	 */
	private static final String PROFILE_ID = "";

	/**
	 * api de twitter implementada
	 */
	@Autowired
	private TwitterFunctions twitter;

	/**
	 * Automatico
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ejecucion automatica");
		System.out.println("Inicializando logica para Twitter...");

		System.out.println("Obteniendo timeline");
		List<String> timeline = new ArrayList<>();

		try {
			twitter.getMediaFromTimeline(PROFILE_ID);
		} catch (TwitterException e) {
			System.err.println("Ha fallado al momento de obtener la info de twitter, Detalle > " + e.getMessage());
		}

		System.out.println("Cantidad de Tweets obtenidos [" + timeline.size() + "]");

	}

}
