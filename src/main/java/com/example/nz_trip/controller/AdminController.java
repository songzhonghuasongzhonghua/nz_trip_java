package com.example.nz_trip.controller;

import com.example.nz_trip.entity.Article;
import com.example.nz_trip.mapper.ArticleMapper;
import com.example.nz_trip.service.FileService;
import com.example.nz_trip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final String bannerPath = "banner";
    @Autowired
    private ArticleMapper articleMapper;

    @PostMapping("/article")
    public Result addArticle(@RequestParam(required = true)MultipartFile banner,
                             @RequestParam(required = true)String content,
                             @RequestParam(required = true) String title,
                             @RequestParam(required = true)int userId) {
        FileService fileService = new FileService(bannerPath);
        String bannerPath =  fileService.saveImageToFolder(banner);
        if ("".equals(bannerPath)) {
            return Result.failed().message("封面图保存失败");
        }
        Article article = new Article(bannerPath, title, content, userId);
        articleMapper.insert(article);
        return Result.success();
    }
    @GetMapping("/hello")
    public String hello(){
        return "hell2o";
    }
}
