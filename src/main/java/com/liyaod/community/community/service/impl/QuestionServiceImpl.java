package com.liyaod.community.community.service.impl;

import com.liyaod.community.community.entity.QuestionsEntity;
import com.liyaod.community.community.mapper.QuestionMapper;
import com.liyaod.community.community.mapper.UserMapper;
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

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<QuestionsEntity> getIndexQusetionList(int pageNo,int pageSize) {
        List<Question> listQuestion = questionMapper.findAllQuestions();
        List<QuestionsEntity> questionsEntityList = new ArrayList<QuestionsEntity>();
        for (Question question : listQuestion) {
            String creater = question.getCreater();
            User user = userMapper.findUserByAccountId(creater);
            QuestionsEntity questionsEntity = new QuestionsEntity();
            BeanUtils.copyProperties(question,questionsEntity);
            questionsEntity.setUser(user);
            questionsEntityList.add(questionsEntity);
        }
        return questionsEntityList;
    }

    @Override
    public void inserQuestion(Question question) {
        questionMapper.inserQuestion(question);
    }
}
