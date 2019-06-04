package cn.edu.nju.rm.controller.relationController;

import cn.edu.nju.rm.model.*;
import cn.edu.nju.rm.service.UML.UMLService;
import cn.edu.nju.rm.service.code.CodeService;
import cn.edu.nju.rm.service.project.ProjectService;
import cn.edu.nju.rm.service.relation.RelationService;
import cn.edu.nju.rm.service.requirement.RequirementService;
import cn.edu.nju.rm.util.Constant;
import cn.edu.nju.rm.vo.RelationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by makewei on 2019/3/12.
 */
@Controller
@RequestMapping(value = "/post")
public class RelationController {

    @Autowired
    ProjectService projectService;

    @Autowired
    RelationService relationService;

    @Autowired
    RequirementService requirementService;

    @Autowired
    UMLService umlService;

    @Autowired
    CodeService codeService;

    @RequestMapping(value = "/relationManagement", method = RequestMethod.GET)
    public String relationManagement(HttpSession session, Model model, Integer pid) {

        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        List<Relation> relationList=relationService.findRelationList(pid);
        //System.out.println(relationList.size());
        //List<Requirement> requirementList=requirementService.findRequirementsByProject(pid);
        //List<Uml> umlList=umlService.findUMLByProject(pid);

        model.addAttribute("relationList",relationList);

        return "relationManagement";
    }

    @RequestMapping(value = "/deleteRelation", method = RequestMethod.GET)
    public String deleteRelation(HttpSession session, Model model, Integer pid, Integer rid) {

        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        String result = relationService.deleteRelationById(rid);
        System.out.println(result);
        return Constant.SUCCESS;
    }

    @RequestMapping(value = "/relationEdit", method = RequestMethod.GET)
    public String relationEdit(HttpSession session, Model model, Integer pid) {

        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        List<Relation> relationList=relationService.findRelationList(pid);

        List<RelationVO> relationVOList = new ArrayList<RelationVO>();
        for (Relation relation:relationList){
            if (relation.getBtype()==0){
                String aname=requirementService.findRequirementInfoById(relation.getBid()).getName();
                String adescription = requirementService.findRequirementInfoById(relation.getBid()).getDescription();

                if (relation.getAtype()==2){
                    String bname=umlService.findUMLById(relation.getAid()).getTitle();
                    String bdescription = "";
                    relationVOList.add(new RelationVO(relation.getId(),"需求",aname,adescription,"UML图",bname,bdescription));
                }
                else if ((relation.getAtype()==3)&&(codeService.findCodeInfoById(relation.getAid())!=null)){
                    String bname=codeService.findCodeInfoById(relation.getAid()).getName();
                    String bdescription = codeService.findCodeInfoById(relation.getAid()).getLocation();
                    relationVOList.add(new RelationVO(relation.getId(),"需求",aname,adescription,"代码",bname,bdescription));
                }
            }else if (relation.getAtype()==0){
                String aname=requirementService.findRequirementInfoById(relation.getAid()).getName();
                String adescription = requirementService.findRequirementInfoById(relation.getAid()).getDescription();

                if (relation.getBtype()==2){
                    String bname=umlService.findUMLById(relation.getBid()).getTitle();
                    String bdescription = "";
                    relationVOList.add(new RelationVO(relation.getId(),"需求",aname,adescription,"UML图",bname,bdescription));
                }
                else if ((relation.getBtype()==3)&&(codeService.findCodeInfoById(relation.getBid())!=null)){
                    String bname=codeService.findCodeInfoById(relation.getBid()).getName();
                    String bdescription = codeService.findCodeInfoById(relation.getBid()).getLocation();
                    relationVOList.add(new RelationVO(relation.getId(),"需求",aname,adescription,"代码",bname,bdescription));
                }

            }

        }
        model.addAttribute("relationVOList",relationVOList);
        //List<Requirement> requirementList=requirementService.findRequirementsByProject(pid);
        //List<Uml> umlList=umlService.findUMLByProject(pid);

        model.addAttribute("relationList",relationList);

        return "relationEdit";
    }



    @RequestMapping(value = "/codeManagement", method = RequestMethod.GET)
    public String codeManagement(HttpSession session, Model model, Integer pid) {

        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        List<Code> codeList=codeService.findCodeListByProjectId(pid);
        model.addAttribute("codeList",codeList);

        return "codeManagement";
    }

    @RequestMapping(value = "/codeManagement1", method = RequestMethod.GET)
    public String codeManagement1(HttpSession session, Model model, Integer pid) {

        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        List<Code> codeList=codeService.findCodeListByProjectId(pid);
        model.addAttribute("codeList",codeList);

        return "codeManagement1";
    }

    @RequestMapping(value = "/codeManagement1_1", method = RequestMethod.GET)
    public String codeManagement1_1(HttpSession session, Model model, Integer pid) {

        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        List<Code> codeList = codeService.findCodeListByProjectId(pid);
        model.addAttribute("codeList",codeList);

        return "codeManagement1_1";
    }

    @RequestMapping(value = "/codeManagement1_2", method = RequestMethod.GET)
    public String codeManagement1_2(HttpSession session, Model model, Integer pid) {

        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        List<Code> codeList=new ArrayList<Code>();
        codeList= codeService.findCodeListByProjectId(pid);
        model.addAttribute("codeList",codeList);


        return "codeManagement1_2";
    }

    @RequestMapping(value = "/codeManagement2", method = RequestMethod.GET)
    public String codeManagement2(HttpSession session, Model model, Integer pid) {

        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        List<Code> codeList=codeService.findCodeListByProjectId(pid);
        model.addAttribute("codeList",codeList);

        return "codeManagement2";
    }

    @RequestMapping(value = "/codeManagement3", method = RequestMethod.GET)
    public String codeManagement3(HttpSession session, Model model, Integer pid) {

        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        List<Code> codeList=codeService.findCodeListByProjectId(pid);
        model.addAttribute("codeList",codeList);

        return "codeManagement3";
    }
}
