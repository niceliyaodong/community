package com.liyaod.community.community.model;

import lombok.Data;

/**
 * @author liyaod
 * @create 2019-10-11  16:38
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private long gmtCreate;
    private long gmtModifile;
    private String creater;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
}
