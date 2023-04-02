package com.example.demo.fileApp.statisticsService;

import java.util.Map;

import com.example.demo.fileApp.model.FileInfo;

public abstract class AStatisticsService {
	
	 public abstract int countMaxWord(String content);
	 
	 public abstract int countMaxDot(String content);
	 
	 public abstract String countMaxWordUsed(String content);

}
