package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.LikeKey;

public interface LikeMapper {
    //generator默认方法

//    int deleteByPrimaryKey(LikeKey key);

//    int insert(LikeKey record);

    int insertSelective(LikeKey record);

//

    /**
     * 查找点赞信息
     * @param record 点赞信息
     * @return 查找到的点赞信息
     */
    LikeKey selectByPrimaryKey(LikeKey record);

    /**
     * 添加点赞信息
     * @param record 点赞信息
     * @return 添加结果
     */
    int insert(LikeKey record);

    /**
     * 删除点赞信息
     * @param record 点赞信息
     * @return 删除结果
     */
    int deleteByPrimaryKey(LikeKey record);
}