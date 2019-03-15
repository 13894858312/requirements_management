package cn.edu.nju.rm.controller.umlController;

import cn.edu.nju.rm.service.UML.UMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/11 12:52
 */

@Controller
public class UmlController {

    @Autowired
    UMLService umlService;

    @RequestMapping(value = "/editUML", method = RequestMethod.GET)
    public String editUML() {
        return "editUML";
    }
}
