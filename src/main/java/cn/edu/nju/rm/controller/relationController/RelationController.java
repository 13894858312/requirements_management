package cn.edu.nju.rm.controller.relationController;

import cn.edu.nju.rm.service.project.ProjectService;
import cn.edu.nju.rm.service.relation.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/createRelation", method = RequestMethod.GET)
    public String createRelation() {
        return "createRelation";
    }
}
