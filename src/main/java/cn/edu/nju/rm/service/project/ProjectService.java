package cn.edu.nju.rm.service.project;

import cn.edu.nju.rm.model.Project;

import java.util.Date;
import java.util.List;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
public interface ProjectService {
    /**
     * 新建项目、发布项目帖子
     * @param project 项目信息
     * @return 新建结果
     */
    String createProject(Project project);

    /**
     * 查找系统所有项目
     * @return 系统现有项目信息列表
     */
     List<Project> findAllProjects();

    /**
     * 根据项目id查找项目信息
     * @param pid 项目id
     * @return 项目信息
     */
     Project findProjectInfoById(int pid);

    /**
     * 根据条件查找项目列表
     * @param publisher 项目发布者Id
     * @param state 项目状态
     * @param field 项目领域
     * @param input 搜索信息
     * @return 符合条件的项目信息列表
     */
     List<Project> findProjectList(String publisher, Integer state, String field, String input);

    /**
     * 根据用户id查找项目列表
     * @param uid 用户id
     * @return 项目列表
     */
     List<Project> findProjectList(String uid);

    /**
     * 修改项目信息
     * @param project 项目信息
     * @return 修改结果
     */
     String editProject(Project project);

    /**
     * 截止项目征集，更新需求信息，开始需求分析
     * @param pid 项目id
     * @return 操作结果
     */
     String stopCollection(int pid);

    /**
     * 开始项目征集，更新需求信息
     * @param pid 项目id
     * @return 操作结果
     */
     String startCollection(int pid, Date newClosedTime);
}
