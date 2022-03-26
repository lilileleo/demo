package com.example.demo.mapper;

import com.example.demo.entity.Student;
import com.example.demo.entity.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MainMapper {
    @Select("select * from users where name = #{name}")
    UserData findUserById(String name);
}
