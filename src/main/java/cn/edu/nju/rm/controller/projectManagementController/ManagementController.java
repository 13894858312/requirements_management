package cn.edu.nju.rm.controller.projectManagementController;

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
@RequestMapping(value = "/projectManagement")
public class ManagementController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String projectManagement(Model model, int pid) {
        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute("project", project);
        return "projectManagement";
    }

    /**
     * 再次开始征集
     * @param session
     * @param pid
     * @param newClosedTime
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/startCollection", method = RequestMethod.GET)
    public String startCollection(HttpSession session, int pid, String newClosedTime){
        String uid = session.getAttribute(Constant.SESSION_KEY).toString();
        return projectService.startCollection(uid, pid, DateHelper.stringToDate(newClosedTime));
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
}
