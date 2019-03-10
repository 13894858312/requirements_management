package cn.edu.nju.rm.service.duplication;

import cn.edu.nju.rm.model.Duplication;

import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/10 15:58
 */
public interface DuplicationService {
    /**
     * 新增重复集条目
     * @param duplication 重复信息id组
     * @return 新增结果
     */
    String addDuplication(Duplication duplication);

    /**
     * 查询所有重复集
     * @return 现有全部重复集结果
     */
    List<Duplication> findAllDuplications();

    /**
     * 删除重复集条目
     * @param id 重复id
     * @return 返回删除结果
     */
    String deleteDuplication(int id);
}
