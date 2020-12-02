package cl.tweemedia.launcher;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import cl.tweemedia.controller.TwitterController;

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
		System.out.println("2. Seteo en archivo de configuracion");

		int opcion = scanner.nextInt();

		switch (opcion) {
		case 1:

			System.out.println("Ingrese las opciones deseadas");

			System.out.println("--------------------------");
			System.out.println("Perfil de Twitter");
			String perfil = scanner.next();

			System.out.println("--------------------------");
			System.out.println("Directorio de Descarga");
			String directorio = scanner.nextLine();

			System.out.println("--------------------------");
			System.out.println("Cantidad de Registros");
			String cantidadRegistros = scanner.nextLine();

			System.out.println("--------------------------");
			System.out.println("Descargar Fotos?");
			String fotos = scanner.nextLine();

			System.out.println("--------------------------");
			System.out.println("Descargar Videos?");
			String videos = scanner.nextLine();

			scanner.close();
			twitter.guardarMedia(fotos, videos, perfil, directorio, cantidadRegistros);

			break;

		case 2:

			break;

		default:
			System.err.println("Opcion Incorrecta");
			break;
		}

		System.out.println("Programa Finalizado");

	}

}
