package com.example.demo.fileApp;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Map;

import org.junit.Test;

import com.example.demo.fileApp.fileService.FileServiceImpl;
import com.example.demo.fileApp.model.FileInfo;

public class FileServiceImplTest {
	

    private FileServiceImpl fFileServiceImpl;

	@Test
	public void testgetFileExtrasction() {
        String directoryPath = "C:\\sample";
        File directory = new File(directoryPath);
		fFileServiceImpl = new FileServiceImpl();
		Map<String, FileInfo> fileMap = fFileServiceImpl.getFileExtrasction(directory);
		assertTrue(!fileMap.isEmpty());
	}
	
	
	@Test
	public void testmovedProcessFile() {
        String directoryPath = "C:\\sample";
        String fileName = "test.txt";
		fFileServiceImpl = new FileServiceImpl();
		String fileMoved = fFileServiceImpl.movedProcessFile(directoryPath, fileName);
		assertEquals("Moved",fileMoved);
	}

}
