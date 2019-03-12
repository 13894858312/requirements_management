package cn.edu.nju.rm.controller.projectPostController;

import cn.edu.nju.rm.model.Comment;
import cn.edu.nju.rm.model.Like;
import cn.edu.nju.rm.model.Project;
import cn.edu.nju.rm.model.Requirement;
import cn.edu.nju.rm.service.project.ProjectService;
import cn.edu.nju.rm.service.requirement.CommentService;
import cn.edu.nju.rm.service.requirement.LikeService;
import cn.edu.nju.rm.service.requirement.RequirementService;
import cn.edu.nju.rm.util.Constant;
import cn.edu.nju.rm.vo.RequirementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxue
 * Created by wangxue on 2019/3/12.
 */
@Controller
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private RequirementService requirementService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private LikeService likeService;

    @RequestMapping(value = "/searchProject", method = RequestMethod.GET)
    public String searchProject(){
        return "searchProject";
    }

    /**
     * header项目列表
     * @param model
     * @param page
     * @return
     */
    @RequestMapping(value = "/projectList", method = RequestMethod.GET)
    public String projectList(Model model, Integer page) {
        //添加项目列表
        List<Project> projectList = projectService.findAllProjects(page);
        model.addAttribute(Constant.PROJECT_LIST, projectList);
        //添加页数
        long count = projectService.findNumberOfAllProjects();
        int pageNumber = (int) Math.ceil(count*1.0/ Constant.PROJECT_NUMBER_IN_A_PAGE);
        model.addAttribute(Constant.PAGE_NUMBER, pageNumber);
        //当前页面
        model.addAttribute(Constant.CURRENT_PAGE, page);

        model.addAttribute(Constant.HEADER, "项目列表");
        return "projectList";
    }

    /**
     * header我的项目
     * @param session
     * @param page
     * @param model
     * @return
     */
    @RequestMapping(value = "/myProjects", method = RequestMethod.GET)
    public String myProjects(HttpSession session, Integer page, Model model){
        String uid = session.getAttribute(Constant.SESSION_KEY).toString();
        List<Project> projectList = projectService.findProjectList(page, uid);
        model.addAttribute(Constant.PROJECT_LIST, projectList);

        long count = projectService.findNumberOfProjectsByCondition(uid);
        int pageNumber = (int) Math.ceil(count*1.0/ Constant.PROJECT_NUMBER_IN_A_PAGE);
        model.addAttribute(Constant.PAGE_NUMBER, pageNumber);
        model.addAttribute(Constant.CURRENT_PAGE, page);

        model.addAttribute(Constant.HEADER, "我的项目");
        return "projectList";
    }

    /**
     * 查找项目列表
     * @param publisher
     * @param state
     * @param field
     * @param input
     * @return
     */
    @RequestMapping(value = "/searchResult", method = RequestMethod.GET)
    public ModelAndView searchResult(Integer page, String publisher, String state, String field, String input){
        ModelAndView modelAndView = new ModelAndView();

        //处理publisher
        if(publisher != null && publisher.length() == 0){
            publisher = null;
        }
        //计算state——int
        Integer stateInt;
        if(Constant.STATE_COLLECTING.equals(state)){
            stateInt = Constant.COLLECTING;
        }else if(Constant.STATE_END.equals(state)){
            stateInt = Constant.END_COLLECT;
        }else{
            stateInt = null;
        }
        //处理field
        if(field !=null && field.length() == 0){
            field = null;
        }
        //处理input
        if(input != null && input.length() == 0){
            input = null;
        }
        //获得input格式便于查找
        if(input!=null){
            input = '%' + input + '%';
        }

        List<Project> projectList = projectService.findProjectList(page, publisher, stateInt, field, input);
        modelAndView.addObject(Constant.PROJECT_LIST, projectList);

        long count = projectService.findNumberOfProjectsByCondition(publisher, stateInt, field, input);
        int pageNumber = (int) Math.ceil(count*1.0/ Constant.PROJECT_NUMBER_IN_A_PAGE);
        modelAndView.addObject(Constant.PAGE_NUMBER, pageNumber);
        modelAndView.addObject(Constant.CURRENT_PAGE, page);

        modelAndView.addObject(Constant.HEADER, "搜索结果");
        //记录搜索内容
        String condition = getCondition(publisher, state, field, input);
        modelAndView.addObject(Constant.CONDITION, condition);

        modelAndView.setViewName("projectList");
        return modelAndView;
    }

    /**
     * 项目帖子
     * @param session
     * @param model
     * @param pid
     * @param page
     * @return
     */
    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public String project(HttpSession session, Model model, Integer pid, Integer page) {
        //读取项目
        Project project = projectService.findProjectInfoById(pid);
        model.addAttribute(Constant.PROJECT, project);

        //读取需求列表
        List<Requirement> requirementList = requirementService.findRequirementsByProject(page, pid);
        //获取需求VO
        List<RequirementVO> voList = new ArrayList<RequirementVO>();
        for(Requirement requirement : requirementList){
            int rid = requirement.getRid();
            //获取评论列表
            List<Comment> commentList = commentService.findCommentsByReqId(rid);
            //获取是否点赞
             Boolean like = false;
            //读取session中的uid
            Object uidObject = session.getAttribute(Constant.SESSION_KEY);
            if(uidObject !=null){
                like = likeService.checkIfLike(uidObject.toString(), rid);
            }
            //装载vo
            RequirementVO requirementVO = new RequirementVO(requirement, like, commentList);
            voList.add(requirementVO);
        }
        model.addAttribute(Constant.REQUIREMENT_LIST, voList);

        //需求数
        int count = requirementService.checkNumberOfRequirements(pid);
        model.addAttribute(Constant.NUMBER_OF_REQUIREMENTS, count);
        //总页数
        int pageNumber = (int) Math.ceil(count*1.0/ Constant.REQUIREMENT_NUMBER_IN_A_PAGE);
        model.addAttribute(Constant.PAGE_NUMBER, pageNumber);
        //当前页数
        model.addAttribute(Constant.CURRENT_PAGE, page);

        return "projectPost";
    }

    /**
     * 评论需求
     * @param session
     * @param rid
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String comment(HttpSession session, Integer rid, String content){
        String uid = session.getAttribute(Constant.SESSION_KEY).toString();
        Comment comment = new Comment(rid, uid, content);
        return commentService.sendComment(comment);
    }

    /**
     * 点赞需求
     * @param session
     * @param like
     * @param pid
     * @param rid
     */
    @ResponseBody
    @RequestMapping(value = "/like", method = RequestMethod.GET)
    public String like(HttpSession session, Boolean like, Integer pid, Integer rid){
        String uid = session.getAttribute(Constant.SESSION_KEY).toString();
        Like record = new Like(uid, rid, pid);
        if(like){
            //已点赞，取消点赞
            likeService.like(record);
        }else{
            //未点赞，点赞
            likeService.cancelLike(record);
        }
        return Constant.SUCCESS;
    }

    /**
     * 获取condition字符串
     * @param publisher
     * @param state
     * @param field
     * @param input
     * @return
     */
    private String getCondition(String publisher, String state, String field, String input){
        String condition = "";
        if(publisher != null && publisher.length() != 0){
            condition = condition + "&publisher=" + publisher;
        }
        condition = condition + "&state=" + state;
        if(field != null && field.length() != 0){
            condition = condition + "&field=" + field;
        }
        if(input != null && input.length() != 0){
            condition = condition + "&input=" + input;
        }
        return condition;
    }
}
