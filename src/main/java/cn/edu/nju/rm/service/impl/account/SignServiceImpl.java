package cn.edu.nju.rm.service.impl.account;

import cn.edu.nju.rm.model.Account;
import cn.edu.nju.rm.service.account.SignService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
@Transactional(rollbackFor = Exception.class)
@Service("signService")
public class SignServiceImpl implements SignService{
    /**
     * 用户登录
     *
     * @param account 用户信息
     * @return 登录结果
     */
    @Override
    public String login(Account account) {
        return null;
    }

    /**
     * 用户注册
     *
     * @param account 用户信息
     * @return 注册结果
     */
    @Override
    public String register(Account account) {
        return null;
    }
}
