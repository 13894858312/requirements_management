package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Conflict;

public interface ConflictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Conflict record);

    int insertSelective(Conflict record);

    Conflict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Conflict record);

    int updateByPrimaryKey(Conflict record);
}