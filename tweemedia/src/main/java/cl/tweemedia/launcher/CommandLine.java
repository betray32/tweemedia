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
		System.out.println("Initializing...");
		System.out.println("Welcome to Tweemedia!");

		System.out.println("Choose your preference");
		System.out.println("1. Configure with file (application.properties)");
		System.out.println("2. Keyboard input");

		int opcion = scanner.nextInt();

		System.out.println("--------------------------");

		switch (opcion) {
		
		case 1:

			System.out.println("Initializing with Propertie File");
			System.out.println("Showing Sets");
			System.out.println("--------------------------");
			System.out.println("Profile ID = " + prop.perfil);
			System.out.println("Download Folder = " + prop.directorio);
			System.out.println("Records = " + prop.nroregistros);
			System.out.println("Photos ? (1 for yes, 2 for no) = " + prop.fotos);
			System.out.println("Videos ? (1 for yes, 2 for no) = " + prop.videos);
			System.out.println("--------------------------");

			twitter.guardarMedia(prop.fotos, prop.videos, prop.perfil, prop.directorio, prop.nroregistros);
			break;
			
		case 2:

			System.out.println("Please, input your options");

			System.out.println("--------------------------");
			System.out.println("Twitter ID");
			String perfil = scanner.next();

			System.out.println("--------------------------");
			System.out.println("Download Folder");
			String directorio = scanner.next();

			System.out.println("--------------------------");
			System.out.println("How Many Records?");
			String cantidadRegistros = scanner.next();

			System.out.println("--------------------------");
			System.out.println("Include Photos? (1 for yes, 2 for no)");
			String fotos = scanner.next();

			System.out.println("--------------------------");
			System.out.println("Include Videos? (1 for yes, 2 for no)");
			String videos = scanner.next();

			scanner.close();
			twitter.guardarMedia(fotos, videos, perfil, directorio, cantidadRegistros);

			break;

		default:
			System.err.println("Incorrect Option");
			break;
		}

		System.out.println("Finished");

	}

}
