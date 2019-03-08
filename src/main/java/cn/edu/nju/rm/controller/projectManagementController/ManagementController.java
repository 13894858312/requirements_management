package cn.edu.nju.rm.controller.projectManagementController;

import cn.edu.nju.rm.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String projectManagement() {
        return "projectManagement";
    }

    @ResponseBody
    @RequestMapping(value = "/startCollection", method = RequestMethod.GET)
    public String startCollection(int pid){
        return projectService.startCollection(pid);
    }
}
