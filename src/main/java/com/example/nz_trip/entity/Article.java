package com.example.nz_trip.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Article {
    private int id;
    private String title;
    private String content;
    private int userId;
    private String banner;

    @TableField(exist = false)
    private User user;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", banner='" + banner + '\'' +
                ", user=" + user +
                ", createAt=" + createAt +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    public void setCreate_at(Date createAt) {
        this.createAt = createAt;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setUser_id(int userId) {
        this.userId = userId;
    }



    public Article(){}

    public Article(String banner,String title,String content,int userId){
        this.banner=banner;
        this.title=title;
        this.content=content;
        this.userId=userId;
        this.createAt=new Date();
    }
}
