package com.liyaod.community.community.controller;

import com.liyaod.community.community.entity.AccessTokenEntity;
import com.liyaod.community.community.entity.GithubUserEntity;
import com.liyaod.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liyaod
 * @create 2019-10-09  13:43
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {
        AccessTokenEntity accessTokenEntity = new AccessTokenEntity();
        accessTokenEntity.setClient_id("25937c33817d0cbfe4ef");
        accessTokenEntity.setClient_secret("73e40515a345fc6e0c5fdad4816a5bf88ea82d3a");
        accessTokenEntity.setCode(code);
        accessTokenEntity.setRedirect_uri("http://localhost:8889/callback");
        accessTokenEntity.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenEntity);
        GithubUserEntity user = githubProvider.getUser(accessToken);
        System.out.println(user.getId());
        return "index";
    }
}
