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

        //需求分类
        List<Requirement> requirementList1 = requirementService.findRequirementsByType(pid,"Security(SE)");
        model.addAttribute("requirementList1",requirementList1);
        List<Requirement> requirementList2 = requirementService.findRequirementsByType(pid,"Reliability (RE)");
        model.addAttribute("requirementList2",requirementList2);
        List<Requirement> requirementList3 = requirementService.findRequirementsByType(pid,"Performance (PE)");
        model.addAttribute("requirementList3",requirementList3);
        List<Requirement> requirementList4 = requirementService.findRequirementsByType(pid,"Lifecycle (LI)");
        model.addAttribute("requirementList4",requirementList4);
        List<Requirement> requirementList5 = requirementService.findRequirementsByType(pid,"Usability (US)");
        model.addAttribute("requirementList5",requirementList5);
        List<Requirement> requirementList6 = requirementService.findRequirementsByType(pid,"Capability (CA)");
        model.addAttribute("requirementList6",requirementList6);
        List<Requirement> requirementList7 = requirementService.findRequirementsByType(pid,"System Interface (SI)");
        model.addAttribute("requirementList7",requirementList7);
        List<Requirement> requirementList8 = requirementService.findRequirementsByType(pid,"others");
        model.addAttribute("requirementList8",requirementList8);

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

        //冲突需求
//        ArrayList<Integer> fidList = conflictService.findFidByProject(pid);
//        //List<Conflict> conflictList = conflictService.findAllByProject(pid);
//        List<ConflictVO> cvoList = new ArrayList<ConflictVO>();
//        for(Integer fid: fidList){
//
//            //获取首发需求信息
//            Requirement frequirement = requirementService.findRequirementInfoById(fid);
//            String frequirementName = frequirement.getName();
//
//            //定义冲突需求信息表
//            List<Requirement> crequirementList = new ArrayList<Requirement>();
//            //添加首发需求信息
//            crequirementList.add(frequirement);
//
//            //获取该首发需求冲突rid列表
//            ArrayList<Integer> ridList = conflictService.findRidByFid(fid);
//
//            for(Integer rid: ridList){
//                crequirementList.add(requirementService.findRequirementInfoById(rid));
//            }
//
//            //装载VO
//            ConflictVO conflictVO = new ConflictVO(frequirementName, crequirementList);
//            cvoList.add(conflictVO);
//        }
//        model.addAttribute("cvoList",cvoList);
        return "filtrateRequirements";
    }

    @RequestMapping(value="/filtrateResult",method = RequestMethod.GET)
    public String filtrateResult(Model model,Integer pid){

        //为了去往筛选结果页的pid的传值，需改进
        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        List<Requirement> r1 = requirementService.findResultByType(pid,"Security(SE)");
        model.addAttribute("r1",r1);
        List<Requirement> r2 = requirementService.findResultByType(pid,"Reliability (RE)");
        model.addAttribute("r2",r2);
        List<Requirement> r3 = requirementService.findResultByType(pid,"Performance (PE)");
        model.addAttribute("r3",r3);
        List<Requirement> r4 = requirementService.findResultByType(pid,"Lifecycle (LI)");
        model.addAttribute("r4",r4);
        List<Requirement> r5 = requirementService.findResultByType(pid,"Usability (US)");
        model.addAttribute("r5",r5);
        List<Requirement> r6 = requirementService.findResultByType(pid,"Capability (CA)");
        model.addAttribute("r6",r6);
        List<Requirement> r7 = requirementService.findResultByType(pid,"System Interface (SI)");
        model.addAttribute("r7",r7);
        List<Requirement> r8 = requirementService.findResultByType(pid,"others");
        model.addAttribute("r8",r8);

        return "filtrateResult";
    }
}
