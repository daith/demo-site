package com.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileAlreadyExistsException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageService {

	@Autowired
	ServletContext servletContext;

	public void save(MultipartFile file) {
		try {
			String relativeFolder = new File(".").getCanonicalPath() + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + "uploads" + File.separator;
			File path = new File(relativeFolder + file.getOriginalFilename());
			path.createNewFile();
			FileOutputStream output = new FileOutputStream(path);
			output.write(file.getBytes());
			output.close();

		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof FileAlreadyExistsException) {
				throw new RuntimeException("A file of that name already exists.");
			}

			throw new RuntimeException(e.getMessage());
		}
	}
}
