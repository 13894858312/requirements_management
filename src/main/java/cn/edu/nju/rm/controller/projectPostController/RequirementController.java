package cn.edu.nju.rm.controller.projectPostController;

import cn.edu.nju.rm.model.Requirement;
import cn.edu.nju.rm.service.requirement.RequirementService;
import cn.edu.nju.rm.util.Constant;
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
public class RequirementController {

    @Autowired
    private RequirementService requirementService;

    @RequestMapping(value = "/sendRequirement", method = RequestMethod.GET)
    public String sendRequirement(Integer pid, Integer rid, Model model) {
        if (pid!=null && rid!=null){
            model.addAttribute(Constant.REQUIREMENT, requirementService.findRequirementInfoById(rid));
        }
        return "sendRequirement";
    }

    /**
     * 添加需求
     * @param session
     * @param pid
     * @param name
     * @param type
     * @param priority
     * @param description
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/createRequirement", method = RequestMethod.POST)
    public String createRequirement(HttpSession session, Integer rid, Integer pid, String name, String type, Integer priority, String description){
        String uid = session.getAttribute(Constant.SESSION_KEY).toString();
        Requirement requirement = new Requirement(rid, pid, uid, name, type, priority, description);
        return requirementService.addRequirement(requirement);
    }

    /**
     * 编辑需求
     * @param session
     * @param rid
     * @param pid
     * @param name
     * @param type
     * @param priority
     * @param description
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editRequirement", method = RequestMethod.POST)
    public String editRequirement(HttpSession session, Integer rid, Integer pid, String name, String type, Integer priority, String description){
        String uid = session.getAttribute(Constant.SESSION_KEY).toString();
        Requirement requirement = new Requirement(rid, pid, uid, name, type, priority, description);
        return requirementService.modifyRequirement(requirement);

    }
}
