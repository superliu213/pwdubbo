package com.pw.service.user.dao;

import com.pw.api.user.entity.UserRole;
import com.pw.common.core.dao.BaseDao;

import java.util.List;

public interface UserRoleDao extends BaseDao<UserRole> {

    void deleteByUserId(String userId);

    void deleteByRoleId(String roleId);

    List<String> getRoleList(String userId);

}
