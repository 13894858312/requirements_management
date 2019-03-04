package cn.edu.nju.rm.controller.accountController;

import cn.edu.nju.rm.model.Account;
import cn.edu.nju.rm.service.account.SignService;
import cn.edu.nju.rm.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangxue on 2019/1/31.
 * @author wangxue
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    SignService signService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(Model model, String dataCenter) {
        return "login";
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        //获取表单
        String uid = request.getParameter("uid");
        String password = request.getParameter("password");

        //验证登录
        Account account = signService.login(new Account(uid, password));
        if(checkIfLoginSuccess(account, uid, password)){
            //添加session
            request.getSession().setAttribute(Constant.SESSION_KEY, account);
            //添加model
            account.setPassword("");
            model.addAttribute("account", account);
            return Constant.SUCCESS;
        }else{
            return Constant.FAIL;
        }
    }

    /**
     * 检查登录状态
     * @param account 后台数据库获得的account
     * @param uid
     * @param password
     * @return
     */
    private boolean checkIfLoginSuccess(Account account, String uid, String password){
        return (account!=null) && (account.getUid().equals(uid)) && (account.getPassword().equals(password));
    }

    /**
     * 处理cookie
     * @param uid
     * @param response
     * @param operationType set:设置cookie， clear：清除
     */
    private void handleCookie(String uid, HttpServletResponse response, int operationType) {
        Cookie loginNameCookie = new Cookie("uid",uid);
        loginNameCookie.setMaxAge(operationType);
        response.addCookie(loginNameCookie);
    }

}
