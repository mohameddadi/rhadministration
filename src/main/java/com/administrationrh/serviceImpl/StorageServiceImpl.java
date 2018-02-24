package com.administrationrh.serviceImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.administrationrh.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService{
	
	private final Path rootLocation = Paths.get("upload-dir");

	@Override
	public void store(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
        	throw new RuntimeException("FAIL!");
        }
	}

	@Override
	public Resource loadFile(String filename) {
		try {
            Path file = rootLocation.resolve(filename);
            System.out.println(file.toUri());
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
            	throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
        	throw new RuntimeException("FAIL!");
        }
	}

	@Override
	public void init() {
		try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
		
	}
	

}
