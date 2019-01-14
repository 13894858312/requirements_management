package cn.edu.nju.rm.service.requirement;

import cn.edu.nju.rm.model.LikeKey;

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
    String likeRequirement(LikeKey like);

    /**
     * 取消点赞需求
     * @param like 点赞信息
     * @return 取消结果
     */
    String cancelLike(LikeKey like);
}
