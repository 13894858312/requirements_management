package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Account;
import cn.edu.nju.rm.model.AccountWithBLOBs;

public interface AccountMapper {
    //generator默认方法

    int deleteByPrimaryKey(String uid);

    int insert(AccountWithBLOBs record);

//    int insertSelective(AccountWithBLOBs record);

    AccountWithBLOBs selectByPrimaryKey(String uid);

//    int updateByPrimaryKeySelective(AccountWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AccountWithBLOBs record);

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
    int updateByPrimaryKeySelective(AccountWithBLOBs record);

    /**
     * 添加用户信息
     * @param record 可选用户信息
     * @return 添加结果
     */
    int insertSelective(AccountWithBLOBs record);

}