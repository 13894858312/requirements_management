package cn.edu.nju.rm.service.impl.duplication;

import cn.edu.nju.rm.dao.DuplicationMapper;
import cn.edu.nju.rm.model.Duplication;
import cn.edu.nju.rm.service.duplication.DuplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/10 15:08
 */
@Transactional(rollbackFor = Exception.class)
@Service("DuplicationService")
public class DuplicationServiceImpl implements DuplicationService {

    @Autowired
    DuplicationMapper duplicationMapper;

    /**
     *
     * @param duplication
     * @return
     */
    @Override
    public String addDuplication(Duplication duplication) {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Duplication> findAllDuplications() {
        return null;
    }


    @Override
    public List<Duplication> findAllByProject(int pid) {
        return duplicationMapper.selectAllByProject(pid);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public String deleteDuplication(int id) {
        return null;
    }

    @Override
    public ArrayList<Integer> findFidByProject(int pid) {
        return duplicationMapper.selectFidByProject(pid);
    }

    @Override
    public ArrayList<Integer> findRidByFid(int fid) {
        return duplicationMapper.selectByFid(fid);
    }
}
