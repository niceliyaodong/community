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
    public List<QuestionsEntity> getIndexQusetionList() {
        List<Question> listQuestion = questionMapper.findAllQuestions();
        for (Question question : listQuestion) {
            Integer creater = question.getCreater();
            User user = userMapper.findUserById(creater);
            BeanUtils.copyProperties();
        }
        return null;
    }
}
