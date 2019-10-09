package com.liyaod.community.community.entity;

/**
 * @author liyaod
 * @create 2019-10-09  15:04
 */
public class GithubUserEntity {
    private Long id;
    private String name;
    private String dio;//描述

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDio() {
        return dio;
    }

    public void setDio(String dio) {
        this.dio = dio;
    }
}
