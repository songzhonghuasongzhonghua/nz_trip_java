package com.example.nz_trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.nz_trip.entity.Article;
import com.example.nz_trip.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    @Select("select * from article ORDER BY create_at DESC")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "banner",property = "banner"),
            @Result(column = "title",property = "title"),
            @Result(column = "content",property = "content"),
            @Result(column = "create_at",property = "create_at"),
            @Result(column = "user_id", property = "user", javaType = User.class,
                    one = @One(select = "com.example.nz_trip.mapper.UserMapper.selectById", fetchType = FetchType.LAZY))
    })
    Page<Article> selectPage(Page<Article> page,  @Param("ew") Wrapper<Article> queryWrapper);
}
