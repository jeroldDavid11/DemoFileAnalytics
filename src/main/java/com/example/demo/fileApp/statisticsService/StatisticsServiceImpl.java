package com.example.demo.fileApp.statisticsService;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.fileApp.model.FileInfo;

public class StatisticsServiceImpl extends AStatisticsService {

	@Override
	public int countMaxWord(String content) {
	        String newStr = content.replaceAll("[^a-zA-Z\\s]", "").trim();
            String[] words = newStr.split(" ");
            int wordCount = 0;
            Map<Integer, String> wordMap = new HashMap<>();
            for (String word : words) {
            	   // add word to map
                  String value = word.toLowerCase();
            	 if (!value.isEmpty() ) {
                     wordMap.put(wordCount, value);
                 }
                 wordCount++;
            }
		return wordMap.size();
	}

	@Override
	public int countMaxDot(String content) {
		int dotCount = content.length() - content.replace(".", "").length();
		return dotCount;
	}

	@Override
	public String countMaxWordUsed(String content) {
		   Map<String, Integer> wordMap = new HashMap<>();
		   String newStr = content.replaceAll("[^a-zA-Z\\s]", "").trim();
           String[] words = newStr.split(" ");
           
		   String mostUsedWord = "";
	        int maxCount = 0;
	        
	        for (String word : words) {
	        	  // add word to map
                String key = word.toLowerCase();
                if (wordMap.containsKey(key)) {
                    wordMap.put(key, wordMap.get(key) + 1);
                } else {
                    wordMap.put(key, 1);
                }
	        
	        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
	            if (entry.getValue() > maxCount) {
	                mostUsedWord = entry.getKey();
	                maxCount = entry.getValue();
	            }
	          }
	        }
		
		return "Most frequently occurring word : " + mostUsedWord +" Number Used : " + maxCount;
	}

}
