package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Uml;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmlMapper {
    int deleteByPrimaryKey(Integer umlid);

    int insert(Uml record);

    Integer insertSelective(Uml record);

    Uml selectByPrimaryKey(Integer umlid);

    int updateByPrimaryKeySelective(Uml record);

    int updateByPrimaryKey(Uml record);

    /**
     * 根据项目查找uml
     * @param pid 项目ip
     * @return
     */
    List<Uml> selectByProject(@Param("pid") Integer pid);

    /**
     * 根据项目查找uml
     * @param offset
     * @param number
     * @param pid 项目ip
     * @return
     */
    List<Uml> selectByProjectWithLimit(@Param("offset") Integer offset, @Param("number") Integer number, @Param("pid") Integer pid);

    /**
     * 查找项目uml数
     * @param pid
     * @return
     */
    Integer selectProjectUMLNumber(@Param("pid") Integer pid);
}