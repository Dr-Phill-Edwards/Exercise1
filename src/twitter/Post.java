package twitter;

import java.util.*;

public class Post implements Comparable<Post> {
	private Date postDate ;
	private String message ;

	public Post( Date date, String message ) {
		postDate = date ;
		this.message = message ;
	}
	
	public Post( String message ) {
		this( new Date(), message ) ;
	}

	public Date getPostDate() {
		return postDate;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public int compareTo( Post other ) {
		return (int)(other.postDate.getTime() - postDate.getTime() ) ;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder() ;
		sb.append( message ) ;
		sb.append( " (" ) ;
		long seconds = ( new Date().getTime() - postDate.getTime() ) / 1000 ;
		if ( seconds < 60 ) {
			sb.append( seconds ) ;
			sb.append( " seconds" ) ;
		} else {
			sb.append( seconds / 60 ) ;
			sb.append( " minutes" ) ;
		}
		sb.append( " ago)" ) ;
		return sb.toString() ;
	}

}
