package cn.edu.nju.rm.controller.codeController;

import cn.edu.nju.rm.model.Code;
import cn.edu.nju.rm.service.code.CodeService;
import cn.edu.nju.rm.service.project.ProjectService;
import cn.edu.nju.rm.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * Created by makewei on 2019/3/11.
 */
@Controller
@RequestMapping(value = "/post")
public class CodeController {

    @Autowired
    CodeService codeService;

    /**
     * 提交项目代码
     * @param session
     * @param pid
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/submitCode", method = RequestMethod.POST)
    public String submitCode(HttpSession session, Integer pid, MultipartFile file){

        //String uid = session.getAttribute(Constant.SESSION_KEY).toString();

        String fileName = file.getOriginalFilename();
        String location = "D:\\毕业设计\\workspace\\code\\" + fileName;
        File targetFile = new File(location);

        Code code= new Code(pid,location);
        return codeService.submitCode(code);
    }


}
