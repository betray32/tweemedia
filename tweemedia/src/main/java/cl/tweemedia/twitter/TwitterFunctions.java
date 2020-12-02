package cl.tweemedia.twitter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import twitter4j.MediaEntity;
import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Realizar diversas funciones con twitter
 * 
 * @author camilo
 *
 */
@Component
public class TwitterFunctions {
	
	/**
	 * Obtener mi timeline
	 * 
	 * @return
	 */
	public List<String> getMyTimeLine() throws TwitterException {
	    Twitter twitter = TwitterInstance.getTwitterinstance();
	    
	    return twitter.getHomeTimeline().stream()
	      .map(item -> item.getText())
	      .collect(Collectors.toList());
	}
	
	/**
	 * Obtener el timeline especifico
	 * 
	 * @return
	 * @throws TwitterException
	 */
	public List<String> getTimeLine(String userId) throws TwitterException {
	    Twitter twitter = TwitterInstance.getTwitterinstance();

	    return twitter.getUserTimeline(userId).stream()
	      .map(item -> item.getText())
	      .collect(Collectors.toList());
	}
	
	/**
	 * obtener el media de un timeline
	 * 
	 * @throws TwitterException
	 */
	public List<MediaEntity[]> getMediaFromTimeline(String userId) throws TwitterException {

		List<MediaEntity[]> mediaEntities = null;
		Twitter twitter = TwitterInstance.getTwitterinstance();

		mediaEntities = twitter.getUserTimeline(userId)
				.stream()
				.map(item -> item.getMediaEntities())
				.collect(Collectors.toList());

		System.out.println("Media obtenida, Largo [" + mediaEntities.size() + "]");
		return mediaEntities;
	}
	
	/**
	 * obtener el media de un timeline
	 * 
	 * @throws TwitterException
	 */
	public List<MediaEntity[]> getMediaFromTimeline(String userId, int cantidadRegistros) throws TwitterException {

		List<MediaEntity[]> mediaEntities = null;
		Twitter twitter = TwitterInstance.getTwitterinstance();
		Paging p = new Paging();
		p.setCount(cantidadRegistros);

		mediaEntities = twitter.getUserTimeline(userId, p)
				.stream()
				.map(item -> item.getMediaEntities())
				.collect(Collectors.toList());

		System.out.println("Media obtenida, Largo [" + mediaEntities.size() + "]");
		return mediaEntities;
	}

}

