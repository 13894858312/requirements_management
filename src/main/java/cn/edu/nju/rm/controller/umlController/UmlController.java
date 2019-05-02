package cn.edu.nju.rm.controller.umlController;

import cn.edu.nju.rm.model.Relation;
import cn.edu.nju.rm.model.Requirement;
import cn.edu.nju.rm.model.Uml;
import cn.edu.nju.rm.service.UML.UMLService;
import cn.edu.nju.rm.service.relation.RelationService;
import cn.edu.nju.rm.service.requirement.RequirementService;
import cn.edu.nju.rm.util.Constant;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    @Autowired
    RequirementService requirementService;
    @Autowired
    RelationService relationService;

    /**
     * 返回项目uml图列表
     * @param pid
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Integer pid, Integer page, Model model){
        //添加uml列表
        List<Uml> umlList = umlService.findUMLByProject(page, pid);
        model.addAttribute(Constant.UML_LIST, umlList);
        //添加总页数
        long count = umlService.findProjectUMLNumber(pid);
        int pageNumber = (int) Math.ceil(count*1.0/ Constant.UML_NUMBER_IN_A_PAGE);
        model.addAttribute(Constant.PAGE_NUMBER, pageNumber);
        //当前页面
        model.addAttribute(Constant.CURRENT_PAGE, page);

        return "umlList";
    }

    /**
     * 跳转到uml编辑界面
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit() {
        return "editUML";
    }

    /**
     * 获取uml
     * @param umlid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUml", method = RequestMethod.GET)
    public String getUml(Integer umlid){
        Uml uml =  umlService.findUMLById(umlid);
        return JSON.toJSONString(uml);
    }

    /**
     * 获取需求table
     * @param pid
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/getRequirementList", method = RequestMethod.GET)
    public void getRequirementList(Integer pid, Integer umlid, HttpServletResponse response) throws  IOException{
        List<Requirement> requirementList = requirementService.findUMLUnRelatedRequirements(pid, umlid);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(requirementList));
    }

    /**
     * 获取关联table
     * @param umlid
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/getRelationshipList", method = RequestMethod.GET)
    public void getRelationshipList(Integer pid, Integer umlid, HttpServletResponse response) throws  IOException{
        List<Requirement> requirementList = requirementService.findUMLRelatedRequirement(pid, umlid);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(requirementList));
    }

    /**
     * 新建uml图
     * @param pid 所属项目id
     * @param title uml标题
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Integer create(Integer pid, String title){
        Uml uml = new Uml(pid, title);
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
        Uml uml = new Uml(umlid, pid, title, content);
        return umlService.updateUML(uml);
    }

    /**
     * 删除uml图
     * @param umlid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Integer umlid){
        return umlService.deleteUML(umlid);
    }

    /**
     * 添加需求关联
     * @param pid pid
     * @param umlid uml图id
     * @param rid rid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addRelation", method = RequestMethod.GET)
    public String addRelation(Integer pid, Integer umlid, Integer rid){
        Relation relation = new Relation(pid, Constant.TYPE_UML, umlid, Constant.TYPE_REQUIREMENT, rid);
        return relationService.createRelation(relation);
    }

    /**
     * 删除需求关联
     * @param pid pid
     * @param umlid uml图id
     * @param rid rid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteRelation", method = RequestMethod.GET)
    public String deleteRelation(Integer pid, Integer umlid, Integer rid){
        Relation relation = new Relation(pid, Constant.TYPE_UML, umlid, Constant.TYPE_REQUIREMENT, rid);
        return relationService.deleteRelation(relation);
    }
}
