package cn.edu.nju.rm.service.commonrequire;

import cn.edu.nju.rm.model.CommonRequire;

import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/19 15:17
 */
public interface CommonRequireService {

    /**
     * 新增一般需求
     * @param commonRequire
     * @return 新增结果
     */
    String addCommonRequire(CommonRequire commonRequire);

    /**
     * 查询项目相关的一般需求条目
     * @param pid
     * @return 需求条目
     */
    List<CommonRequire> findAllByProject(int pid);
}
