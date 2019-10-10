package com.liyaod.community.community.mapper;

import com.liyaod.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modifile) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModifile})")
    void inserUser(User user);


    @Select("select * from user where token = #{token}")
    User findOmeByToken(@Param("token") String token);
}
