package com.demo.cc.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.cc.dto.FileData;
import com.demo.cc.dto.Sample;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/manageSample")

public class SampleController {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@PostMapping(value = "/sample",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Sample> saveSample( @Valid @RequestBody Sample sample){
		return new ResponseEntity<>(sample, HttpStatus.CREATED);
	}
	
	@PostMapping(value ="/upload",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<String> uploadFile(@RequestPart(value = "data") String data,@RequestPart(value = "file") MultipartFile multipartFile){
		
		try {
			FileData fileData = objectMapper.readValue(data, FileData.class);
			
			String fileDirectoryName = "uploadFiles/";
			
			File filedirectory = new File(fileDirectoryName);
			
			if (!filedirectory.exists()) {
				filedirectory.mkdir();
			}
			
			File file = new File(filedirectory+"/"+multipartFile.getOriginalFilename());
			
			FileOutputStream  fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(multipartFile.getBytes());
			
			fileOutputStream.close();
			
			String output = "fileType "+fileData.getFileType() + "original file name "+multipartFile.getOriginalFilename();
			
			return new ResponseEntity<String>(output,HttpStatus.CREATED);
			
		}
		catch(Exception ex) {
			return new ResponseEntity<String>("Some error at server",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}
