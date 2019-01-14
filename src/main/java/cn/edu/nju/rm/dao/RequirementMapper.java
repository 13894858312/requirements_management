package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Requirement;
import cn.edu.nju.rm.model.RequirementWithBLOBs;

public interface RequirementMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(RequirementWithBLOBs record);

    int insertSelective(RequirementWithBLOBs record);

    RequirementWithBLOBs selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(RequirementWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RequirementWithBLOBs record);

    int updateByPrimaryKey(Requirement record);
}