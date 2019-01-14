package cn.edu.nju.rm.service.requirement;

import cn.edu.nju.rm.model.Comment;

import java.util.List;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
public interface CommentService {
    /**
     * 评论需求
     * @param comment 评论信息
     * @return 评论结果
     */
    String sendComment(Comment comment);

    /**
     * 修改评论
     * @param comment 评论信息
     * @return 修改结果
     */
    String modifyComment(Comment comment);

    /**
     * 根据id查找评论信息
     * @param cid 评论id
     * @return 评论信息
     */
    Comment findCommentById(int cid);

    /**
     * 查找需求的全部评论信息
     * @param rid 需求id
     * @return 评论信息列表
     */
    List<Comment> findCommentsByReqId(int rid);
}
