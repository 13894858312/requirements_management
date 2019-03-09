package cn.edu.nju.rm.service.impl.account;

import cn.edu.nju.rm.dao.AccountMapper;
import cn.edu.nju.rm.model.Account;
import cn.edu.nju.rm.service.account.SignService;
import cn.edu.nju.rm.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
@Transactional(rollbackFor = Exception.class)
@Service("signService")
public class SignServiceImpl implements SignService{


    @Autowired
    private AccountMapper accountMapper;

    public AccountMapper getAccountMapper(){
        return accountMapper;
    }

    public void setAccountMapper(AccountMapper accountMapper){
        this.accountMapper = accountMapper;
    }

    /**
     * 用户登录
     *
     * @param account 用户信息
     * @return 登录结果
     */
    @Override
    public Account login(Account account) {
        return accountMapper.checkLogin(account);
    }

    /**
     * 用户注册
     *
     * @param account 用户信息
     * @return 注册结果
     */
    @Override
    public String register(Account account) {
        return (1 == accountMapper.insertSelective(account))? Constant.SUCCESS:Constant.FAIL;
    }
}
