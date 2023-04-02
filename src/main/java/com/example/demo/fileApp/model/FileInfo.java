package com.example.demo.fileApp.model;

public class FileInfo {
	   private long size;
	   private String fileName;
	   private long modfied;
       private StringBuilder content;
       
       public FileInfo() {
           size = 0;
           content = new StringBuilder();
       }
       
       public void incrementSize(long amount) {
           size += amount;
       }
       
       public long getSize() {
           return size;
       }
       
       public void addContent(String line) {
           content.append(line);
           content.append(" ");
       }
       
       public String getContent() {
           return content.toString();
       }

		public String getFileName() {
			return fileName;
		}
	
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public long getModfied() {
			return modfied;
		}

		public void setModfied(long l) {
			this.modfied = l;
		}

}
