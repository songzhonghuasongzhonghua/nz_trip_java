package com.example.nz_trip.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.nz_trip.entity.Article;
import com.example.nz_trip.entity.Comment;
import com.example.nz_trip.entity.User;
import com.example.nz_trip.mapper.ArticleMapper;
import com.example.nz_trip.mapper.CommentMapper;
import com.example.nz_trip.mapper.UserMapper;
import com.example.nz_trip.service.FileService;
import com.example.nz_trip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final String avatarPath = "avatar";
    @Autowired
    UserMapper userMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    private CommentMapper commentMapper;


    @PostMapping("/info")
    public Result updateUser(@RequestParam(required = true)int id,
                             @RequestParam(value = "birthAt",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date birthAt,
                             @RequestParam(required = false) Integer sex,
                             @RequestParam(required = false) String phone,
                             @RequestParam(required = false) MultipartFile avatar) throws Exception {

        User user = userMapper.selectById(id);
        if(user == null){
            return Result.failed().message("用户不存在");
        }
        if(birthAt != null){
            user.setBirthAt(birthAt);
        }
        if(sex != null){
            user.setSex(sex);
        }
        if(phone != null){
            user.setPhone(phone);
        }

        if(avatar != null){
            FileService avatarService = new FileService(avatarPath);
           String filePath =   avatarService.saveImageToFolder(avatar);
           if(filePath != ""){
               user.setAvatar(filePath);
           }
        }
        userMapper.updateById(user);

        return Result.success();
    }



    @GetMapping("/article_list")
    public Result getArticle(@RequestParam(required = true) int page,@RequestParam(required = true) int pageSize){
        QueryWrapper<Article> queryWrapper = new QueryWrapper<Article>();
        Page<Article> pageArticle = new Page<>(page, pageSize);
        Page<Article> articleList = articleMapper.selectPage(pageArticle,queryWrapper);
        HashMap<String,Object> successArticleList = new HashMap<>();
        successArticleList.put("article",articleList);
        return Result.success().data(successArticleList);
    }


    @GetMapping("/article")
    public Result getArticleById(int id){
        Article article = articleMapper.selectById(id);
        if(article == null){
            return Result.failed().message("文章不存在");
        }
        HashMap<String,Object> successArticle = new HashMap<>();
        successArticle.put("article",article);
        return Result.success().data(successArticle);
    }


    @PostMapping("/comment")
    public Result addComment(@RequestBody Comment comment){
        if(comment.getUserId() == 0){
            return Result.failed().message("用户ID不能为空");
        }
        if(comment.getArticleId() == 0){
            return Result.failed().message("文章ID不能为空");
        }
        Date currentDate = new Date();
        comment.setCreateAt(currentDate);
        commentMapper.insert(comment);
        return Result.success();
    }


    @GetMapping("/comment_list")
    public Result getCommentListByArticleId(@RequestParam(required = true) int articleId){
      List<Comment> commentList =  commentMapper.selectCommentByArticleId(articleId);

      if(commentList == null){
          return Result.failed().message("查询文章评论失败");
      }
      HashMap<String,Object> successCommentList = new HashMap<>();
      successCommentList.put("comment",commentList);
      return Result.success().data(successCommentList);
    }
}
