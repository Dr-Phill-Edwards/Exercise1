package twitter;

import org.junit.*;

public class MessageHandlerTest {
	private static final String ALICE_1 = "I love the weather today" ;
	private static final String BOB_1 = "Oh, we lost!" ;
	private static final String BOB_2 = "at least it's sunny" ;
	private static final String TIME_AGO = " (0 seconds ago)\n" ;
	private MessageHandler messageHandler ;

	@Before
	public void setUp() throws Exception {
		messageHandler = new MessageHandler() ;
		messageHandler.addMessage( "Alice", ALICE_1 ) ;
		messageHandler.addMessage( "Bob", BOB_1 ) ;
		messageHandler.addMessage( "Bob", BOB_2 ) ;
	}

	@Test
	public void testReadAlice() {
		Assert.assertEquals( "Read Alice", ALICE_1 + TIME_AGO, messageHandler.getMessages( "Alice" ) ) ;
	}

	@Test
	public void testReadBob() {
		Assert.assertEquals( "Read Bob", BOB_2 + TIME_AGO + BOB_1 + TIME_AGO, messageHandler.getMessages( "Bob" ) ) ;
	}
}
