package cl.tweemedia.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * Utiles
 * 
 * @author camilo.cc
 *
 */
public class Utiles {

	/**
	 * Permite copiar una url a un archivo fisico
	 * 
	 * REVISAR!
	 * 
	 * @param url
	 * @param path
	 * @return
	 */
	public static int urlToFile(String url, String path) {
		try {

			String nombreArchivo = url.substring(url.lastIndexOf("/") + 1);

			/*
			 * Se debe de validar que el ultimo caracter debe de ser un slash
			 */
			String validarUltimoCaracter = path.substring(path.length() - 1);
			if ( !"/".equalsIgnoreCase(validarUltimoCaracter) ) {
				path = path + "/";
			}

			FileUtils.copyURLToFile(new URL(url), new File(path + nombreArchivo));
			return 1;

		} catch (MalformedURLException e) {
			System.err.println("Error when downloading and writing, Detail > " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error when downloading and writing, Detail > " + e.getMessage());
			e.printStackTrace();
		}

		return 0;
	}

}
