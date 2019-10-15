package com.liyaod.community.community.mapper;

import com.liyaod.community.community.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modifile,avatar_url) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModifile},#{avatarUrl})")
    void inserUser(User user);


    @Select("select * from user where token = #{token}")
    User findOmeByToken(@Param("token") String token);

    @Select("select * from user where account_id = #{accountId}")
    User findUserByAccountId(@Param("accountId") String accountId);

    /**
     * 更新用户信息
     * @param user
     */
    @Update("update user set name=#{name},token=#{token},gmt_modifile=#{gmtModifile},dio=#{dio},avatar_url=#{avatarUrl} where account_id=#{accountId}")
    void updateUser(User user);
}
