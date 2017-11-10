package com.pw.service.user.dao.impl;

import com.pw.api.user.entity.User;
import com.pw.common.core.dao.impl.BaseDaoImpl;
import com.pw.service.user.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    public List<User> getUserByUserIdAndPassword(Map<String, Object> paramMap) {
        List<User> result = getSqlSession().selectList(getStatement("getUserByUserIdAndPassword"), paramMap);
        return result;
    }

    @Override
    public void updatePassword(Map<String, Object> paramMap) {
        super.getSqlSession().update(getStatement("updatePassword"), paramMap);
    }

}
