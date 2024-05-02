package com.example.nz_trip.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nz_trip.entity.Comment;
import com.example.nz_trip.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    @Select("select * from comment where article_id = #{articleId} ORDER BY create_at DESC")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "content",property = "content"),
            @Result(column = "create_at",property = "create_at"),
            @Result(column = "article_id",property = "article_id"),
            @Result(column = "user_id", property = "user", javaType = User.class,
                    one = @One(select = "com.example.nz_trip.mapper.UserMapper.selectById", fetchType = FetchType.LAZY))
    })
    List<Comment> selectCommentByArticleId(Integer articleId);

}
