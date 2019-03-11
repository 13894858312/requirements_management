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
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/searchProject", method = RequestMethod.GET)
    public String searchProject(){
        return "searchProject";
    }

    @RequestMapping(value = "/sendProject", method = RequestMethod.GET)
    public String sendProject(Integer pid, Model model) {
        if(pid!=null){
            //编辑，添加原有项目信息
            model.addAttribute(Constant.PROJECT, projectService.findProjectInfoById(pid));
        }
        return "sendProject";
    }

    @RequestMapping(value = "/projectList", method = RequestMethod.GET)
    public String projectList(Model model, Integer page) {
        //添加项目列表
        List<Project> projectList = projectService.findAllProjectsWithLimit(page);
        model.addAttribute(Constant.PROJECT_LIST, projectList);
        //添加页数
        long count = projectService.findNumberOfAllProjects();
        int pageNumber = (int) Math.ceil(count*1.0/ Constant.PROJECT_NUMBER_IN_A_PAGE);
        model.addAttribute(Constant.PAGE_NUMBER, pageNumber);
        //当前页面
        model.addAttribute(Constant.CURRENT_PAGE, page);

        model.addAttribute(Constant.HEADER, "项目列表");
        return "projectList";
    }

    @RequestMapping(value = "/myProjects", method = RequestMethod.GET)
    public String myProjects(HttpSession session, Integer page, Model model){
        String uid = session.getAttribute(Constant.SESSION_KEY).toString();
        List<Project> projectList = projectService.findProjectList(page, uid);
        model.addAttribute(Constant.PROJECT_LIST, projectList);

        long count = projectService.findNumberOfProjectsByCondition(uid);
        int pageNumber = (int) Math.ceil(count*1.0/ Constant.PROJECT_NUMBER_IN_A_PAGE);
        model.addAttribute(Constant.PAGE_NUMBER, pageNumber);
        model.addAttribute(Constant.CURRENT_PAGE, page);

        model.addAttribute(Constant.HEADER, "我的项目");
        return "projectList";
    }

    /**
     * 查找项目列表
     * @param publisher
     * @param state
     * @param field
     * @param input
     * @return
     */
    @RequestMapping(value = "/searchResult", method = RequestMethod.GET)
    public ModelAndView searchResult(Integer page, String publisher, String state, String field, String input){
        ModelAndView modelAndView = new ModelAndView();
        List<Project> projectList = projectService.findProjectList(page, publisher, state, field, input);
        modelAndView.addObject(Constant.PROJECT_LIST, projectList);

        long count = projectService.findNumberOfProjectsByCondition(publisher, state, field, input);
        int pageNumber = (int) Math.ceil(count*1.0/ Constant.PROJECT_NUMBER_IN_A_PAGE);
        modelAndView.addObject(Constant.PAGE_NUMBER, pageNumber);
        modelAndView.addObject(Constant.CURRENT_PAGE, page);

        modelAndView.addObject(Constant.HEADER, "搜索结果");
        //记录搜索内容
        String condition = getCondition(publisher, state, field, input);
        modelAndView.addObject(Constant.CONDITION, condition);

        modelAndView.setViewName("projectList");
        return modelAndView;
    }

    //todo 添加like和评论 & 分页
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
     * @param session
     * @param pid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stopCollection", method = RequestMethod.GET)
    public String stopCollection(HttpSession session, int pid){
        String uid = session.getAttribute(Constant.SESSION_KEY).toString();
        return projectService.stopCollection(uid, pid);
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

    /**
     * 获取condition字符串
     * @param publisher
     * @param state
     * @param field
     * @param input
     * @return
     */
    private String getCondition(String publisher, String state, String field, String input){
        String condition = "";
        if(publisher != null && publisher.length() != 0){
            condition = condition + "&publisher=" + publisher;
        }
        condition = condition + "&state=" + state;
        if(field != null && field.length() != 0){
            condition = condition + "&field=" + field;
        }
        if(input != null && input.length() != 0){
            condition = condition + "&input=" + input;
        }
        return condition;
    }
}
