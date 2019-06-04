package cn.edu.nju.rm.controller.codeController;

import cn.edu.nju.rm.model.*;
import cn.edu.nju.rm.model.Relation;
import cn.edu.nju.rm.service.UML.UMLService;
import cn.edu.nju.rm.service.code.CodeService;
import cn.edu.nju.rm.service.project.ProjectService;
import cn.edu.nju.rm.service.relation.RelationService;
import cn.edu.nju.rm.service.requirement.RequirementService;
import cn.edu.nju.rm.util.Constant;
import cn.edu.nju.rm.vo.RequirementRelationVO;
import cn.edu.nju.rm.vo.RequirementVO;
import cn.edu.nju.rm.vo.UmlRelationVO;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by makewei on 2019/3/11.
 */
@Controller
@RequestMapping(value = "/post")
public class CodeController {

    @Autowired
    ProjectService projectService;

    @Autowired
    CodeService codeService;

    @Autowired
    RequirementService requirementService;

    @Autowired
    UMLService umlService;

    @Autowired
    RelationService relationService;




    /**
     * 上传代码文件
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadCodeFile", method = RequestMethod.POST)
    public String uploadCodeFile(HttpServletRequest request, HttpServletResponse response, Model model,Integer pid,
                               @RequestParam(value = "upload_file", required = true) MultipartFile file
    ) throws IOException, ServletException {

        String fileName = file.getOriginalFilename();
        System.out.println(fileName+" "+pid);

        //绝对路径应该改为相对路径，待完善
        String location = "codeFile\\";
        //String location = request.getServletContext().getRealPath("/static/");

        System.out.println(location);

        try {
            File targetFile = new File(location);
            //file.transferTo(targetFile);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(location+fileName);
            out.write(file.getBytes());
            out.flush();
            out.close();

            Code code= new Code(pid,fileName,location+fileName);
            codeService.submitCode(code);
            List<Code> codeList = codeService.findCodeListByProjectId(pid);
            model.addAttribute("codeList",codeList);
            //request.getRequestDispatcher("templates/relationMangement.ftl").forward(request,response);
            return "success";
        } catch (IOException e) {
            return "fail";
            //request.setAttribute("msg","上传失败!请重新选择代码!");
            //request.getRequestDispatcher("templates/uploadCode.ftl").forward(request,response);
        }

    }


    /**
     * 代码关联
     * @return
     */
    @RequestMapping(value="/codeRelation", method = RequestMethod.GET)
    public String codeRelation(HttpServletResponse response,Model model,Integer pid, Integer cid)
            throws  IOException{

        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);
        Code code=codeService.findCodeInfoById(cid);
        model.addAttribute("code", code);

        List<Requirement> requirementList=requirementService.findRequirementsByProject(pid);

        List<RequirementRelationVO> voList = new ArrayList<RequirementRelationVO>();

        List<Relation> relationList =relationService.findRelationList(pid);

        Boolean state;

        for(Requirement requirement : requirementList){
            for (int i=0;i<relationList.size();i++){
                if ((requirement.getRid().equals(relationList.get(i).getAid()))&&(code.getId().equals(relationList.get(i).getBid()))||((requirement.getRid().equals(relationList.get(i).getBid()))&&(code.getId().equals(relationList.get(i).getAid())))){
                    state = true;
                    voList.add(new RequirementRelationVO(requirement, state));
                    break;
                }
                if (i==relationList.size()-1){
                    state = false;
                    voList.add(new RequirementRelationVO(requirement, state));
                    break;
                }
            }
        }
        model.addAttribute(Constant.REQUIREMENT_LIST,voList);


        List<Uml> umlList=umlService.findUMLByProject(pid);

        List<UmlRelationVO> umlRelationVOList = new ArrayList<UmlRelationVO>();

        Boolean ustate;

        for(Uml uml : umlList){
            for (int i=0;i<relationList.size();i++){
                if ((uml.getUmlid().equals(relationList.get(i).getAid()))&&(code.getId().equals(relationList.get(i).getBid()))||((uml.getUmlid().equals(relationList.get(i).getBid()))&&(code.getId().equals(relationList.get(i).getAid())))){
                    ustate = true;
                    umlRelationVOList.add(new UmlRelationVO(uml,ustate));
                    break;
                }
                if (i==relationList.size()-1){
                    ustate = false;
                    umlRelationVOList.add(new UmlRelationVO(uml,ustate));
                    break;
                }
            }
        }

        model.addAttribute(Constant.UML_LIST,umlRelationVOList);

        return "codeRelation";
    }

    /**
     * 添加代码和需求关联
     * @param pid pid
     * @param cid 代码id
     * @param rid rid
     * @return
     */

    @RequestMapping(value = "/editCodeRelation", method = RequestMethod.GET)
    public String editCodeRelation(Model model, Integer pid, Integer cid, Integer rid, Boolean state){

        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);
        Code code=codeService.findCodeInfoById(cid);
        model.addAttribute("code", code);

        Relation relation = new Relation(pid, Constant.TYPE_CODE, cid, Constant.TYPE_REQUIREMENT, rid);

        List<Relation> relationList =relationService.findRelationList(pid);

        List<Requirement> requirementList=requirementService.findRequirementsByProject(pid);
        List<RequirementRelationVO> voList = new ArrayList<RequirementRelationVO>();

        System.out.println(cid+" "+rid+" "+state);
        for (Requirement requirement : requirementList){
            if (rid.equals(requirement.getRid())){
                if (state){
                    System.out.println(relationService.deleteRelation(relation));
                    System.out.println(requirement.getName());
                    voList.add(new RequirementRelationVO(requirement,false));
                }
                else {
                    System.out.println(relationService.createRelation(relation));
                    System.out.println(requirement.getName());
                    voList.add(new RequirementRelationVO(requirement,true));
                }
            }
            else {
                for (int i=0;i<relationList.size();i++){
                    if ((requirement.getRid().equals(relationList.get(i).getAid()))&&(code.getId().equals(relationList.get(i).getBid()))||((requirement.getRid().equals(relationList.get(i).getBid()))&&(code.getId().equals(relationList.get(i).getAid())))){
                        state = true;
                        voList.add(new RequirementRelationVO(requirement, state));
                        break;
                    }
                    if (i==relationList.size()-1){
                        state = false;
                        voList.add(new RequirementRelationVO(requirement, state));
                        break;
                    }
                }
            }
        }
        model.addAttribute(Constant.REQUIREMENT_LIST,voList);


        List<Uml> umlList=umlService.findUMLByProject(pid);
        List<UmlRelationVO> umlRelationVOList = new ArrayList<UmlRelationVO>();

        Boolean ustate;

        for(Uml uml : umlList){
            for (int i=0;i<relationList.size();i++){
                if ((uml.getUmlid().equals(relationList.get(i).getAid()))&&(code.getId().equals(relationList.get(i).getBid()))||((uml.getUmlid().equals(relationList.get(i).getBid()))&&(code.getId().equals(relationList.get(i).getAid())))){
                    ustate = true;
                    umlRelationVOList.add(new UmlRelationVO(uml,ustate));
                    break;
                }
                if (i==relationList.size()-1){
                    ustate = false;
                    umlRelationVOList.add(new UmlRelationVO(uml,ustate));
                    break;
                }
            }
        }

        model.addAttribute(Constant.UML_LIST,umlRelationVOList);

        return "editCodeRelation";
    }


    /**
     * 添加代码和图关联
     * @param pid pid
     * @param cid 代码id
     * @param umlid umlid
     * @return
     */
    @RequestMapping(value = "/editUMLRelation", method = RequestMethod.GET)
    public String editUMLRelation(Model model, Integer pid, Integer cid, Integer umlid, Boolean ustate){

        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);
        Code code=codeService.findCodeInfoById(cid);
        model.addAttribute("code", code);

        Relation relation = new Relation(pid, Constant.TYPE_CODE, cid, Constant.TYPE_UML, umlid);

        List<Relation> relationList =relationService.findRelationList(pid);

        List<Requirement> requirementList=requirementService.findRequirementsByProject(pid);

        List<RequirementRelationVO> requirementRelationVOList = new ArrayList<RequirementRelationVO>();

        Boolean state;

        for(Requirement requirement : requirementList){
            for (int i=0;i<relationList.size();i++){
                if ((requirement.getRid().equals(relationList.get(i).getAid()))&&(code.getId().equals(relationList.get(i).getBid()))||((requirement.getRid().equals(relationList.get(i).getBid()))&&(code.getId().equals(relationList.get(i).getAid())))){
                    state = true;
                    requirementRelationVOList.add(new RequirementRelationVO(requirement, state));
                    break;
                }
                if (i==relationList.size()-1){
                    state = false;
                    requirementRelationVOList.add(new RequirementRelationVO(requirement, state));
                    break;
                }
            }
        }
        model.addAttribute(Constant.REQUIREMENT_LIST,requirementRelationVOList);



        List<Uml> umlList = umlService.findUMLByProject(pid);

        List<UmlRelationVO> umlRelationVOList = new ArrayList<UmlRelationVO>();

        for (Uml uml : umlList){
            if (umlid.equals(uml.getUmlid())){
                if (ustate){
                    relationService.deleteRelation(relation);
                    umlRelationVOList.add(new UmlRelationVO(uml,false));
                }
                else {
                    relationService.createRelation(relation);
                    umlRelationVOList.add(new UmlRelationVO(uml,true));
                }
            }
            else {
                for (int i=0;i<relationList.size();i++){
                    if ((uml.getUmlid().equals(relationList.get(i).getAid()))&&(code.getId().equals(relationList.get(i).getBid()))||((uml.getUmlid().equals(relationList.get(i).getBid()))&&(code.getId().equals(relationList.get(i).getAid())))){
                        ustate = true;
                        umlRelationVOList.add(new UmlRelationVO(uml,ustate));
                        break;
                    }
                    if (i==relationList.size()-1){
                        ustate = false;
                        umlRelationVOList.add(new UmlRelationVO(uml,ustate));
                        break;
                    }
                }
            }
        }

        model.addAttribute(Constant.UML_LIST,umlRelationVOList);
        return "editUMLRelation";
    }


}
