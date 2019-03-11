package cn.edu.nju.rm.controller.documentController;

import cn.edu.nju.rm.service.paragraph.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/10 17:18
 */
@Controller
public class DocumentController {

    @Autowired
    ParagraphService paragraphService;

    @RequestMapping(value = "/document", method = RequestMethod.GET)
    public String editProjectDocument() {
        return "editProjectDocument";
    }
}
