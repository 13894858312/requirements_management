package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Uml;
import cn.edu.nju.rm.model.UmlWithBLOBs;

public interface UmlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UmlWithBLOBs record);

    int insertSelective(UmlWithBLOBs record);

    UmlWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UmlWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UmlWithBLOBs record);

    int updateByPrimaryKey(Uml record);
}