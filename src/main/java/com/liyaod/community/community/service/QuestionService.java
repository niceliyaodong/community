package com.liyaod.community.community.service;

import com.liyaod.community.community.entity.QuestionsEntity;
import com.liyaod.community.community.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyaod
 * @create 2019-10-14  17:30
 */
public interface QuestionService {

    List<QuestionsEntity> getIndexQusetionList(int pageNo,int pageSize);

    void inserQuestion(Question question);
}
