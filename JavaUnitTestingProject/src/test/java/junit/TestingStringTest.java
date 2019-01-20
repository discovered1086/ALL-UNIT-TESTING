package junit;

import junit.framework.TestCase;
import mypractice.unittesting.junit.PlayingWithString;
import mypractice.unittesting.junit.StringTest;

import org.junit.Assert;
import org.junit.Test;


public class TestingStringTest extends TestCase {

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