package cn.edu.nju.rm.service.impl.uml;

import cn.edu.nju.rm.dao.UmlMapper;
import cn.edu.nju.rm.model.Uml;
import cn.edu.nju.rm.service.UML.UMLService;
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
     *
     * @param uml
     * @return
     */
    @Override
    public String addUML(Uml uml) {
        return null;
    }

    /**
     *
     * @param pid
     * @return
     */
    @Override
    public List<Uml> findUMLByPid(int pid) {
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Uml findUMLById(int id) {
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public String deleteUML(int id) {
        return null;
    }
}
