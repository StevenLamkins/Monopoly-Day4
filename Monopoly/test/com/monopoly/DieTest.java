package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.monopoly.Die;

public class DieTest {
	private int value;
	
//	@Before
//	public void theSetup()
//	{
		//setup
				Die die1 = new Die();
			//	Die die2 = new Die();
				
				//exercise
				//try
			//	{
				//	 value = die1.roll(1);
					//	die2.roll(2);
				
				//}
			//	catch(Exception e)
			//	{
		//			System.out.println("You have made a unbelivably stupid error");
		//		}
		//		finally
		//		{
		//			System.out.println("Congratulations on completing Lab 5: Create a Class ");
		//		}
//	}

	@Test
	public void testRollGreaterThan()
	{
		for (int i = 0; i <1000; i++)
		{
			//verify
			value = die1.roll();
			assertTrue(value > 0);
		}
		
	}
	
	@Test
	public void testRollLessThan()
	{
		for (int i = 0; i < 1000; i++)
		{
			//verify
			value = die1.roll();
			assertTrue(value < 7);
		}
		
	}
	
	public void testWeirdBug()
	{
			//verify
		Die die = new Die();
		assertNotEquals(0,die.getFaceValue());		
	}

}
