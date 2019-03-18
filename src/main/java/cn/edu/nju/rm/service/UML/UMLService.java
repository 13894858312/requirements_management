package cn.edu.nju.rm.service.UML;

import cn.edu.nju.rm.model.Uml;

import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/10 16:12
 */
public interface UMLService {

    /**
     * 新建UML
     * @param uml uml信息
     * @return 新建结果
     */
    String addUML(Uml uml);

    /**
     * 根据项目id查找UML图
     * @param pid 项目id
     * @return 所有与项目相关的UML图列表
     */
    List<Uml> findUMLByPid(Integer pid);

    /**
     * 根据id查询UML图的详细信息
     * @param umlid uml id
     * @return 详细信息
     */
    Uml findUMLById(Integer umlid);

    /**
     * 用于删除没有任何需求关联的UML图
     * @param umlid uml id
     * @return 删除结果
     */
    String deleteUML(Integer umlid);
}
