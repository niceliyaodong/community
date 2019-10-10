package com.liyaod.community.community.mapper;

import com.liyaod.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into user (account_id,name,token,gmt_creat,gmt_modifile) values (#{accountId},#{name},#{token},#{gmtCreat},#{gmtModifile})")
    void inserUser(User user);
}
