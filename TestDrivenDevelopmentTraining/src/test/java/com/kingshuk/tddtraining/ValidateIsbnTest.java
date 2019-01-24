package com.kingshuk.tddtraining;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ValidateIsbnTest {
	
	private static ValidateISBN validator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		validator = new ValidateISBN();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void checkValidIsbn() {
		//fail("Not yet implemented");
		
			
		boolean isIsbnValid=validator.checkIsbn("8173666024");
		
		boolean isSecondIsbnValid = validator.checkIsbn("0199535566");
		
		//Next we write what do we expect the result to be. That is what
		//We call assertion
		
		//It's useful to add a text to say what we're testing here if there're multiple
		//tests that we're performing within the same method.
		assertTrue("The first value of 8173666024l",isIsbnValid);
		assertTrue("The second value of 9789387432291l",isSecondIsbnValid);
		
	}
	
	@Test
	public void checkInvalidIsbn() {
		//fail("Not yet implemented");
		
		
		boolean isIsbnValid=validator.checkIsbn("8173666824");
		
		boolean isSecondIsbnValid = validator.checkIsbn("0199535567");
		
		//Next we write what do we expect the result to be. That is what
		//We call assertion
		assertFalse(isIsbnValid);
		assertFalse(isSecondIsbnValid);
		
	}

}
