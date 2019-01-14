package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Project;
import cn.edu.nju.rm.model.ProjectWithBLOBs;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(ProjectWithBLOBs record);

    int insertSelective(ProjectWithBLOBs record);

    ProjectWithBLOBs selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(ProjectWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProjectWithBLOBs record);

    int updateByPrimaryKey(Project record);
}