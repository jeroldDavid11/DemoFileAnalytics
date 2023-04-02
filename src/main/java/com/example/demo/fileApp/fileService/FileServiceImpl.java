package com.example.demo.fileApp.fileService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.example.demo.fileApp.model.FileInfo;
import com.example.demo.fileApp.util.ConstantVaraibles;

public class FileServiceImpl extends AFileService{
	

	@Override
	public Map<String, FileInfo> getFileExtrasction(File directory) {
		
		  // A map to store the file extensions, size, and content
        Map<String, FileInfo> fileMap = new HashMap<>();
	
       File[] files = directory.listFiles();
        
        for (File file : files) {
            // Check if the file has a valid extension
            if (getFileExtension(file)) {
            	 String fileName = file.getName();
            	 
                // Add the extension to the map if it doesn't exist
                if (!fileMap.containsKey(fileName)) {
                    fileMap.put(fileName, new FileInfo());
                }
                
                // Increment the size of the file
                fileMap.get(fileName).incrementSize(file.length());
                
                
                fileMap.get(fileName).setModfied(file.lastModified());                
                // Read the contents of the file
                try {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        // Add the line to the content of the file
                        fileMap.get(fileName).addContent(line);
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } 
            }
        }
        
      
     
		return fileMap;
	}
	
	
	public String movedProcessFile(String directory, String fileName){
		
	    // Path to the file to be moved
        Path source = Paths.get(directory + "\\" + fileName);
        System.out.println(source);
        // Path to the new directory where the file will be moved
        Path targetDir = Paths.get(ConstantVaraibles.FILE_DIRECTORY);
        
        try {
            // Create the target directory if it doesn't exist
            if (!Files.exists(targetDir)) {
                Files.createDirectories(targetDir);
            }
            
            // Move the file to the new directory
            Files.copy(source, targetDir.resolve(source.getFileName()));
            
            System.out.println("File moved successfully.");
        } catch (IOException e) {
            System.out.println("Error moving file: " + e.getMessage());
        }
		
		return "Moved";
		
	}

	private boolean getFileExtension(File fileName) {
		  // Check if the file has the desired extension
        if (fileName.getName().endsWith(ConstantVaraibles.FILE_EXTENSION)) { 
	        return true;
        }
	        return false;
	}

}
