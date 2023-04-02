package com.example.demo.fileApp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.example.demo.fileApp.fileService.FileServiceImpl;
import com.example.demo.fileApp.model.FileInfo;
import com.example.demo.fileApp.statisticsService.StatisticsServiceImpl;

public class DemoFileReaderApplication {

	public static void main(String[] args) {
		DemoFileReaderApplication demo = new DemoFileReaderApplication();
		  // The directory to scan
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
		demo.input(directoryPath);
	}
	
	public void input(String directoryPath) {
	
        File directory = new File(directoryPath);
   	    FileServiceImpl fileServiceImpl = new FileServiceImpl();
   	    Map<String, FileInfo> fileInfoMapped = fileServiceImpl.getFileExtrasction(directory);
   	    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
   	    
   	  // Print the results
        for (String extension : fileInfoMapped.keySet()) {
            FileInfo fileInfo = fileInfoMapped.get(extension);
         // print results
            System.out.println("=============================================================================");
            System.out.println("FileName ----> "+ extension+ " <---- ");
            System.out.println("Number of Words: " + statisticsServiceImpl.countMaxWord(fileInfo.getContent().toString()));
            System.out.println("Number of Dots: " + statisticsServiceImpl.countMaxDot(fileInfo.getContent().toString()));
            System.out.println("" +statisticsServiceImpl.countMaxWordUsed(fileInfo.getContent().toString()));
            fileServiceImpl.movedProcessFile(directoryPath, extension);
            System.out.println(" Moved ----> "+ extension+ " <---- Moved ");
            System.out.println("=============================================================================");
        }
   	    
	}

}
