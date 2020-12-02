package cl.tweemedia.controller;

import org.springframework.stereotype.Controller;

/**
 * Permite realizar las distintas acciones en base a twitter
 * 
 * @author camilo.cc
 *
 */
@Controller
public interface TwitterController {

	/**
	 * Permite guardar los archivos media de un perfil especifico de twitter, lee directamente desde la linea de comandos
	 * 
	 * @param fotos
	 * @param videos
	 * @param perfil
	 * @param cantidadRegistros
	 * @return
	 */
	public boolean guardarMedia(String fotos, String videos, String perfil, String rutaDirectorio, String cantidadRegistros);

}
