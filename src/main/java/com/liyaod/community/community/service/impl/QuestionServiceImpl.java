package com.liyaod.community.community.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyaod.community.community.entity.PaginactionEntity;
import com.liyaod.community.community.entity.QuestionsEntity;
import com.liyaod.community.community.mapper.QuestionMapper;
import com.liyaod.community.community.model.Question;
import com.liyaod.community.community.model.User;
import com.liyaod.community.community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyaod
 * @create 2019-10-14  17:31
 */
@Service
public class QuestionServiceImpl implements QuestionService {

  //  @Autowired
  //  private QuestionMapper questionMapper;

  //  @Autowired
   // private UserMapper userMapper;

    @Override
    public PaginactionEntity<QuestionsEntity> getIndexQusetionList(Integer pageNo, Integer pageSize) {
       /* Integer offset = pageSize*(pageNo - 1);
        List<Question> listQuestion = questionMapper.findAllQuestions(offset,pageSize);
        List<QuestionsEntity> questionsEntityList = new ArrayList<QuestionsEntity>();
        for (Question question : listQuestion) {
            String creater = question.getCreater();
            User user = userMapper.findUserByAccountId(creater);
            QuestionsEntity questionsEntity = new QuestionsEntity();
            BeanUtils.copyProperties(question,questionsEntity);
            questionsEntity.setUser(user);
            questionsEntityList.add(questionsEntity);
        }
        PaginactionEntity<QuestionsEntity> paginactionEntity = new PaginactionEntity<QuestionsEntity>();
        paginactionEntity.setList(questionsEntityList);
        paginactionEntity.setPage(pageNo);
        Integer totalCount = questionMapper.count();
        paginactionEntity.setPaginaction(totalCount,pageNo,pageSize);
        return paginactionEntity;*/
       return null;
    }

    @Override
    public void inserQuestion(Question question) {
        /*questionMapper.inserQuestion(question);*/
    }

    @Override
    public PageInfo<QuestionsEntity> getQusetionList(Integer pageNo, Integer pageSize) {
        // 只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页!!!!
       /* PageHelper.startPage(pageNo, pageSize);
        return PageInfo.of(questionMapper.getQuestionAndUserList());*/
       return null;
    }

    @Override
    public PageInfo<QuestionsEntity> getQuestionAndUserList(Integer pageNo, Integer pageSize) {
        // 只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页!!!!
      /*  PageHelper.startPage(pageNo, pageSize);
        return PageInfo.of(questionMapper.getQuestionAndUserList());*/
      return null;
    }
}
