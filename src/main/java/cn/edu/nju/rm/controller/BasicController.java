package cn.edu.nju.rm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wangxue on 2018/12/10.
 * @author wangxue
 */
@Controller
public class BasicController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

//temp

    @RequestMapping(value = "/commentElement", method = RequestMethod.GET)
    public String commentElement() {
        return "commentElement";
    }

    @RequestMapping(value = "/replyElement", method = RequestMethod.GET)
    public String replyElement() {
        return "replyElement";
    }

    @RequestMapping(value = "/postElement", method = RequestMethod.GET)
    public String postElement() {
        return "postElement";
    }

    @RequestMapping(value = "/projectElement", method = RequestMethod.GET)
    public String projectElement() {
        return "projectElement";
    }

    @RequestMapping(value = "/projectManagement", method = RequestMethod.GET)
    public String projectManagement() {
        return "projectManagement";
    }

}
