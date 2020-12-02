package cl.tweemedia.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Definicion de constantes en properties
 * 
 * @author camilo.cc
 *
 */
@Component
public class ConstantesProp {

	@Value("${tweemedia.fotos}")
	public String fotos;

	@Value("${tweemedia.videos}")
	public String videos;

	@Value("${tweemedia.perfil}")
	public String perfil;

	@Value("${tweemedia.directorio}")
	public String directorio;

	@Value("${tweemedia.nroregistros}")
	public String nroregistros;

}
