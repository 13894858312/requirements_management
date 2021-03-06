package cn.edu.nju.rm.service.impl.conflict;

import cn.edu.nju.rm.dao.ConflictMapper;
import cn.edu.nju.rm.model.Conflict;
import cn.edu.nju.rm.service.conflict.ConflictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/10 16:09
 */
@Transactional(rollbackFor = Exception.class)
@Service("ConflictService")
public class ConflictServiceImpl implements ConflictService {

    @Autowired
    ConflictMapper conflictMapper;

    /**
     *
     * @param conflict
     * @return
     */
    @Override
    public String addConflict(Conflict conflict) {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Conflict> findAllConflicts() {
        return null;
    }

    @Override
    public List<Conflict> findAllByProject(int pid) {
        return conflictMapper.selectAllByProject(pid);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public String deleteConflict(int id) {
        return null;
    }

    @Override
    public ArrayList<Integer> findFidByProject(int pid) {
        return conflictMapper.selectFidByProject(pid);
    }

    @Override
    public ArrayList<Integer> findRidByFid(int fid) {
        return conflictMapper.selectByFid(fid);
    }
}
