package cn.edu.nju.rm.vo;

import cn.edu.nju.rm.model.Comment;
import cn.edu.nju.rm.model.Requirement;

import java.util.List;

/**
 * @author wangxue
 * Created by wangxue on 2019/2/26.
 */
public class RequirementVO{

    private Requirement requirement;
    private Boolean like;
    private List<Comment> commentList;

    public RequirementVO(Requirement requirement, Boolean like, List<Comment> commentList){
        this.requirement = requirement;
        this.like = like;
        this.commentList = commentList;
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

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
