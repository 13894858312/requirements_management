package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Uml;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmlMapper {
    int deleteByPrimaryKey(Integer umlid);

    int insert(Uml record);

    int insertSelective(Uml record);

    Uml selectByPrimaryKey(Integer umlid);

    int updateByPrimaryKeySelective(Uml record);

    int updateByPrimaryKey(Uml record);

    /**
     * 根据项目查找uml
     * @param pid 项目ip
     * @return
     */
    List<Uml> selectByProject(@Param("pid") Integer pid);
}