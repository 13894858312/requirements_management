package cn.edu.nju.rm.controller;

import cn.edu.nju.rm.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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

    /**
     * 注销
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.removeAttribute(Constant.SESSION_KEY);
        return Constant.SUCCESS;
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

}
