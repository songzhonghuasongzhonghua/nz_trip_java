package com.example.nz_trip.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Comment {
    private int id;
    private String content;
    private int userId;
    private int articleId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", createAt=" + createAt +
                ", user=" + user +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @TableField(exist = false)
    private User user;

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

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
    public void setArticle_id(int articleId) {
        this.articleId = articleId;
    }

    public ZonedDateTime getCreateAt() {
        ZoneId newZealandZone = ZoneId.of("Pacific/Auckland");
        ZonedDateTime newZealandTime = new Date(this.createAt.getTime()).toInstant().atZone(newZealandZone);
        return newZealandTime;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    public void setCreate_at(Date createAt) {
        this.createAt = createAt;
    }

    public Comment(){}

    public Comment(String content,int userId,int articleId){
        this.content = content;
        this.userId = userId;
        this.articleId = articleId;
        this.createAt = new Date();
    }
}
