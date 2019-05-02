package cn.edu.nju.rm.service.relation;

import cn.edu.nju.rm.model.Relation;

import java.util.List;

/**
 * Created by makewei on 2019/3/10.
 */
public interface RelationService {

    /**
     * 创建关联关系
     * @param relation 关联关系信息
     * @return 创建结果
     */
    String createRelation(Relation relation);

    /**
     * 根据项目Id查找该项目所有的关联关系列表
     * @param projectId 项目id
     * @return 关联关系列表
     */
    List<Relation> findRelationList(int projectId);


    /**
     * 根据关联id查找该条关联的关联信息
     * @param relationId 关联关系id
     * @return 关联关系信息
     */
    Relation findRelationById(int relationId);

    /**
     * 根据关联id删除该条关联的关联信息
     * @param relationId 关联关系id
     * @return 删除结果
     */
    String deleteRelationById(int relationId);

    /**
     * 删除关联信息
     * @param relation 关联
     * @return 删除结果
     */
    String deleteRelation(Relation relation);

}
