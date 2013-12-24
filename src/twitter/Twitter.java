package twitter;

import java.io.*;

public class Twitter {
	private BufferedReader reader ;
	private MessageHandler messageHandler ;

	public Twitter() {
		reader = new BufferedReader( new InputStreamReader( System.in ) ) ;
		messageHandler = new MessageHandler() ;
	}

	public void menu() {
		while ( true ) {
			System.out.print( "> " ) ;
			String inputLine = "" ;
			try {
				inputLine = reader.readLine();
			} catch ( IOException e ) {
				e.printStackTrace() ;
			}
			
			int firstSpace = inputLine.indexOf( ' ' ) ;
			if ( firstSpace == -1 ) {
				System.out.println( messageHandler.getMessages( inputLine ) ) ;
			} else {
				String userName = inputLine.substring( 0,  firstSpace ) ;
				String restOfLine = inputLine.substring( firstSpace + 1 ) ;
				
				if ( restOfLine.startsWith( "->" ) ) {
					messageHandler.addMessage( userName, restOfLine.substring( 3 ) ) ;
				} else if ( restOfLine.startsWith( "follows" ) ) {
					messageHandler.follows( userName, restOfLine.substring( 8 ) ) ;
				} else if ( restOfLine.startsWith( "wall" ) ) {
					System.out.println( messageHandler.getWall( userName ) ) ;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Twitter().menu() ;
	}

}
