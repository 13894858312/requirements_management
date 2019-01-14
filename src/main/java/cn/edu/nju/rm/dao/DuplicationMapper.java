package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Duplication;

public interface DuplicationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Duplication record);

    int insertSelective(Duplication record);

    Duplication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Duplication record);

    int updateByPrimaryKey(Duplication record);
}