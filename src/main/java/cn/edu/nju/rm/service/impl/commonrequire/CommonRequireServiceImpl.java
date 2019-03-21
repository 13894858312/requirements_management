package cn.edu.nju.rm.service.impl.commonrequire;

import cn.edu.nju.rm.dao.CommonRequireMapper;
import cn.edu.nju.rm.model.CommonRequire;
import cn.edu.nju.rm.service.commonrequire.CommonRequireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/19 15:31
 */
@Transactional(rollbackFor = Exception.class)
@Service("CommonRequireService")
public class CommonRequireServiceImpl implements CommonRequireService {

    @Autowired
    private CommonRequireMapper commonRequireMapper;

    @Override
    public String addCommonRequire(CommonRequire commonRequire) {
        return null;
    }

    @Override
    public List<CommonRequire> findAllByProject(int pid) {
        return commonRequireMapper.selectAllByProject(pid);
    }
}
