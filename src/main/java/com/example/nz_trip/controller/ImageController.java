package com.example.nz_trip.controller;

import com.example.nz_trip.service.FileService;
import com.example.nz_trip.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
@RequestMapping("/image")
public class ImageController {

    private final String imagePath = "image";

    static class SuccessRes {
        public final int code;
        public final Object data;
        public SuccessRes(String url) {
            this.code = 0;
            HashMap<String,String> map = new HashMap<>();
            map.put("url", url);
            this.data = map;
        }
    }

    @PostMapping("/upload")
    public Object uploadImages(@RequestParam(name = "image") MultipartFile file) {
        FileService fileService = new FileService(imagePath);
        if(file == null){
            return Result.failed().message("图片不能为空");
        }

        String imagePath =   fileService.saveImageToFolder(file);
        if("".equals(imagePath)){
            return Result.failed().message("图片保存失败");
        }else{
            SuccessRes successRes = new SuccessRes(imagePath);
            return successRes;
        }
    }
}
