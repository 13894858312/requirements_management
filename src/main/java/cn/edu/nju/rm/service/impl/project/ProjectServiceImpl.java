package cn.edu.nju.rm.service.impl.project;

import cn.edu.nju.rm.dao.ProjectMapper;
import cn.edu.nju.rm.model.Project;
import cn.edu.nju.rm.service.project.ProjectService;
import cn.edu.nju.rm.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
@Transactional(rollbackFor = Exception.class)
@Service("projectService")
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectMapper projectMapper;

    /**
     * 新建项目、发布项目帖子
     *
     * @param project 项目信息
     * @return 新建结果
     */
    @Override
    public String createProject(Project project) {
        project.setState(Constant.COLLECTING);
        return (1 == projectMapper.insertSelective(project))? Constant.SUCCESS:Constant.FAIL;

    }

    /**
     * 查找系统所有项目
     *
     * @return 系统现有项目信息列表
     */
    @Override
    public List<Project> findAllProjects() {
        return projectMapper.selectAll();
    }

    /**
     * 根据项目id查找项目信息
     *
     * @param pid 项目id
     * @return 项目信息
     */
    @Override
    public Project findProjectInfoById(int pid) {
        return projectMapper.selectById(pid);
    }

    /**
     * 根据条件查找项目列表
     *
     * @param publisher   项目发布者Id
     * @param state 项目状态
     * @param field 项目领域
     * @param input 搜索信息
     * @return 符合条件的项目信息列表
     */
    @Override
    public List<Project> findProjectList(String publisher, Integer state, String field, String input) {
        return projectMapper.selectByConditionSelective(publisher, state, field, input);
    }

    /**
     * 根据发布者id查找项目列表
     *
     * @param publisher 发布者id
     * @return 项目列表
     */
    @Override
    public List<Project> findProjectList(String publisher) {
        return projectMapper.selectByConditionSelective(publisher, null, null, null);
    }

    /**
     * 修改项目信息
     *
     * @param project 项目信息
     * @return 修改结果
     */
    @Override
    public String editProject(Project project) {
        //检查是否是发布者
        String uid = projectMapper.selectById(project.getPid()).getPublisher();
        if(!uid.equals(project.getPublisher())){
            return Constant.WRONG_USER;
        }
        return (1 == projectMapper.updateByPrimaryKeySelective(project))? Constant.SUCCESS:Constant.FAIL;
    }

    /**
     * 截止项目征集，更新需求信息，开始需求分析
     *
     * @param uid
     * @param pid 项目id
     * @return 操作结果
     */
    @Override
    public String stopCollection(String uid, int pid) {
        Project project = projectMapper.selectById(pid);
        //检查是否是发布者
        if(!uid.equals(project.getPublisher())){
            return Constant.WRONG_USER;
        }
        //修改状态
        project.setState(Constant.END_COLLECT);
        //todo 添加需求分析
        return (1 == projectMapper.updateByPrimaryKeySelective(project))? Constant.SUCCESS:Constant.FAIL;
    }

    /**
     * 开始项目征集，更新需求信息
     * @param uid
     * @param pid
     * @param newClosedTime
     * @return
     */
    @Override
    public String startCollection(String uid, int pid, Date newClosedTime) {
        Project project = projectMapper.selectById(pid);
        //检查是否是发布者
        if(!uid.equals(project.getPublisher())){
            return Constant.WRONG_USER;
        }
        //修改状态和结束时间
        project.setState(Constant.COLLECTING);
        project.setClosedTime(newClosedTime);

        return (1 == projectMapper.updateByPrimaryKeySelective(project))? Constant.SUCCESS:Constant.FAIL;
    }
}
