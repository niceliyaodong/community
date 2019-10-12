package com.liyaod.community.community.mapper;

import com.liyaod.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liyaod
 * @create 2019-10-11  16:38
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modifile,creater,tag) values(#{title},#{description},#{gmtCreate},#{gmtModifile},#{creater},#{tag})")
    void inserQuestion(Question question);

}
