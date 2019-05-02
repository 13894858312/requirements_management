package cn.edu.nju.rm.service.impl.relation;

import cn.edu.nju.rm.dao.RelationMapper;
import cn.edu.nju.rm.model.Relation;
import cn.edu.nju.rm.service.relation.RelationService;
import cn.edu.nju.rm.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by makewei on 2019/3/10.
 */
@Transactional(rollbackFor = Exception.class)
@Service("relationService")
public class RelationServiceImpl implements RelationService{

    @Autowired
    private RelationMapper relationMapper;

    /**
     * 创建关联关系
     *
     * @param relation 关联关系信息
     * @return 创建结果
     */
    @Override
    public String createRelation(Relation relation) {
        return (1 == relationMapper.insertSelective(relation))? Constant.SUCCESS:Constant.FAIL;
    }

    /**
     * 根据项目Id查找该项目所有的关联关系列表
     *
     * @param projectId 项目id
     * @return 关联关系列表
     */
    @Override
    public List<Relation> findRelationList(int projectId) {
        return relationMapper.selectRelationByPid(projectId);
    }

    /**
     * 根据关联id查找该条关联的关联信息
     *
     * @param relationId 关联关系id
     * @return 关联关系信息
     */
    @Override
    public Relation findRelationById(int relationId) {
        return relationMapper.selectByPrimaryKey(relationId);
    }

    /**
     * 根据关联id删除该条关联的关联信息
     *
     * @param relationId 关联关系id
     * @return 删除结果
     */
    @Override
    public String deleteRelationById(int relationId) {
        return (1 == relationMapper.deleteByPrimaryKey(relationId))? Constant.SUCCESS:Constant.FAIL;
    }

    /**
     * 删除关联信息
     *
     * @param relation 关联
     * @return 删除结果
     */
    @Override
    public String deleteRelation(Relation relation) {
        return (1 == relationMapper.delete(relation))? Constant.SUCCESS:Constant.FAIL;
    }
}
