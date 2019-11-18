package com.liyaod.community.community.mapper;

import com.github.pagehelper.PageInfo;
import com.liyaod.community.community.entity.QuestionsEntity;
import com.liyaod.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liyaod
 * @create 2019-10-11  16:38
 */
//@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modifile,creater,tag) values(#{title},#{description},#{gmtCreate},#{gmtModifile},#{creater},#{tag})")
    void inserQuestion(Question question);

    /*@Select("select * from question limit #{offset},#{pageSize}")
    List<Question> findAllQuestions(@Param("offSet") Integer offSet, @Param("pageSize")Integer pageSize);*/

    @Select("select * from question limit #{offset},#{pageSize}")
    List<Question> findAllQuestions(@Param(value = "offset") Integer offset,@Param(value = "pageSize")Integer pageSize);

    @Select("select count(id) from question")
    Integer count();

    @Select("select * from question")
    List<Question> findAllQuestionList();

    @Select("SELECT * FROM question")
    List<QuestionsEntity> getQuestionAndUserList();
}
