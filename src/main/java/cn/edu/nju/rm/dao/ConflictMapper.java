package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Conflict;

import java.util.List;

public interface ConflictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Conflict record);

    int insertSelective(Conflict record);

    Conflict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Conflict record);

    int updateByPrimaryKey(Conflict record);

    /**
     * 查询冲突集中已有的全部冲突条目
     * @return 全部冲突信息
     */
    List<Conflict> selectAll();
}