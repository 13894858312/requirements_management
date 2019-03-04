package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Uml;

public interface UmlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Uml record);

    int insertSelective(Uml record);

    Uml selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Uml record);

    int updateByPrimaryKey(Uml record);
}