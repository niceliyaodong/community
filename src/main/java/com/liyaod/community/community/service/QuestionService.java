package com.liyaod.community.community.service;

import com.github.pagehelper.PageInfo;
import com.liyaod.community.community.entity.PaginactionEntity;
import com.liyaod.community.community.entity.QuestionsEntity;
import com.liyaod.community.community.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyaod
 * @create 2019-10-14  17:30
 */
public interface QuestionService {

    PaginactionEntity<QuestionsEntity> getIndexQusetionList(Integer pageNo, Integer pageSize);

    void inserQuestion(Question question);

    PageInfo<QuestionsEntity> getQusetionList(Integer pageNo, Integer pageSize);

    PageInfo<QuestionsEntity> getQuestionAndUserList(Integer pageNo, Integer pageSize);
}
