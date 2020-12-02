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
	public boolean guardarMedia(String fotos, String videos, String perfil, String rutaDirectorio, String cantidadRegistros) {

		ResponseList<Status> mediaList = null;

		/*
		 * Obteniendo informacion desde twitter
		 */
		try {
			mediaList = twitter.getMediaFromTimeline(perfil, Integer.parseInt(cantidadRegistros));
		} catch (TwitterException e) {
			System.err.println("Ha fallado al momento de obtener la info de twitter, Detalle > " + e.getMessage());
		}

		if (mediaList == null) {
			System.err.println("Error al obtener la informacion desde el origen, abortando.");
			return false;
		}
		/*****************************************/

		System.out.println("Data obtenida correctamente");
		System.out.println("Filtrando archivos de medios");

		List<MediaEntity> lFotos = new ArrayList<>();
		List<MediaEntity> lVideos = new ArrayList<>();
		filtroMedia(mediaList, lFotos, lVideos);

		System.out.println("Cantidad de Fotos Encontradas [" + lFotos.size() + "]");
		System.out.println("Cantidad de Videos Encontrados [" + lVideos.size() + "]");
		System.out.println("Cantidad total de medios [" + (lFotos.size() + lVideos.size()) + "]");

		System.out.println("Escribiendo en disco...");
		if ("1".equals(fotos)) {
			for (MediaEntity f : lFotos) {
				String urlFoto = f.getMediaURL();
				System.out.println("Url de la foto: " + urlFoto);
				Utiles.urlToFile(urlFoto, rutaDirectorio);
			}
		}

		if ("1".equals(videos)) {
			for (MediaEntity v : lVideos) {
				Variant[] variantesVideo = v.getVideoVariants();
				Variant mejorCalidad = variantesVideo[v.getVideoVariants().length - 1];
				String urlVideo = mejorCalidad.getUrl().substring(0, mejorCalidad.getUrl().indexOf("?"));
				System.out.println("Url del video: " + urlVideo);
				Utiles.urlToFile(urlVideo, rutaDirectorio);
			}
		}

		return false;
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
