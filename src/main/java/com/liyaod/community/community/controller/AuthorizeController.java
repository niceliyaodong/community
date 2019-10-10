package com.liyaod.community.community.controller;

import com.liyaod.community.community.entity.AccessTokenEntity;
import com.liyaod.community.community.entity.GithubUserEntity;
import com.liyaod.community.community.mapper.UserMapper;
import com.liyaod.community.community.model.User;
import com.liyaod.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author liyaod
 * @create 2019-10-09  13:43
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state, HttpServletResponse response) {
        AccessTokenEntity accessTokenEntity = new AccessTokenEntity();
        accessTokenEntity.setClient_id(clientId);
        accessTokenEntity.setClient_secret(clientSecret);
        accessTokenEntity.setCode(code);
        accessTokenEntity.setRedirect_uri(redirectUri);
        accessTokenEntity.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenEntity);
        GithubUserEntity gethubUser = githubProvider.getUser(accessToken);
        if (gethubUser != null) {
            //说明登录成功，写入cooking，session
            User user = new User();
            user.setAccountId(String.valueOf(gethubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModifile(System.currentTimeMillis());
            user.setName(gethubUser.getName());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            userMapper.inserUser(user);
            Cookie cookie = new Cookie("token",token);
            response.addCookie(cookie);
            //request.getSession().setAttribute("user", gethubUser);
            return "redirect:/";
        } else {
            return "redirect:/";
            //说明登录失败，重新登录
        }
        //System.out.println(user.getId());
        // return "index";
    }
}
