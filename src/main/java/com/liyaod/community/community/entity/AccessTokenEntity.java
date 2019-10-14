package com.liyaod.community.community.entity;

import lombok.Data;

/**
 * @author liyaod
 * @create 2019-10-09  13:57
 */
@Data
public class AccessTokenEntity {

    private String client_id;

    private String client_secret;

    private String code;

    private String redirect_uri;

    private String state;

}
