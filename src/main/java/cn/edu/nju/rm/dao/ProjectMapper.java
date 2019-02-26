package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Project;
import cn.edu.nju.rm.model.ProjectWithBLOBs;

import java.util.List;

public interface ProjectMapper {
    //generator默认方法
    int deleteByPrimaryKey(Integer pid);

    int insert(ProjectWithBLOBs record);

//    int insertSelective(ProjectWithBLOBs record);

    ProjectWithBLOBs selectByPrimaryKey(Integer pid);

//    int updateByPrimaryKeySelective(ProjectWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProjectWithBLOBs record);

    int updateByPrimaryKey(Project record);

//

    /**
     * 根据项目 Id 返回项目信息
     * @param pid 项目id
     * @return 项目信息
     */
    Project selectById(Integer pid);

    /**
     * 修改项目信息
     * @param record 可选项目信息
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(ProjectWithBLOBs record);

    /**
     * 添加项目信息
     * @param record 可选项目信息
     * @return 添加结果
     */
    int insertSelective(ProjectWithBLOBs record);

    /**
     * 返回系统现有全部项目信息
     * @return 项目信息列表
     */
    List<Project> selectAll();

    /**
     * 根据条件查找项目列表
     * @param uid 发布者uid
     * @param state 项目状态
     * @param field 项目领域
     * @param input 搜索信息
     * @return 符合条件的项目信息列表
     */
    List<Project> selectByConditionSelective(int uid, String state, String field, String input);
}