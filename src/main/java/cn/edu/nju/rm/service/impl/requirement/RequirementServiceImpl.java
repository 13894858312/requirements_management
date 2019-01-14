package cn.edu.nju.rm.service.impl.requirement;

import cn.edu.nju.rm.model.Requirement;
import cn.edu.nju.rm.service.requirement.RequirementService;
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
    /**
     * 志愿者提交项目需求
     *
     * @param requirement 需求信息
     * @return 提交结果
     */
    @Override
    public String sendRequirement(Requirement requirement) {
        return null;
    }

    /**
     * 修改项目需求
     *
     * @param requirement 需求信息
     * @return 修改结果
     */
    @Override
    public String modifyRequirement(Requirement requirement) {
        return null;
    }

    /**
     * 项目发布者添加项目需求
     *
     * @param requirement 需求信息
     * @return 添加结果
     */
    @Override
    public String addRequirement(Requirement requirement) {
        return null;
    }

    /**
     * 根据项目id查找项目需求列表
     *
     * @param pid 项目id
     * @return 项目需求列表
     */
    @Override
    public List<Requirement> findRequirementsByProject(int pid) {
        return null;
    }

    /**
     * 根据需求id查找需求信息
     *
     * @param rid 需求id
     * @return 需求信息
     */
    @Override
    public Requirement findRequirementInfoById(int rid) {
        return null;
    }

    /**
     * 根据项目id查看已收集需求数
     *
     * @param pid 项目id
     * @return 项目已有需求数
     */
    @Override
    public int checkNumberOfComments(int pid) {
        return 0;
    }
}
