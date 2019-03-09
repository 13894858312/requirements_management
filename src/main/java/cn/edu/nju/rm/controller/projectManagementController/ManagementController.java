package cn.edu.nju.rm.controller.projectManagementController;

import cn.edu.nju.rm.model.Project;
import cn.edu.nju.rm.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by wangxue on 2019/1/31.
 * @author wangxue
 */
@Controller
@RequestMapping(value = "/projectManagement")
public class ManagementController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String projectManagement(Model model, int pid) {
        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute("project", project);
        return "projectManagement";
    }

    @ResponseBody
    @RequestMapping(value = "/startCollection", method = RequestMethod.GET)
    public String startCollection(int pid, Date newClosedTime){
        return projectService.startCollection(pid, newClosedTime);
    }
}
