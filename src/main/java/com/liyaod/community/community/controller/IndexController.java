package com.liyaod.community.community.controller;

import com.liyaod.community.community.entity.QuestionsEntity;
import com.liyaod.community.community.mapper.UserMapper;
import com.liyaod.community.community.model.User;
import com.liyaod.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import java.util.List;

/**
 * @author liyaod
 * @create 2019-10-08  17:00
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findOmeByToken(token);
                    if(user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }
        return "index";//自动去找模板
    }

    /**
     * 获取首页问题列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getIndexQusetionList")
    public List<QuestionsEntity> getIndexQusetionList(){
        List<QuestionsEntity> indexQusetionList = questionService.getIndexQusetionList();
        return indexQusetionList;
    }
}
