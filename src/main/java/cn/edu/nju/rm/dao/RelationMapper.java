package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Relation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationMapper {

    /**
     * 根据关联id删除该条关联的关联信息
     * @param id 关联关系id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 删除某条关联信息
     * @param relation 关联
     * @return 删除结果
     */
    int delete(Relation relation);

    /**
     * 删除某类别某产物的所有关联信息
     * @param type 类别
     * @param id id
     * @return 删除结果
     */
    int deleteAllRelations(@Param("type") Integer type, @Param("id") Integer id);


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

    /**
     * 根据pid查找特定种类产物之间的关联列表（不计数据库中的前后顺序）
     * @param pid 项目id
     * @param aType 第一种产物类型
     * @param aid 第一种产物id
     * @param bType 第二种产物类型
     * @return 关联关系列表
     */
    List<Relation> selectRelationByPidWithType(@Param("pid")Integer pid, @Param("atype") Integer aType, @Param("aid")Integer aid, @Param("btype") Integer bType);

    int updateByPrimaryKeySelective(Relation record);

    int updateByPrimaryKey(Relation record);
}