package cl.tweemedia.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

/**
 * Configuracion para el bean de Twitter
 * 
 * @author camilo
 *
 */
@Configuration
public class TwitterConfig {

	@Value("${spring.social.twitter.appId}")
	private String consumerKey;

	@Value("${spring.social.twitter.appSecret}")
	private String consumerSecret;

	@Value("${twitter.access.token}")
	private String accessToken;

	@Value("${twitter.access.token.secret}")
	private String accessTokenSecret;

	/**
	 * Twitter template
	 * 
	 * @return
	 */
	@Bean
	TwitterTemplate getTwtTemplate() {
		return new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
	}
	
}
