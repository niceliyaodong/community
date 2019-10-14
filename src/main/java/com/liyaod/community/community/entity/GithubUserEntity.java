package com.liyaod.community.community.entity;

import lombok.Data;

/**
 * @author liyaod
 * @create 2019-10-09  15:04
 */
@Data
public class GithubUserEntity {
    private Long id;
    private String name;
    private String dio;//描述
    private String avatarUrl;//github头像地址
}
