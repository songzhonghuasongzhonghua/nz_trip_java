package com.example.nz_trip.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nz_trip.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper  extends BaseMapper<User> {

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

}
