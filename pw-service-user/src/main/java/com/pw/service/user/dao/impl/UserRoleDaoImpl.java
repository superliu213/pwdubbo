package com.pw.service.user.dao.impl;

import com.pw.api.user.entity.UserRole;
import com.pw.common.core.dao.impl.BaseDaoImpl;
import com.pw.service.user.dao.UserRoleDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userRoleDao")
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements UserRoleDao {

    @Override
    public void deleteByUserId(String userId) {
        super.getSqlSession().delete(getStatement("deleteByUserId"),userId);
    }

    @Override
    public void deleteByRoleId(String roleId) {
        super.getSqlSession().delete(getStatement("deleteByRoleId"),roleId);
    }

    @Override
    public List<String> getRoleList(String userId) {
        List<String> result = super.getSqlSession().selectList(getStatement("getRoleList"), userId);
        return result;
    }
}
