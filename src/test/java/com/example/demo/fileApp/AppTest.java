package com.example.demo.fileApp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	
	private DemoFileReaderApplication demoFileReaderApplication;
    @Test
    public void shouldAnswerWithTrue()
    {
    	String testDirecoty = "C:\\sample-test";
    	demoFileReaderApplication = new DemoFileReaderApplication();
    	demoFileReaderApplication.input(testDirecoty);
        assertTrue( true );
    }
}
