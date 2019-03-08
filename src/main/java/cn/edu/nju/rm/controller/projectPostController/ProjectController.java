package cn.edu.nju.rm.controller.projectPostController;

import cn.edu.nju.rm.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String sendProject(Model model, String dataCenter) {
        return "sendProject";
    }
    @RequestMapping(value = "/projectList", method = RequestMethod.GET)
    public String projectList(Model model, String dataCenter) {
        return "projectList";
    }

    @RequestMapping(value = "/myProjects", method = RequestMethod.GET)
    public String myProjects(Model model, String dataCenter) {
        return "myProjects";
    }

    @ResponseBody
    @RequestMapping(value = "/stopCollection", method = RequestMethod.GET)
    public String stopCollection(int pid){
        return projectService.stopCollection(pid);
    }

}
