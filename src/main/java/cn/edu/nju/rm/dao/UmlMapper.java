package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Uml;

import java.util.List;

public interface UmlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Uml record);

    int insertSelective(Uml record);

    Uml selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Uml record);

    int updateByPrimaryKey(Uml record);

    /**
     * 根据项目id查询所有UML图
     * @param pid 项目id
     * @return 所有相关UML图的id列表
     */
    List<Uml> selectUMLByPid(int pid);
}