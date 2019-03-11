package cn.edu.nju.rm.controller.projectPostController;

import cn.edu.nju.rm.model.Project;
import cn.edu.nju.rm.model.Requirement;
import cn.edu.nju.rm.service.project.ProjectService;
import cn.edu.nju.rm.service.requirement.RequirementService;
import cn.edu.nju.rm.util.Constant;
import cn.edu.nju.rm.util.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by wangxue on 2019/1/31.
 * @author wangxue
 */
@Controller
@RequestMapping(value = "/post")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    RequirementService requirementService;

    @RequestMapping(value = "/sendProject", method = RequestMethod.GET)
    public String sendProject(Integer pid, Model model) {
        if(pid!=null){
            //编辑，添加原有项目信息
            model.addAttribute(Constant.PROJECT, projectService.findProjectInfoById(pid));
        }
        return "sendProject";
    }

    //todo 优化加载方式
    @RequestMapping(value = "/projectList", method = RequestMethod.GET)
    public String projectList(Model model) {
        //添加项目列表
        List<Project> projectList = projectService.findAllProjects();
        model.addAttribute(Constant.PROJECT_LIST, projectList);
        model.addAttribute(Constant.HEADER, "项目列表");
        return "projectList";
    }

    //todo 同上
    @RequestMapping(value = "/myProjects", method = RequestMethod.GET)
    public String myProjects(HttpSession session, Model model){
        String uid = session.getAttribute(Constant.SESSION_KEY).toString();
        List<Project> projectList = projectService.findProjectList(uid);
        model.addAttribute(Constant.PROJECT_LIST, projectList);
        model.addAttribute(Constant.HEADER, "我的项目");
        return "projectList";
    }

    //todo 优化数据读取逻辑，添加like和评论
    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public String project(Model model, int pid) {
        //读取项目
        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);
        //读取需求列表
        List<Requirement> requirementList = requirementService.findRequirementsByProject(pid);
        model.addAttribute(Constant.REQUIREMENT_LIST, requirementList);
        //需求数
        model.addAttribute(Constant.NUMBER_OF_REQUIREMENTS, requirementService.checkNumberOfRequirements(pid));
        return "projectPost";
    }

    /**
     * 手动终止征集
     * @param pid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stopCollection", method = RequestMethod.GET)
    public String stopCollection(int pid){
        return projectService.stopCollection(pid);
    }

    /**
     * 创建项目
     * @param session
     * @param name
     * @param language
     * @param field
     * @param closedTime
     * @param description
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public String createProject(HttpSession session, String name, String language,
                                String field, String closedTime, String description){
        String publisher = session.getAttribute(Constant.SESSION_KEY).toString();
        Project project = new Project(publisher, name, language, field,  DateHelper.stringToDate(closedTime), description);
        return projectService.createProject(project);
    }

    /**
     * 编辑项目
     * @param session
     * @param name
     * @param language
     * @param field
     * @param closedTime
     * @param description
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editProject", method = RequestMethod.POST)
    public String editProject(HttpSession session, Integer pid, String name, String language,
                                String field, String closedTime, String description){
        String publisher = session.getAttribute(Constant.SESSION_KEY).toString();
        Project project = new Project(pid, publisher, name, language, field, DateHelper.stringToDate(closedTime), description);
        return projectService.editProject(project);
    }
}
