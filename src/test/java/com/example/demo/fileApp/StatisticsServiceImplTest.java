package com.example.demo.fileApp;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.demo.fileApp.fileService.FileServiceImpl;
import com.example.demo.fileApp.statisticsService.StatisticsServiceImpl;

public class StatisticsServiceImplTest {
	
    private StatisticsServiceImpl statisticsServiceImpl;

	@Test
	public void testCountMaxDot() {
		statisticsServiceImpl = new StatisticsServiceImpl();
		String testContent = "Jerold. Test. Bake.";
		int count = statisticsServiceImpl.countMaxDot(testContent);
		assertEquals(3,count);
	}

	@Test
	public void testCountMaxWord() {
		statisticsServiceImpl = new StatisticsServiceImpl();
		String testContent = "Jerold. Test. Bake. base cat fog";
		int count = statisticsServiceImpl.countMaxWord(testContent);
		assertEquals(6,count);
	}
	
	@Test
	public void testCountMaxWordUsed() {
		statisticsServiceImpl = new StatisticsServiceImpl();
		String testContent = "test. Test. Bake. test cat fog test ";
		String Response = statisticsServiceImpl.countMaxWordUsed(testContent);
		assertEquals("Most frequently occurring word : test Number Used : 4",Response);
	}
}
