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

			FileUtils.copyURLToFile(new URL(url), new File(path + "1.jpg"), 10, 10);
			return 1;

		} catch (MalformedURLException e) {
			System.err.println("Error al copiar el archivo, Detalle > " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al copiar el archivo, Detalle > " + e.getMessage());
			e.printStackTrace();
		}

		return 0;
	}

}
