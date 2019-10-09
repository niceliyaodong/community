package com.liyaod.community.community.provider;

import com.alibaba.fastjson.JSON;
import com.liyaod.community.community.entity.AccessTokenEntity;
import com.liyaod.community.community.entity.GithubUserEntity;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author liyaod
 * @create 2019-10-09  13:54
 * github第三方登录认证
 */
@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenEntity accessTokenEntity) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        String url = "https://github.com/login/oauth/access_token";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenEntity));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从accessToken中获取user对象。
     *
     * @param accessToken
     * @return
     */
    public GithubUserEntity getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?"+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUserEntity githubUserEntity = JSON.parseObject(string, GithubUserEntity.class);//string 转换为类对象
            return githubUserEntity;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
