package cn.edu.nju.rm.service.impl.uml;

import cn.edu.nju.rm.dao.UmlMapper;
import cn.edu.nju.rm.model.Uml;
import cn.edu.nju.rm.service.UML.UMLService;
import cn.edu.nju.rm.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/10 16:25
 */
@Transactional(rollbackFor = Exception.class)
@Service("UMLService")
public class UMLServiceImpl implements UMLService {
    @Autowired
    UmlMapper umlMapper;

    /**
     * 新建UML
     *
     * @param uml uml信息
     * @return 新建结果
     */
    @Override
    public String addUML(Uml uml) {
        return (1 == umlMapper.insertSelective(uml))? Constant.SUCCESS:Constant.FAIL;
    }

    /**
     * 根据项目id查找UML图
     *
     * @param pid 项目id
     * @return 所有与项目相关的UML图列表
     */
    @Override
    public List<Uml> findUMLByPid(Integer pid) {
        return umlMapper.selectByProject(pid);
    }

    /**
     * 根据id查询UML图的详细信息
     *
     * @param umlid uml id
     * @return 详细信息
     */
    @Override
    public Uml findUMLById(Integer umlid) {
        return umlMapper.selectByPrimaryKey(umlid);
    }

    /**
     * 用于删除没有任何需求关联的UML图
     *
     * @param umlid uml id
     * @return 删除结果
     */
    @Override
    public String deleteUML(Integer umlid) {
        return (1 == umlMapper.deleteByPrimaryKey((umlid))? Constant.SUCCESS:Constant.FAIL);
    }
}
