package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Like;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LikeMapper {

    /**
     * 查询用户是否点赞需求
     * @param uid
     * @param rid
     * @return
     */
    Like selectByPrimaryKey(@Param("uid") String uid, @Param("rid") Integer rid);

    /**
     * 根据项目查找用户点赞列表
     * @param uid
     * @param pid
     * @return
     */
    List<Integer> selectUserLikeListInProject(@Param("uid") String uid, @Param("pid") Integer pid);

    /**
     * 添加点赞信息
     * @param record 点赞信息
     * @return 添加结果
     */
    int insert(Like record);

    /**
     * 删除点赞信息
     * @param record 点赞信息
     * @return 删除结果
     */
    int deleteByPrimaryKey(Like record);
}