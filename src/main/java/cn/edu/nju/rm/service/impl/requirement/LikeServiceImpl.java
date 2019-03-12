package cn.edu.nju.rm.service.impl.requirement;

import cn.edu.nju.rm.dao.LikeMapper;
import cn.edu.nju.rm.model.Like;
import cn.edu.nju.rm.service.requirement.LikeService;
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
@Service("likeService")
public class LikeServiceImpl implements LikeService{

    @Autowired
    private LikeMapper likeMapper;

    /**
     * 点赞需求
     * @param like 点赞信息
     * @return 点赞结果
     */
    @Override
    public String like(Like like) {
        return (1 == likeMapper.insert(like))? Constant.SUCCESS:Constant.FAIL;
    }

    /**
     * 取消点赞需求
     * @param like 点赞信息
     * @return 取消结果
     */
    @Override
    public String cancelLike(Like like) {
        return (1 == likeMapper.deleteByPrimaryKey(like))? Constant.SUCCESS:Constant.FAIL;

    }

    /**
     * 查询当前项目用户点赞列表
     *
     * @param uid
     * @param pid
     * @return
     */
    @Override
    public List<Integer> findUserLikeListInProject(String uid, Integer pid) {
        return likeMapper.selectUserLikeListInProject(uid, pid);
    }

    /**
     * 查询用户是否点赞了需求
     *
     * @param uid uid
     * @param rid 需求id
     * @return
     */
    @Override
    public Boolean checkIfLike(String uid, Integer rid) {
        return (null == likeMapper.selectByPrimaryKey(uid, rid) );
    }
}
