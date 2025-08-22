package com.demo.cc.dto;

public class FileData {

	@Override
	public String toString() {
		return "FileData [fileId=" + fileId + ", fileType=" + fileType + ", fileName=" + fileName + "]";
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private int fileId;
	
	private String fileType;
	
	private String fileName;
	
	

}
