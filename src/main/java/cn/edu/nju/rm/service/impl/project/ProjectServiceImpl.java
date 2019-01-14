package cn.edu.nju.rm.service.impl.project;

import cn.edu.nju.rm.model.Project;
import cn.edu.nju.rm.service.project.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
@Transactional(rollbackFor = Exception.class)
@Service("projectService")
public class ProjectServiceImpl implements ProjectService{
    /**
     * 新建项目、发布项目帖子
     *
     * @param project 项目信息
     * @return 新建结果
     */
    @Override
    public String createProject(Project project) {
        return null;
    }

    /**
     * 查找系统所有项目
     *
     * @return 系统现有项目信息列表
     */
    @Override
    public List<Project> findAllProjects() {
        return null;
    }

    /**
     * 根据项目id查找项目信息
     *
     * @param pid 项目id
     * @return 项目信息
     */
    @Override
    public Project findProjectInfoById(int pid) {
        return null;
    }

    /**
     * 根据条件查找项目列表
     *
     * @param uid   项目发布者Id
     * @param state 项目状态
     * @param field 项目领域
     * @param input 搜索信息
     * @return 符合条件的项目信息列表
     */
    @Override
    public List<Project> findProjectList(String uid, String state, String field, String input) {
        return null;
    }

    /**
     * 根据用户id查找项目列表
     *
     * @param uid 用户id
     * @return 项目列表
     */
    @Override
    public List<Project> findProjectList(String uid) {
        return null;
    }

    /**
     * 修改项目信息
     *
     * @param project 项目信息
     * @return 修改结果
     */
    @Override
    public String modifyProjectInfo(Project project) {
        return null;
    }

    /**
     * 截止项目征集，更新需求信息，开始需求分析
     *
     * @param pid 项目id
     * @return 操作结果
     */
    @Override
    public String stopCollection(int pid) {
        return null;
    }

    /**
     * 开始项目征集，更新需求信息
     *
     * @param pid 项目id
     * @return 操作结果
     */
    @Override
    public String startCollection(int pid) {
        return null;
    }
}
