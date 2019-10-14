package com.liyaod.community.community.controller;

import com.liyaod.community.community.mapper.QuestionMapper;
import com.liyaod.community.community.mapper.UserMapper;
import com.liyaod.community.community.model.Question;
import com.liyaod.community.community.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liyaod
 * @create 2019-10-11  15:25
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String getPublish() {
        return "publish";
    }

    /**
     * 发布问题
     *
     * @return
     */
    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "tag", required = false) String tag,
            HttpServletRequest request,
            Model model) {
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        User user = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.findOmeByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        System.out.println(user);
        if (user == null) {
            model.addAttribute("error", "用户为登录，请登录");
            //返回当前页面
            return "publish";
        }
        question.setCreater(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModifile(question.getGmtCreate());
        questionMapper.inserQuestion(question);
        return "redirect:/";
    }
}
