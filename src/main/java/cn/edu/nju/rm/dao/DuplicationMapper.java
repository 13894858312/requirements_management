package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Duplication;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
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

    /**
     * 查询重复集中该项目已有的全部重复条目
     * @param pid 项目id
     * @return 全部重复信息
     */
    List<Duplication> selectAllByProject(@Param("pid") Integer pid);

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