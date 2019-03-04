package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Account;

public interface AccountMapper {
    //generator默认方法

    int deleteByPrimaryKey(String uid);

    int insert(Account record);

//    int insertSelective(Account record);

    Account selectByPrimaryKey(String uid);

//    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

//

    /**
     * 根据用户 Id 返回用户账户信息
     * @param uid uid
     * @return 账户信息
     */
    Account selectById(String uid);

    /**
     * 修改用户信息
     * @param record 可选用户信息
     * @return 修改结果
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * 添加用户信息
     * @param record 可选用户信息
     * @return 添加结果
     */
    int insertSelective(Account record);

    /**
     * 验证账户登录信息
     * @param account 用户账户
     * @return 用户账户
     */
    Account checkLogin(Account account);

}