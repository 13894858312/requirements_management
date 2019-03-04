package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Project;

import java.util.List;

public interface ProjectMapper {
    //generator默认方法
    int deleteByPrimaryKey(Integer pid);

    int insert(Project record);

//    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer pid);

//    int updateByPrimaryKeySelective(Project record);

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
    int updateByPrimaryKeySelective(Project record);

    /**
     * 添加项目信息
     * @param record 可选项目信息
     * @return 添加结果
     */
    int insertSelective(Project record);

    /**
     * 返回系统现有全部项目信息
     * @return 项目信息列表
     */
    List<Project> selectAll();

    /**
     * 根据条件查找项目列表
     * @param publisher 发布者uid
     * @param state 项目状态
     * @param field 项目领域
     * @param input 搜索信息
     * @return 符合条件的项目信息列表
     */
    List<Project> selectByConditionSelective(String publisher, String state, String field, String input);
}