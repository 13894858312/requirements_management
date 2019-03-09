package cn.edu.nju.rm.service.impl.requirement;

import cn.edu.nju.rm.dao.CommentMapper;
import cn.edu.nju.rm.model.Comment;
import cn.edu.nju.rm.service.requirement.CommentService;
import cn.edu.nju.rm.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CommentMapper commentMapper;

    /**
     * 评论需求
     *
     * @param comment 评论信息
     * @return 评论结果
     */
    @Override
    public String sendComment(Comment comment) {
        return (1 == commentMapper.insertSelective(comment))? Constant.SUCCESS:Constant.FAIL;
    }

    /**
     * 修改评论
     *
     * @param comment 评论信息
     * @return 修改结果
     */
    @Override
    public String modifyComment(Comment comment) {
        return (1 == commentMapper.updateByPrimaryKeySelective(comment))? Constant.SUCCESS:Constant.FAIL;
    }

    /**
     * 根据id查找评论信息
     *
     * @param cid 评论id
     * @return 评论信息
     */
    @Override
    public Comment findCommentById(int cid) {
        return commentMapper.selectById(cid);
    }

    /**
     * 查找需求的全部评论信息
     *
     * @param rid 需求id
     * @return 评论信息列表
     */
    @Override
    public List<Comment> findCommentsByReqId(int rid) {
        return commentMapper.selectAll(rid);
    }
}
