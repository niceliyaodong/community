package com.liyaod.community.community.mapper;

/**
 * @author liyaod
 * @create 2019-11-17  12:22
 */
public interface BaseMapper<T> {

    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
