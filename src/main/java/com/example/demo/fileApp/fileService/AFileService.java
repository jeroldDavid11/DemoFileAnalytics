package com.example.demo.fileApp.fileService;

import java.io.File;
import java.util.Map;

import com.example.demo.fileApp.model.FileInfo;

public abstract class AFileService {
	
	 public abstract Map<String, FileInfo> getFileExtrasction(File file);
}
