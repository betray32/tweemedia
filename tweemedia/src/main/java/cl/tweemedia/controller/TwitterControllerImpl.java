package cl.tweemedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cl.tweemedia.twitter.TwitterFunctions;
import twitter4j.MediaEntity;
import twitter4j.TwitterException;

/**
 * Implementa la logica de twitter controller
 * 
 * @author camilo.cc
 *
 */
@Controller
public class TwitterControllerImpl implements TwitterController {
	
	/**
	 * api de twitter implementada
	 */
	@Autowired
	private TwitterFunctions twitter;

	@Override
	public boolean guardarMedia(String fotos, String videos, String perfil, String rutaDirectorio, String cantidadRegistros) {

		try {
			
			System.out.println("Obteniendo informacion...");
			
		} catch (Exception e) {
			System.err.println("Ha fallado al momento de obtener la info de twitter, Detalle > " + e.getMessage());
		}
		
		return false;
	}

}
