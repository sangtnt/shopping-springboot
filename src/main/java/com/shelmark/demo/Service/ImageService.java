package com.shelmark.demo.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	public String uploadFile(String uploadRootPath, MultipartFile file) {
		try {
            InputStream fis = file.getInputStream();
            byte[] data = new byte[fis.available()];
            fis.read(data);

            FileOutputStream out = new FileOutputStream(new File(uploadRootPath + "/" + file.getOriginalFilename()));

            out.write(data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("That bai");
        }

        System.out.println("Thanh cong : " + uploadRootPath + file.getOriginalFilename());

        return  file.getOriginalFilename();
	}
}
