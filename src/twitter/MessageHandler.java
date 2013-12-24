package twitter;

import java.util.*;

public class MessageHandler {
	private Map<String,List<Post>> messageMap ;
	private Map<String,List<String>> followsMap ;

	public MessageHandler() {
		messageMap = new HashMap<String,List<Post>>() ;
		followsMap = new HashMap<String,List<String>>() ;
	}

	public void addMessage( String name, String message ) {
		List<Post> nameList = messageMap.get( name ) ;
		if ( nameList == null ) {
			nameList = new ArrayList<Post>() ;
			messageMap.put( name, nameList ) ;
		}
		nameList.add( 0, new Post( message ) ) ;
	}
	
	public String getMessages( String name ) {
		StringBuilder sb = new StringBuilder() ;
		for ( Post post : messageMap.get( name ) ) {
			sb.append( post.toString() ) ;
			sb.append( "\n" ) ;
		}
		return sb.toString() ;
	}

	public void follows( String name, String follows ) {
		List<String> following = followsMap.get( name ) ; 
		if ( following == null ) {
			following = new ArrayList<String>() ;
			followsMap.put( name, following ) ;
		}
		following.add( follows ) ;
	}
	
	public String getWall( String name ) {
		Set<Post> wall = new TreeSet<Post>() ;
		addMessages( wall, name ) ;
		for ( String following : followsMap.get( name ) ) {
			addMessages( wall, following ) ;
		}
		
		StringBuilder sb = new StringBuilder() ;
		for ( Post post : wall ) {
			sb.append( post.toString() ) ;
			sb.append( "\n" ) ;
		}
		return sb.toString() ;
	}
	
	private void addMessages( Set<Post> wall, String name ) {
		for ( Post post : messageMap.get( name ) ) {
			wall.add( new Post( post.getPostDate(), name + " - " + post.getMessage() ) ) ;
		}
	}
}
