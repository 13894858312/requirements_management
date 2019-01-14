package cn.edu.nju.rm.service.impl.requirement;

import cn.edu.nju.rm.model.Comment;
import cn.edu.nju.rm.service.requirement.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
@Transactional(rollbackFor = Exception.class)
@Service("commentService")
public class CommentServiceImpl implements CommentService{
    /**
     * 评论需求
     *
     * @param comment 评论信息
     * @return 评论结果
     */
    @Override
    public String sendComment(Comment comment) {
        return null;
    }

    /**
     * 修改评论
     *
     * @param comment 评论信息
     * @return 修改结果
     */
    @Override
    public String modifyComment(Comment comment) {
        return null;
    }

    /**
     * 根据id查找评论信息
     *
     * @param cid 评论id
     * @return 评论信息
     */
    @Override
    public Comment findCommentById(int cid) {
        return null;
    }

    /**
     * 查找需求的全部评论信息
     *
     * @param rid 需求id
     * @return 评论信息列表
     */
    @Override
    public List<Comment> findCommentsByReqId(int rid) {
        return null;
    }
}
