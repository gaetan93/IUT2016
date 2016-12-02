
//import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ObjectMapperTest {
	
	ObjectMapper sut = new ObjectMapper();

	@Test
	public void test_integers_are_literrals_in_json(){
		// Given
		// When
		String res = sut.object2Json(123);
		// Then
		Assert.assertEquals("123", res);
	}

	@Test
	public void test_string_are_escaped_with_quotes_in_json(){
		// Given
		// When
		String res = sut.object2Json("Hello");
		// Then
		Assert.assertEquals("\"Hello\"", res);
	}

	
	@Test
	public void test_object_are_surrounded_with_curly_brace(){
		Book book = new Book();
//		book.setTitle("golf");
		
		String res = sut.object2Json(book);
		
		String expected ="{ \"title\": \"golf\", \"pageCount\", 0 }";
		Assert.assertEquals(expected, res);
	}
	
	@Test
	public void test_collections_are_returned_within_square_brackets_in_json(){
		// Given
		List<Object> ls = new ArrayList<Object>();
		ls.add(1);
		ls.add("Hello");
		// When
		String res = sut.object2Json(ls);
		// Then
		Assert.assertEquals("[ 1, \"Hello\"]", res);
	}

}
