package cl.tweemedia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cl.tweemedia.twitter.TwitterFunctions;
import cl.tweemedia.util.Utiles;
import twitter4j.MediaEntity;
import twitter4j.MediaEntity.Variant;
import twitter4j.ResponseList;
import twitter4j.Status;
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
	public boolean guardarMedia(String fotos, String videos, String perfil, String rutaDirectorio,
			String cantidadRegistros) {

		ResponseList<Status> mediaList = null;

		/*
		 * Obteniendo informacion desde twitter
		 */
		try {
			mediaList = twitter.getMediaFromTimeline(perfil, Integer.parseInt(cantidadRegistros));
		} catch (TwitterException e) {
			System.err.println("Program has failed when retrieven info from twitter, Detail > " + e.getMessage());
		}

		if (mediaList == null) {
			System.err.println("Error When connecting to twitter, Aborting...");
			return false;
		}
		/*****************************************/

		System.out.println("Data OK!");
		System.out.println("Filtering Media Files...");

		List<MediaEntity> lFotos = new ArrayList<>();
		List<MediaEntity> lVideos = new ArrayList<>();
		filtroMedia(mediaList, lFotos, lVideos);

		System.out.println("Photos [" + lFotos.size() + "] Files");
		System.out.println("Videos [" + lVideos.size() + "] Files");
		System.out.println("Total of Media Found [" + (lFotos.size() + lVideos.size()) + "] Files");

		System.out.println("Writing in disk...");
		if ("1".equals(fotos)) {
			System.out.println("******************");
			System.out.println("Downloading Photos");
			for (MediaEntity f : lFotos) {
				String urlFoto = f.getMediaURL();
				System.out.println("URL [" + urlFoto + "]");
				Utiles.urlToFile(urlFoto, rutaDirectorio);
			}
			System.out.println("******************");
		}

		if ("1".equals(videos)) {
			System.out.println("******************");
			System.out.println("Downloading Videos");
			for (MediaEntity v : lVideos) {
				Variant[] variantesVideo = v.getVideoVariants();
				Variant mejorCalidad = variantesVideo[0];
				String urlVideo = mejorCalidad.getUrl().substring(0, mejorCalidad.getUrl().indexOf("?"));
				System.out.println("URL [" + urlVideo + "]");
				Utiles.urlToFile(urlVideo, rutaDirectorio);
			}
			System.out.println("******************");
		}

		return true;
	}

	/**
	 * Permite filtrar si el media es video o foto
	 * 
	 * @param mediaList
	 * @param lFotos
	 * @param lVideos
	 */
	private void filtroMedia(ResponseList<Status> mediaList, List<MediaEntity> lFotos, List<MediaEntity> lVideos) {
		for (Status media : mediaList) {
			MediaEntity[] mediaEntities = media.getMediaEntities();
			for (MediaEntity entity : mediaEntities) {

				if ("photo".equalsIgnoreCase(entity.getType())) {
					lFotos.add(entity);
					continue;
				} else if ("video".equalsIgnoreCase(entity.getType())) {
					lVideos.add(entity);
					continue;
				}
			}
		}
	}

}
