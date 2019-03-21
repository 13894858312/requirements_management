package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.CommonRequire;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/19 15:05
 */
public interface CommonRequireMapper {

    /**
     * 获取一般需求id列表
     * @param pid 项目id
     * @return 需求id列表
     */
    List<CommonRequire> selectAllByProject(@Param("pid") Integer pid);
}
