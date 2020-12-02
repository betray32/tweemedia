package cl.tweemedia.launcher;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import cl.tweemedia.controller.TwitterController;
import cl.tweemedia.util.ConstantesProp;

/**
 * Se ejecuta automaticamente
 * 
 * @author camilo
 *
 */
@Component
@Profile("!test")
public class CommandLine implements CommandLineRunner {

	@Autowired
	private TwitterController twitter;

	@Autowired
	private ConstantesProp prop;

	/**
	 * Automatico
	 */
	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		System.out.println("--------------------------");
		System.out.println("Inicializando...");
		System.out.println("Bienvenido a Tweemedia");

		System.out.println("Indique la Opcion Deseada");
		System.out.println("1. Ingreso con Teclado");
		System.out.println("2. Seteo en archivo de Configuracion");

		int opcion = scanner.nextInt();

		System.out.println("--------------------------");

		switch (opcion) {
		case 1:

			System.out.println("Ingrese las opciones deseadas");

			System.out.println("--------------------------");
			System.out.println("Perfil de Twitter");
			String perfil = scanner.next();

			System.out.println("--------------------------");
			System.out.println("Directorio de Descarga");
			String directorio = scanner.next();

			System.out.println("--------------------------");
			System.out.println("Cantidad de Registros");
			String cantidadRegistros = scanner.next();

			System.out.println("--------------------------");
			System.out.println("Descargar Fotos?");
			String fotos = scanner.next();

			System.out.println("--------------------------");
			System.out.println("Descargar Videos?");
			String videos = scanner.next();

			scanner.close();
			twitter.guardarMedia(fotos, videos, perfil, directorio, cantidadRegistros);

			break;

		case 2:

			System.out.println("Inicializando Flujo en Base a Archivo de Properties");
			System.out.println("Desplegando propiedades");
			System.out.println("--------------------------");
			System.out.println("Perfil = " + prop.perfil);
			System.out.println("Directorio de Descarga = " + prop.directorio);
			System.out.println("Registros Deseados = " + prop.nroregistros);
			System.out.println("Fotos = " + prop.fotos);
			System.out.println("Videos = " + prop.videos);
			System.out.println("--------------------------");

			twitter.guardarMedia(prop.fotos, prop.videos, prop.perfil, prop.directorio, prop.nroregistros);
			break;

		default:
			System.err.println("Opcion Incorrecta");
			break;
		}

		System.out.println("Programa Finalizado");

	}

}
