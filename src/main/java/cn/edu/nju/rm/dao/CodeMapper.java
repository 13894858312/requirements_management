package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Code;

public interface CodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Code record);

    int insertSelective(Code record);

    Code selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Code record);

    int updateByPrimaryKeyWithBLOBs(Code record);

    int updateByPrimaryKey(Code record);
}