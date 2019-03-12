package cn.edu.nju.rm.service.impl.code;

import cn.edu.nju.rm.dao.CodeMapper;
import cn.edu.nju.rm.dao.ProjectMapper;
import cn.edu.nju.rm.model.Code;
import cn.edu.nju.rm.service.code.CodeService;
import cn.edu.nju.rm.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by makewei on 2019/3/10.
 */
@Transactional(rollbackFor = Exception.class)
@Service("codeService")
public class CodeServiceImpl implements CodeService{

    CodeMapper codeMapper;

    @Autowired
    public CodeServiceImpl(CodeMapper codeMapper) {
        this.codeMapper = codeMapper;
    }

    /**
     * 提交项目代码
     * @param code 项目代码信息
     * @return 提交结果
     */
    @Override
    public String submitCode(Code code) {

        return (1 == codeMapper.insertSelective(code))? Constant.SUCCESS:Constant.FAIL;

    }

    /**
     * 根据项目Id查找提交的代码列表
     *
     * @param projectId 项目id
     * @return 代码列表
     */
    @Override
    public List<Code> findCodeListByProjectId(int projectId) {
        return null;
    }

    /**
     * 根据代码Id查找代码结构信息
     *
     * @param codeId 项目代码id
     * @return 项目代码信息
     */
    @Override
    public Code findCodeInfoById(int codeId) {

        return codeMapper.selectByPrimaryKey(codeId);

    }

}
