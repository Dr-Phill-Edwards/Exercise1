package twitter;

import java.util.*;
import org.junit.*;

public class PostTest {
	private static final String MESSAGE = "I love the weather today" ;
	private Calendar calendar ;

	@Before
	public void setUp() throws Exception {
		calendar = Calendar.getInstance() ;
	}

	@Test
	public void testFiveSecondsAgo() {
		calendar.add( Calendar.SECOND, -5 ) ;
		Post post = new Post( calendar.getTime(), MESSAGE ) ;
		Assert.assertEquals( "5 seconds ago", MESSAGE + " (5 seconds ago)", post.toString() ) ;
	}

	@Test
	public void testFiveMinutesAgo() {
		calendar.add( Calendar.MINUTE, -5 ) ;
		Post post = new Post( calendar.getTime(), MESSAGE ) ;
		Assert.assertEquals( "5 minutes ago", MESSAGE + " (5 minutes ago)", post.toString() ) ;
	}
}
