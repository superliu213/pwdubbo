package com.pw.service.user.dao;

import com.pw.api.user.entity.RoleFunction;
import com.pw.common.core.dao.BaseDao;

import java.util.List;

public interface RoleFunctionDao extends BaseDao<RoleFunction> {

    void deleteByRoleId(String roleId);

    void deleteByFunctionId(String functionId);

    List<String> getFunctionList(String roleId);
}
