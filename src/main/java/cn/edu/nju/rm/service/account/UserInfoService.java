package cn.edu.nju.rm.service.account;

import cn.edu.nju.rm.model.Account;

/**
 * Created by wangxue on 2019/1/14.
 * @author wangxue
 */
public interface UserInfoService {
    /**
     * 编辑个人资料
     * @param account 用户信息
     * @return 编辑结果
     */
    String modifyInfo(Account account);

    /**
     * 根据用户id查找用户信息
     * @param uid 用户登录名
     * @return 用户信息
     */
    Account findUserInfoById(String uid);
}
