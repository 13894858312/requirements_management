package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Comment;

import java.util.List;

public interface CommentMapper {
    //generator默认方法
    int deleteByPrimaryKey(Integer cid);

    int insert(Comment record);

//    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer cid);

//    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);

//

    /**
     * 根据评论 Id 返回评论信息
     * @param cid 评论 Id
     * @return 评论信息
     */
    Comment selectById(Integer cid);

    /**
     * 添加评论信息
     * @param record 评论信息
     * @return 添加结果
     */
    int insertSelective(Comment record);

    /**
     * 修改评论信息
     * @param record 评论信息
     * @return 添加结果
     */
    int updateByPrimaryKeySelective(Comment record);


    /**
     * 返回序曲所有评论列表
     * @param rid 需求id
     * @return 评论列表
     */
    List<Comment> selectAll(Integer rid);
}