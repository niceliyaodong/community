package com.liyaod.community.community.entity;

public class UserEntity {
    private Integer id;

    private String accountId;

    private String name;

    private String token;

    private String gmtCreate;

    private String gmtModifile;

    private String dio;

    private String avatarUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate == null ? null : gmtCreate.trim();
    }

    public String getGmtModifile() {
        return gmtModifile;
    }

    public void setGmtModifile(String gmtModifile) {
        this.gmtModifile = gmtModifile == null ? null : gmtModifile.trim();
    }

    public String getDio() {
        return dio;
    }

    public void setDio(String dio) {
        this.dio = dio == null ? null : dio.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }
}