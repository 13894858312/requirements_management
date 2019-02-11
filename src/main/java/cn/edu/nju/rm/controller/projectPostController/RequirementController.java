package cn.edu.nju.rm.controller.projectPostController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wangxue on 2019/1/31.
 * @author wangxue
 */
@Controller
@RequestMapping(value = "/post")
public class RequirementController {

    @RequestMapping(value = "/sendRequirement", method = RequestMethod.GET)
    public String sendRequirement(Model model, String dataCenter) {
        return "sendRequirement";
    }
}
