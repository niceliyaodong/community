package com.liyaod.community.community.entity;

import lombok.Data;

import java.util.List;

/**
 * @author liyaod
 * @create 2019-10-16  10:30
 */
@Data
public class PaginactionEntity<T> {
    private List<T> list;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages;

    public void setPaginaction(Integer totalCount, Integer pageNo, Integer pageSize) {
        Integer totalPage = 0;
        if (totalCount/pageSize == 0){
            totalPage = totalCount/pageSize;
        }else {
            totalPage=totalCount/pageSize+1;
        }
    }
}
