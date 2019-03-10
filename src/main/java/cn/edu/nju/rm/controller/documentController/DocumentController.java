package cn.edu.nju.rm.controller.documentController;

import cn.edu.nju.rm.service.paragraph.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/10 17:18
 */
@Controller
@RequestMapping(value = "/projectDocument")
public class DocumentController {

    @Autowired
    ParagraphService paragraphService;
}
