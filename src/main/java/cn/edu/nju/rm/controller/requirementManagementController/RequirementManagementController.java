package cn.edu.nju.rm.controller.requirementManagementController;

import cn.edu.nju.rm.model.CommonRequire;
import cn.edu.nju.rm.model.Conflict;
import cn.edu.nju.rm.model.Project;
import cn.edu.nju.rm.model.Requirement;
import cn.edu.nju.rm.service.commonrequire.CommonRequireService;
import cn.edu.nju.rm.service.conflict.ConflictService;
import cn.edu.nju.rm.service.duplication.DuplicationService;
import cn.edu.nju.rm.service.project.ProjectService;
import cn.edu.nju.rm.service.requirement.RequirementService;
import cn.edu.nju.rm.util.Constant;
import cn.edu.nju.rm.vo.ConflictVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/14 16:30
 */

@Controller
public class RequirementManagementController {

    @Autowired
    ProjectService projectService;

    @Autowired
    CommonRequireService commonRequireService;

    @Autowired
    RequirementService requirementService;

    @Autowired
    ConflictService conflictService;

    @Autowired
    DuplicationService duplicationService;

    @RequestMapping(value="/rm", method = RequestMethod.GET)
    public String requirementManagement(HttpSession session, Model model, Integer pid){

        //为了去往筛选页的pid的传值，需改进
        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        return "requireManagement";
    }


    @RequestMapping(value = "/filtrateRequires",method = RequestMethod.GET)
    public String filtrateRequires(Model model, Integer pid){

        //为了去往需求分类页的pid的传值，需改进
        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        //一般需求
        List<CommonRequire> commonRequireList = commonRequireService.findAllByProject(pid);
        List<Requirement> requirementList = new ArrayList<Requirement>();

        for (CommonRequire commonRequire : commonRequireList){
            int rid = commonRequire.getRid();
            //获取需求列表
            requirementList.add(requirementService.findRequirementInfoById(rid));
        }
        model.addAttribute(Constant.REQUIREMENT_LIST,requirementList);

//        //冲突需求
//        ArrayList<Integer> fidList = conflictService.findFidByProject(pid);
//        //List<Conflict> conflictList = conflictService.findAllByProject(pid);
//        List<ConflictVO> cvoList = new ArrayList<ConflictVO>();
//        for(Integer fid: fidList){
//            Requirement frequirement = requirementService.findRequirementInfoById(fid);
//            String frequirementName = frequirement.getName();
//
//            //获取该首发需求冲突rid列表
//            ArrayList<Integer> ridList = conflictService.findRidByFid(fid);
//            //获取冲突需求信息
//            List<Requirement> crequirementList = new ArrayList<Requirement>();
//            for(Integer rid: ridList){
//                crequirementList.add(requirementService.findRequirementInfoById(rid));
//            }
//
//            //装载VO
//            ConflictVO conflictVO = new ConflictVO(frequirementName, crequirementList);
//            cvoList.add(conflictVO);
//        }
//        model.addAttribute(Constant.REQUIREMENT_LIST,cvoList);
        return "filtrateRequirements";
    }

    @RequestMapping(value="/filtrateResult",method = RequestMethod.GET)
    public String filtrateResult(Model model,Integer pid){

        //为了去往筛选结果页的pid的传值，需改进
        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        List<Requirement> r1 = requirementService.findResultByType(pid,"Security(SE)");
        model.addAttribute(Constant.REQUIREMENT,r1);
        List<Requirement> r2 = requirementService.findResultByType(pid,"Reliability(RE)");
        model.addAttribute(Constant.REQUIREMENT,r2);
        List<Requirement> r3 = requirementService.findResultByType(pid,"Performance(PE)");
        model.addAttribute(Constant.REQUIREMENT,r3);
        List<Requirement> r4 = requirementService.findResultByType(pid,"Lifecycle(LI)");
        model.addAttribute(Constant.REQUIREMENT,r4);
        List<Requirement> r5 = requirementService.findResultByType(pid,"Usability(US)");
        model.addAttribute(Constant.REQUIREMENT,r5);
        List<Requirement> r6 = requirementService.findResultByType(pid,"Capability(CA)");
        model.addAttribute(Constant.REQUIREMENT,r6);
        List<Requirement> r7 = requirementService.findResultByType(pid,"System Interface(SI)");
        model.addAttribute(Constant.REQUIREMENT,r7);
        List<Requirement> r8 = requirementService.findResultByType(pid,"others");
        model.addAttribute(Constant.REQUIREMENT,r8);

        return "filtrateResult";
    }
}
