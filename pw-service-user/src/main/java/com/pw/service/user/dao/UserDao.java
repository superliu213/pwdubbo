package com.pw.service.user.dao;

import com.pw.api.user.entity.User;
import com.pw.common.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

public interface UserDao extends BaseDao<User> {

    List<User> getUserByUserIdAndPassword(Map<String, Object> paramMap);

    void updatePassword(Map<String, Object> paramMap);

}
