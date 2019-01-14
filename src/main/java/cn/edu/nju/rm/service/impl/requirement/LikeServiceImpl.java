package cn.edu.nju.rm.service.impl.requirement;

import cn.edu.nju.rm.model.LikeKey;
import cn.edu.nju.rm.service.requirement.LikeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
@Transactional(rollbackFor = Exception.class)
@Service("likeService")
public class LikeServiceImpl implements LikeService{
    /**
     * 点赞需求
     * @param like 点赞信息
     * @return 点赞结果
     */
    @Override
    public String likeRequirement(LikeKey like) {
        return null;
    }

    /**
     * 取消点赞需求
     * @param like 点赞信息
     * @return 取消结果
     */
    @Override
    public String cancelLike(LikeKey like) {
        return null;
    }
}
