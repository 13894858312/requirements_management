package cn.edu.nju.rm.service.requirement;

import cn.edu.nju.rm.model.Like;

import java.util.List;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
public interface LikeService {
    /**
     * 点赞需求
     * @param like 点赞信息
     * @return 点赞结果
     */
    String like(Like like);

    /**
     * 取消点赞需求
     * @param like 点赞信息
     * @return 取消结果
     */
    String cancelLike(Like like);

    /**
     * 查询当前项目用户点赞列表
     * @param uid
     * @param pid
     * @return
     */
    List<Integer> findUserLikeListInProject(String uid, Integer pid);

    /**
     * 查询用户是否点赞了需求
     * @param uid uid
     * @param rid 需求id
     * @return
     */
    Boolean checkIfLike(String uid, Integer rid);
}
