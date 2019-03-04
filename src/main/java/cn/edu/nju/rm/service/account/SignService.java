package cn.edu.nju.rm.service.account;

import cn.edu.nju.rm.model.Account;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
public interface SignService {
    /**
     * 用户登录
     * @param account 用户信息
     * @return 登录结果
     */
    Account login(Account account);

    /**
     * 用户注册
     * @param account 用户信息
     * @return 注册结果
     */
    String register(Account account);
}
