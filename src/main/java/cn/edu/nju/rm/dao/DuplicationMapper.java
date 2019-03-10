package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Duplication;

import java.util.List;

public interface DuplicationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Duplication record);

    int insertSelective(Duplication record);

    Duplication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Duplication record);

    int updateByPrimaryKey(Duplication record);

    /**
     * 查询重复集中已有的全部重复条目
     * @return 全部重复信息
     */
    List<Duplication> selectAll();
}