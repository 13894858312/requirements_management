package cn.edu.nju.rm.service.impl.requirement;

import cn.edu.nju.rm.dao.RequirementMapper;
import cn.edu.nju.rm.model.Requirement;
import cn.edu.nju.rm.service.requirement.RequirementService;
import cn.edu.nju.rm.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
@Transactional(rollbackFor = Exception.class)
@Service("requirementService")
public class RequirementServiceImpl implements RequirementService{

    @Autowired
    private RequirementMapper requirementMapper;

    /**
     * 志愿者提交项目需求
     *
     * @param requirement 需求信息
     * @return 提交结果
     */
    @Override
    public String sendRequirement(Requirement requirement) {
        return (1 == requirementMapper.insertSelective(requirement))? Constant.SUCCESS:Constant.FAIL;
    }

    /**
     * 修改项目需求
     *
     * @param requirement 需求信息
     * @return 修改结果
     */
    @Override
    public String modifyRequirement(Requirement requirement) {
        //检查是否是发布者
        String uid = requirementMapper.selectById(requirement.getRid()).getUid();
        if(!uid.equals(requirement.getUid())){
            return Constant.WRONG_USER;
        }
        return (1 == requirementMapper.updateByPrimaryKeySelective(requirement))? Constant.SUCCESS:Constant.FAIL;
    }

    /**
     * 项目发布者添加项目需求
     *
     * @param requirement 需求信息
     * @return 添加结果
     */
    @Override
    public String addRequirement(Requirement requirement) {
        return (1 == requirementMapper.insertSelective(requirement))? Constant.SUCCESS:Constant.FAIL;
    }

    /**
     * 根据项目id查找项目需求列表
     *
     * @param pid 项目id
     * @return 项目需求列表
     */
    @Override
    public List<Requirement> findRequirementsByProject(int pid) {
        return requirementMapper.selectAll(pid);
    }

    /**
     * 根据项目id查找项目已选需求列表
     *
     * @param pid 项目id
     * @return 项目需求列表
     */
    @Override
    public List<Requirement> findSelectedRequirementsByProject(int pid) {
        return requirementMapper.selectAllSelected(pid);
    }

    /**
     * 根据项目id查找项目需求列表(limit)
     *
     * @param page 查找的页数
     * @param pid 项目id
     * @return 项目需求列表
     */
    @Override
    public List<Requirement> findRequirementsByProject(int page, int pid) {
        int number = Constant.PROJECT_NUMBER_IN_A_PAGE;
        int offset = (page - 1 ) * number;
        return requirementMapper.selectAllWithLimit(offset, number, pid);
    }

    /**
     * 根据需求id查找需求信息
     *
     * @param rid 需求id
     * @return 需求信息
     */
    @Override
    public Requirement findRequirementInfoById(int rid) {
        return requirementMapper.selectById(rid);
    }

    @Override
    public List<Requirement> findRequirementsByType(int pid, String type) { return requirementMapper.selectAllByType(pid,type); }

    @Override
    public List<Requirement> findResultByType(int pid, String type) {
        return requirementMapper.selectedResultByType(pid,type);
    }

    /**
     * 根据项目id查看已收集需求数
     *
     * @param pid 项目id
     * @return 项目已有需求数
     */
    @Override
    public Integer checkNumberOfRequirements(int pid) {
        return requirementMapper.checkNumber(pid);
    }

    /**
     * 处理项目需求并标记已处理，用于项目征集结束时
     * todo
     * @param pid
     * @return
     */
    @Override
    public Integer handleRequirement(int pid) {
        return 0;
    }

}
