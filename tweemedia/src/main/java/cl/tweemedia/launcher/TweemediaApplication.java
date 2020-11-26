package cl.tweemedia.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main Launcher
 * 
 * @author camilo
 *
 */
@SpringBootApplication
@ComponentScan( "cl.tweemedia.*" )
public class TweemediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweemediaApplication.class, args);
	}

}
