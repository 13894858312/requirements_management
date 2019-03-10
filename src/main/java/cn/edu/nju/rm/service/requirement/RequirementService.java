package cn.edu.nju.rm.service.requirement;

import cn.edu.nju.rm.model.Requirement;

import java.util.List;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
public interface RequirementService {
    /**
     * 志愿者提交项目需求
     * @param requirement 需求信息
     * @return 提交结果
     */
    String sendRequirement(Requirement requirement);

    /**
     * 修改项目需求
     * @param requirement 需求信息
     * @return 修改结果
     */
    String modifyRequirement(Requirement requirement);

    /**
     * 项目发布者添加项目需求
     * @param requirement 需求信息
     * @return 添加结果
     */
    String addRequirement(Requirement requirement);

    /**
     * 根据项目id查找项目需求列表
     * @param pid 项目id
     * @return 项目需求列表
     */
    List<Requirement> findRequirementsByProject(int pid);

    /**
     * 根据需求id查找需求信息
     * @param rid 需求id
     * @return 需求信息
     */
    Requirement findRequirementInfoById(int rid);

    /**
     * 根据项目id查看已收集需求数
     * @param pid 项目id
     * @return 项目已有需求数
     */
    long checkNumberOfRequirements( int pid);

    /**
     * 处理项目需求并标记已处理，用于项目征集结束时
     * @param pid
     * @return
     */
    int handleRequirement(int pid);
}
