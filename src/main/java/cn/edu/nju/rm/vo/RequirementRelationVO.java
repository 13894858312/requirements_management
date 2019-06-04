package cn.edu.nju.rm.vo;

import cn.edu.nju.rm.model.Comment;
import cn.edu.nju.rm.model.Requirement;

import java.util.List;

/**
 * Created by makewei on 2019/5/27.
 */
public class RequirementRelationVO {

    private Requirement requirement;

    private Boolean state;

    public RequirementRelationVO(Requirement requirement, Boolean state){
        this.requirement = requirement;
        this.state = state;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
