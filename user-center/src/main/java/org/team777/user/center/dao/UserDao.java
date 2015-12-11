package org.team777.user.center.dao;

import org.springframework.stereotype.Repository;
import org.team777.user.center.entity.CasAccount;

/**
 * Created by zqjiang on 2015/12/10.
 */
@Repository
public interface UserDao {
    CasAccount getAccount(String account);
}
