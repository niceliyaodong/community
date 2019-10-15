package com.liyaod.community.community.entity;

import com.liyaod.community.community.model.User;
import lombok.Data;

/**
 * @author liyaod
 * 问题实体类
 * @create 2019-10-14  17:14
 */
@Data
public class QuestionsEntity {
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
    private User user;

}
