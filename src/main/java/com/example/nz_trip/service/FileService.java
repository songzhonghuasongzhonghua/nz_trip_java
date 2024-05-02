package com.example.nz_trip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;


@Service
public class FileService {
    public String path;

    public FileService(String filePath){
        this.path = filePath;
    }
    public FileService(){

    }

    public  String saveImageToFolder(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String prefix = UUID.randomUUID().toString().replace("-", "");
        String fileName = prefix + originalFilename;

        //upload file
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        String path = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath() +"\\target\\classes\\static\\" +this.path +"\\";
        System.out.println(path + "------------------------");
        try {
            file.transferTo(new File(path + fileName));
            return  this.path +"/" + fileName;
        }catch(Exception e) {
            return "";
        }
    }
}