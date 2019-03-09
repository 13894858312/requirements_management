package cn.edu.nju.rm.service.impl.account;

import cn.edu.nju.rm.dao.AccountMapper;
import cn.edu.nju.rm.model.Account;
import cn.edu.nju.rm.service.account.UserInfoService;
import cn.edu.nju.rm.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
@Transactional(rollbackFor = Exception.class)
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    AccountMapper accountMapper;

    /**
     * 编辑个人资料
     *
     * @param account 用户信息
     * @return 编辑结果
     */
    @Override
    public String modifyInfo(Account account) {
        return (1 == accountMapper.updateByPrimaryKeySelective(account))? Constant.SUCCESS:Constant.FAIL;
    }

    /**
     * 根据用户id查找用户信息
     *
     * @param uid 用户登录名
     * @return 用户信息
     */
    @Override
    public Account findUserInfoById(String uid) {
        return accountMapper.selectById(uid);
    }
}
