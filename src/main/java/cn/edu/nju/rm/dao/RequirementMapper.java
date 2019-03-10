package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Requirement;

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
     * 返回项目所有需求列表
     * @param pid 项目id
     * @return 需求列表
     */
    List<Requirement> selectAll(Integer pid);

    /**
     * 返回项目已选需求列表
     * @param pid 项目id
     * @return 需求列表
     */
    List<Requirement> selectAllSelected(Integer pid);

    /**
     * 返回项目已收集需求数
     * @param pid 项目id
     * @return 已收集需求数
     */
    long checkNumber (Integer pid);
}