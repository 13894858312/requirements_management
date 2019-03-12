package cn.edu.nju.rm.service.code;

import cn.edu.nju.rm.model.Code;

import java.util.List;

/**
 * Created by makewei on 2019/3/10.
 */
public interface CodeService {

    /**
     * 提交项目代码
     * @param code 项目代码信息
     * @return 提交结果
     */
    String submitCode(Code code);

    /**
     * 根据项目Id查找提交的代码文件列表
     * @param projectId 项目id
     * @return 代码文件列表
     */
    List<Code> findCodeListByProjectId(int projectId);

    /**
     * 根据代码Id查找代码结构信息
     * @param codeId 项目代码id
     * @return 项目代码信息
     */
    Code findCodeInfoById(int codeId);

}
