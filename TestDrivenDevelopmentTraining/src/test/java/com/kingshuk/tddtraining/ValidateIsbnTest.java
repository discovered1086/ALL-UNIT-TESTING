package com.kingshuk.tddtraining;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ValidateIsbnTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
		
		ValidateISBN validator = new ValidateISBN();
		
		boolean isIsbnValid=validator.checkIsbn(8173666024);
		
		//Next we write what do we expect the result to be. That is what
		//We can assertion
		
	}

}
