package cn.edu.nju.rm.controller.accountController;

import cn.edu.nju.rm.model.Account;
import cn.edu.nju.rm.service.account.SignService;
import cn.edu.nju.rm.service.account.UserInfoService;
import cn.edu.nju.rm.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by wangxue on 2019/1/31.
 * @author wangxue
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private SignService signService;
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @ResponseBody
    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public String doRegister(String uid, String password, String rePassword, String name,
                             String telephone, String email, String occupation, String introduction) throws IOException{
        try{
            //空数据校验
            if(uid == null || password == null || rePassword ==null
                    || "".equals(uid) || "".equals(password) || "".equals(rePassword)){
                throw new IllegalArgumentException("null_value");
            }
            //两次输入密码是否相同
            if (!password.equals(rePassword)){
                return Constant.DIFFERENT_PASSWORD;
            }
//            //校验uid格式
//            Validator validator = new Validator();
//            if(!validator.isUid(uid)){
//                throw new IllegalArgumentException(Constant.WRONG_UID_PATTERN);
//            }
        }catch (IllegalArgumentException e){
            //出错
            e.printStackTrace();
            return Constant.WRONG;
        }
        //检验uid是否已注册
        Account account = userInfoService.findUserInfoById(uid);
        if(account != null){
            return Constant.UID_EXISTED;
        }
        //注册
        String result=signService.register(new Account(uid, password, name, telephone,
                email, occupation, introduction));
        if(result!=null && result.equals(Constant.SUCCESS)){
            return Constant.SUCCESS;
        }else{
            return Constant.FAIL;
        }
    }

}
