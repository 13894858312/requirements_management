package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.LikeKey;

public interface LikeMapper {
    int deleteByPrimaryKey(LikeKey key);

    int insert(LikeKey record);

    int insertSelective(LikeKey record);
}