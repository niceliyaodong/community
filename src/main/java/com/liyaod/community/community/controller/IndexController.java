package com.liyaod.community.community.controller;

import com.github.pagehelper.PageInfo;
import com.liyaod.community.community.entity.PaginactionEntity;
import com.liyaod.community.community.entity.QuestionsEntity;
import com.liyaod.community.community.mapper.UserMapper;
import com.liyaod.community.community.model.User;
import com.liyaod.community.community.service.QuestionService;
import com.liyaod.community.community.service.UserService;
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
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userService.findOmeByToken(token);
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
    public PageInfo<QuestionsEntity> getIndexQusetionList(@RequestParam(value="pageNo",defaultValue="1")Integer pageNo, @RequestParam(value="pageSize",defaultValue="10")Integer pageSize){
        PageInfo<QuestionsEntity> indexQusetionList = questionService.getIndexQusetionList(pageNo,pageSize);
        return indexQusetionList;
    }
}
