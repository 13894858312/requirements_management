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
     * 查找系统所有项目(limit)
     * @param page 查找的页数
     * @return 系统现有项目信息列表
     */
    List<Project> findAllProjects(int page);

    /**
     * 查找系统所有项目数量
     * @return
     */
     Integer findNumberOfAllProjects();

    /**
     * 根据项目id查找项目信息
     * @param pid 项目id
     * @return 项目信息
     */
     Project findProjectInfoById(int pid);

    /**
     * 根据条件查找项目列表
     *
     * @param publisher   项目发布者Id
     * @param stateInt 项目状态
     * @param field 项目领域
     * @param input 搜索信息
     * @return 符合条件的项目信息列表
     */
    List<Project> findProjectList(String publisher, Integer stateInt, String field, String input);

    /**
     * 根据条件查找项目列表(limit)
     *
     * @param page 查找的页数
     * @param publisher   项目发布者Id
     * @param stateInt 项目状态
     * @param field 项目领域
     * @param input 搜索信息
     * @return 符合条件的项目信息列表
     */
     List<Project> findProjectList(int page, String publisher, Integer stateInt, String field, String input);

    /**
     * 根据用户id查找项目列表
     * @param uid 用户id
     * @return 项目列表
     */
     List<Project> findProjectList(String uid);

    /**
     * 根据用户id查找项目列表(limit)
     * @param page 页数
     * @param uid 用户id
     * @return 项目列表
     */
    List<Project> findProjectList(int page, String uid);

    /**
     * 查找符合条件的项目数量
     * @param publisher 项目发布者Id
     * @param stateInt 项目状态
     * @param field 项目领域
     * @param input 搜索信息
     * @return
     */
    Integer findNumberOfProjectsByCondition(String publisher, Integer stateInt, String field, String input);


    /**
     * 根据用户的项目数量
     * @param publisher 项目发布者Id
     * @return
     */
    Integer findNumberOfProjectsByCondition(String publisher);

    /**
     * 修改项目信息
     * @param project 项目信息
     * @return 修改结果
     */
     String editProject(Project project);

    /**
     * 截止项目征集，更新需求信息，开始需求分析
     * @param uid session中的uid
     * @param pid 项目id
     * @return 操作结果
     */
     String stopCollection(String uid, int pid);

    /**
     * 开始征集
     * @param uid
     * @param pid
     * @param newClosedTime
     * @return
     */
     String startCollection(String uid, int pid, Date newClosedTime);
}
