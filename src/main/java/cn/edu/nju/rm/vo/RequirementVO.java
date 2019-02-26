package cn.edu.nju.rm.vo;

import cn.edu.nju.rm.model.Comment;
import cn.edu.nju.rm.model.Requirement;

import java.util.List;

/**
 * @author wangxue
 * Created by wangxue on 2019/2/26.
 */
public class RequirementVO {
    /**
     * 需求信息
     */
    Requirement requirement;
    /**
     * 评论列表
     */
    List<Comment> commentList;

    @Override
    public String toString() {
        return super.toString();
    }
}
