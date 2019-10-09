package com.liyaod.community.community.controller;

import com.liyaod.community.community.entity.AccessTokenEntity;
import com.liyaod.community.community.entity.GithubUserEntity;
import com.liyaod.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {
        AccessTokenEntity accessTokenEntity = new AccessTokenEntity();
        accessTokenEntity.setClient_id(clientId);
        accessTokenEntity.setClient_secret(clientSecret);
        accessTokenEntity.setCode(code);
        accessTokenEntity.setRedirect_uri(redirectUri);
        accessTokenEntity.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenEntity);
        GithubUserEntity user = githubProvider.getUser(accessToken);
        System.out.println(user.getId());
        return "index";
    }
}
