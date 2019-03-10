package cn.edu.nju.rm.service.conflict;

import cn.edu.nju.rm.model.Conflict;

import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/10 16:03
 */
public interface ConflictService {

    /**
     * 新增需求冲突条目
     * @param conflict 冲突信息id组
     * @return 新增结果
     */
    String addConflict(Conflict conflict);

    /**
     * 查看所有需求冲突集
     * @return 现有全部冲突集结果
     */
    List<Conflict> findAllConflicts();

    /**
     * 删除选定冲突条目
     * @param id 冲突id
     * @return 删除结果
     */
    String deleteConflict(int id);
}
