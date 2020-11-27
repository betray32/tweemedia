package cl.tweemedia.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

/**
 * Controlador para las funciones de twitter
 * 
 * @author camilo
 *
 */
public class TwitterInstance {

	/**
	 * Obtener una instancia de twitter
	 * 
	 * @return
	 */
	public static Twitter getTwitterinstance() {
		Twitter twitter = TwitterFactory.getSingleton();
		return twitter;
	}

}
