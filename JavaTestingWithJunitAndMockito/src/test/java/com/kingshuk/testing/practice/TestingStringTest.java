package com.kingshuk.testing.practice;

import org.junit.Assert;
import org.junit.Test;

import com.kingshuk.testing.practice.test.PlayingWithString;
import com.kingshuk.testing.practice.test.StringTest;

public class TestingStringTest {
	@Test
    public void testStringTest(){
        StringTest test=new StringTest();
        Assert.assertEquals("ABCD", test.checkEmptydata("ABCD"));
    }


    @Test
    public void testPlayingWithString() throws Exception {
      Assert.assertEquals("8664115613", new PlayingWithString().returnFaxNumber("FAX (866) 411-5613"));
    }
}
