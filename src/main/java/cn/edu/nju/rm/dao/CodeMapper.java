package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Code;

import java.util.List;

public interface CodeMapper {
    //test
    int deleteByPrimaryKey(Integer id);

    int insert(Code record);

    /**
     * 添加项目代码
     * @param record 可选代码信息
     * @return 添加结果
     */
    int insertSelective(Code record);

    /**
     * 根据项目Id查找提交的代码列表
     * @param projectId 项目id
     * @return 代码列表
     */
    List<Code> selectAllCode(Integer projectId);

    /**
     * 根据代码Id查找代码结构信息
     * @param id 项目代码id
     * @return 项目代码信息
     */
    Code selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Code record);

    int updateByPrimaryKeyWithBLOBs(Code record);

    int updateByPrimaryKey(Code record);
}