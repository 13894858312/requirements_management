package cn.edu.nju.rm.controller.umlController;

import cn.edu.nju.rm.model.Uml;
import cn.edu.nju.rm.service.UML.UMLService;
import cn.edu.nju.rm.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/11 12:52
 */

@Controller
@RequestMapping(value = "/uml")
public class UmlController {

    @Autowired
    UMLService umlService;

    /**
     * 返回项目uml图列表
     * @param pid
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Integer pid, Model model){
        List<Uml> umlList = umlService.findUMLByProject(pid);
        model.addAttribute(Constant.UML_LIST, umlList);
        return "umlList";
    }

    /**
     * 跳转到uml编辑界面
     * @param umlid
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Integer umlid, Model model) {
        //查找uml
        if(umlid != null){
            //若存在，则添加进model
            Uml uml = umlService.findUMLById(umlid);
            model.addAttribute(Constant.UML, uml);
        }
        return "editUML";
    }

    /**
     * 新建uml图
     * @param pid 所属项目id
     * @param title uml标题
     * @param content 内容
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Integer pid, String title, String content){
        //todo 关联需求
        Uml uml = new Uml(pid, title, content);
        return umlService.createUML(uml);
    }

    /**
     * 保存uml图
     * @param umlid
     * @param pid
     * @param title
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Integer umlid, Integer pid, String title, String content){
        //todo 关联需求
        Uml uml = new Uml(umlid, pid, title, content);
        return umlService.updateUML(uml);
    }

}
