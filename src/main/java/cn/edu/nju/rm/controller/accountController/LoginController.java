package cn.edu.nju.rm.controller.accountController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wangxue on 2019/1/31.
 * @author wangxue
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(Model model, String dataCenter) {
        return "login";
    }
}
