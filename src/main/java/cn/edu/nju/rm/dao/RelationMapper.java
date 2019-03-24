package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Relation;

import java.util.List;

public interface RelationMapper {

    /**
     * 根据关联id删除该条关联的关联信息
     * @param id 关联关系id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Integer id);

    int insert(Relation record);

    /**
     * 创建关联关系
     * @param record 关联关系信息
     * @return 创建结果
     */
    int insertSelective(Relation record);

    /**
     * 根据关联id查找该条关联的关联信息
     * @param id 关联关系id
     * @return 关联关系信息
     */
    Relation selectByPrimaryKey(Integer id);

    /**
     * 根据项目Id查找该项目所有的关联关系列表
     * @param pid 项目id
     * @return 关联关系列表
     */
    List<Relation> selectRelationByPid(Integer pid);

    int updateByPrimaryKeySelective(Relation record);

    int updateByPrimaryKey(Relation record);
}