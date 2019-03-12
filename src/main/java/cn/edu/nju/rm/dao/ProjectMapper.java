package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {
    //generator默认方法
    int deleteByPrimaryKey(Integer pid);

    int insert(Project record);

    Project selectByPrimaryKey(Integer pid);

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
     * 返回系统现有全部项目信息（limit)
     * @param offset 从第几个开始选择
     * @param number 选几个
     * @return 项目信息列表
     */
    List<Project> selectAllWithLimit(@Param("offset") Integer offset, @Param("number") Integer number);

    /**
     * 返回系统现有全部项目信息
     * @return 项目信息列表
     */
    List<Project> selectAll();

    /**
     * 返回系统现有全部项目数量
     * @return
     */
    Integer selectCountAll();

    /**
     * 根据条件查找项目列表（limit）
     *
     * @param offset 从第几个开始选择
     * @param number 选几个
     * @param publisher 发布者uid
     * @param state 项目状态
     * @param field 项目领域
     * @param input 搜索信息
     * @return 符合条件的项目信息列表
     */
    List<Project> selectByConditionSelectiveWithLimit(@Param("offset") Integer offset, @Param("number") Integer number, @Param("publisher") String publisher, @Param("state") Integer state, @Param("field") String field, @Param("input") String input);

    /**
     * 根据条件查找项目列表
     *
     * @param publisher 发布者uid
     * @param state 项目状态
     * @param field 项目领域
     * @param input 搜索信息
     * @return 符合条件的项目信息列表
     */
    List<Project> selectByConditionSelective(@Param("publisher") String publisher, @Param("state") Integer state, @Param("field") String field, @Param("input") String input);

    /**
     * 根据条件查找项目列表结果数量
     * @param publisher 发布者uid
     * @param state 项目状态
     * @param field 项目领域
     * @param input 搜索信息
     * @return 符合条件的项目信息列表
     */
    Integer selectCountByConditionSelective(@Param("publisher") String publisher, @Param("state") Integer state, @Param("field") String field, @Param("input") String input);

    /**
     * 检查到达截止日期的项目并更新项目状态
     * @return
     */
    Integer endExpiredCollection();

}