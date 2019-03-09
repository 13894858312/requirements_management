package cn.edu.nju.rm.controller.accountController;

import cn.edu.nju.rm.model.Account;
import cn.edu.nju.rm.service.account.SignService;
import cn.edu.nju.rm.service.account.UserInfoService;
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
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    SignService signService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String userInfo(HttpSession session, Model model) {
        String uid = session.getAttribute(Constant.SESSION_KEY).toString();
        Account account = userInfoService.findUserInfoById(uid);
        model.addAttribute(Constant.ACCOUNT, account);
        return "userInfo";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public String changePassword() {
        return "changePassword";
    }


    /**
     * 修改用户信息
     * @param session
     * @param name
     * @param occupation
     * @param telephone
     * @param email
     * @param introduction
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String userInfoModify(HttpSession session, String name, String occupation,
                                 String telephone, String email, String introduction){
        String uid = session.getAttribute(Constant.SESSION_KEY).toString();
        Account account = new Account(uid, name, telephone, email, occupation, introduction);
        return userInfoService.modifyInfo(account);
    }

    /**
     * 修改密码
     * @param session
     * @param oldPassword
     * @param newPassword
     * @param rePassword
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/doChangePassword", method = RequestMethod.POST)
    public String doChangePassword(HttpSession session, String oldPassword, String newPassword, String rePassword){
        //取session uid
        String uid = session.getAttribute(Constant.SESSION_KEY).toString();

        try{
            //空数据校验
            if(uid == null || oldPassword == null || newPassword == null || rePassword ==null
                    || "".equals(uid) || "".equals(oldPassword) || "".equals(newPassword) || "".equals(rePassword)){
                throw new IllegalArgumentException(Constant.NULL_VALUE);
            }
            //两次输入密码是否相同
            if (!newPassword.equals(rePassword)){
                return Constant.DIFFERENT_PASSWORD;
            }
        }catch (IllegalArgumentException e){
            //出错
            e.printStackTrace();
            return Constant.WRONG;
        }
        Account account = new Account(uid, newPassword);
        //检查旧密码
        Account checkLoginAccount = signService.login(account);
        if(checkLoginAccount == null){
            return Constant.FAIL;
        }
        return userInfoService.modifyInfo(account);
    }
}
