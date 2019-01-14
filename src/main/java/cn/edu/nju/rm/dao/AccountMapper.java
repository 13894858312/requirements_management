package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Account;
import cn.edu.nju.rm.model.AccountWithBLOBs;

public interface AccountMapper {
    int deleteByPrimaryKey(String uid);

    int insert(AccountWithBLOBs record);

    int insertSelective(AccountWithBLOBs record);

    AccountWithBLOBs selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(AccountWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AccountWithBLOBs record);

    int updateByPrimaryKey(Account record);
}