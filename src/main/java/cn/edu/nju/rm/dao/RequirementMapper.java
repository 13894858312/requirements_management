package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Requirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RequirementMapper {
    //generator默认方法
    int deleteByPrimaryKey(Integer rid);

    int insert(Requirement record);

//    int insertSelective(Requirement record);

    Requirement selectByPrimaryKey(Integer rid);

//    int updateByPrimaryKeySelective(Requirement record);

    int updateByPrimaryKey(Requirement record);

//

    /**
     * 根据需求 Id 返回需求信息
     * @param rid 需求id
     * @return 需求信息
     */
    Requirement selectById(Integer rid);

    /**
     * 修改需求信息
     * @param record 可选需求信息
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(Requirement record);

    /**
     * 添加需求信息
     * @param record 可选需求信息
     * @return 修改结果
     */
    int insertSelective(Requirement record);

    /**
     * 返回项目所有需求列表（LIMIT）
     * @param offset 初始偏移量
     * @param number 每页数量
     * @param pid 项目id
     * @return 需求列表
     */
    List<Requirement> selectAllWithLimit(@Param("offset") Integer offset, @Param("number") Integer number, @Param("pid") Integer pid);

    /**
     * 返回项目所有需求列表
     * @param pid 项目id
     * @return 需求列表
     */
    List<Requirement> selectAll(@Param("pid") Integer pid);

    /**
     * 返回项目已选需求列表(limit)
     * @param offset 初始偏移量
     * @param number 每页数量
     * @param pid 项目id
     * @return 需求列表
     */
    List<Requirement> selectAllSelectedWithLimit(@Param("offset") Integer offset, @Param("number") Integer number, @Param("pid") Integer pid);

    /**
     * 返回项目已选需求列表
     * @param pid 项目id
     * @return 需求列表
     */
    List<Requirement> selectAllSelected(@Param("pid") Integer pid);

    /**
     * 返回项目已收集需求数
     * @param pid 项目id
     * @return 已收集需求数
     */
    Integer checkNumber (Integer pid);
}