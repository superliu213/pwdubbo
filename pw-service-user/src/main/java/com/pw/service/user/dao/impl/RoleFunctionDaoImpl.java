package com.pw.service.user.dao.impl;

import com.pw.api.user.entity.RoleFunction;
import com.pw.common.core.dao.impl.BaseDaoImpl;
import com.pw.service.user.dao.RoleFunctionDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("roleFunctionDao")
public class RoleFunctionDaoImpl extends BaseDaoImpl<RoleFunction> implements RoleFunctionDao {
    @Override
    public void deleteByRoleId(String roleId) {
        super.getSqlSession().delete(getStatement("deleteByRoleId"),roleId);

    }

    @Override
    public void deleteByFunctionId(String functionId) {
        super.getSqlSession().delete(getStatement("deleteByFunctionId"),functionId);
    }

    @Override
    public List<String> getFunctionList(String roleId) {
        List<String> result = super.getSqlSession().selectList(getStatement("getFunctionList"), roleId);
        return result;
    }
}
