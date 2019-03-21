package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Conflict;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
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

    /**
     * 查询冲突集中已有的全部冲突条目
     * @param pid 项目id
     * @return 冲突集信息
     */
    List<Conflict> selectAllByProject(@Param("pid") Integer pid);

    /**
     * 查询重复集中该项目已有的全部重复条目的首发需求id
     * @param pid
     * @return fid
     */
    ArrayList<Integer> selectFidByProject(@Param("pid") Integer pid);
    /**
     * 根据首发需求id查询相对应的重复需求
     * @param fid
     * @return 相关重复需求rid
     */
    ArrayList<Integer> selectByFid(@Param("fid") Integer fid);
}