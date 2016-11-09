package fr.iut.tpjunit.AppTest;

import org.junit.Test;


import fr.iut.tpjunit.App.App;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

public class AppTest {
	
	private App appObject = new App();
	/*@Test
	public void testSun(){
		int param1 =1, param2=1;
		int result= App.sum(param1,param2);
		assertEquals(2,result);
	}*/
	
	
	@Test
	public void testSum_2_plus_2(){
		
		int param1 = 2, param2 = 2, result=0;
		
		result = appObject.sum(param1, param2);
		
		
		Assert.assertEquals(4, result);
		
	}
}
