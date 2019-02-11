package cn.edu.nju.rm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wangxue on 2018/12/10.
 * @author wangxue
 */
@Controller
public class BasicController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, String dataCenter) {
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model, String dataCenter) {
        return "home";
    }

//temp

    @RequestMapping(value = "/commentElement", method = RequestMethod.GET)
    public String commentElement(Model model, String dataCenter) {
        return "commentElement";
    }

    @RequestMapping(value = "/replyElement", method = RequestMethod.GET)
    public String replyElement(Model model, String dataCenter) {
        return "replyElement";
    }

    @RequestMapping(value = "/postElement", method = RequestMethod.GET)
    public String postElement(Model model, String dataCenter) {
        return "postElement";
    }

    @RequestMapping(value = "/projectElement", method = RequestMethod.GET)
    public String projectElement(Model model, String dataCenter) {
        return "projectElement";
    }

}
