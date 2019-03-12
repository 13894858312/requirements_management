package cn.edu.nju.rm.controller.projectPostController;

import cn.edu.nju.rm.model.Project;
import cn.edu.nju.rm.service.project.ProjectService;
import cn.edu.nju.rm.util.Constant;
import cn.edu.nju.rm.util.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by wangxue on 2019/1/31.
 * @author wangxue
 */
@Controller
@RequestMapping(value = "/post")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/sendProject", method = RequestMethod.GET)
    public String sendProject(Integer pid, Model model) {
        if(pid!=null){
            //编辑，添加原有项目信息
            model.addAttribute(Constant.PROJECT, projectService.findProjectInfoById(pid));
        }
        return "sendProject";
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
