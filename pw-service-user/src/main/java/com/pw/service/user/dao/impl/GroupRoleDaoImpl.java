package com.pw.service.user.dao.impl;

import com.pw.api.user.entity.GroupRole;
import com.pw.common.core.dao.impl.BaseDaoImpl;
import com.pw.service.user.dao.GroupRoleDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("groupRoleDao")
public class GroupRoleDaoImpl extends BaseDaoImpl<GroupRole> implements GroupRoleDao {

    @Override
    public void deleteByGroupId(String groupId) {
        super.getSqlSession().delete(getStatement("deleteByGroupId"),groupId);
    }

    @Override
    public void deleteByRoleId(String roleId) {
        super.getSqlSession().delete(getStatement("deleteByRoleId"),roleId);
    }

    @Override
    public List<String> getRoleList(String groupId) {
        List<String> reuslt = super.getSqlSession().selectList(getStatement("getRoleList"),groupId);
        return reuslt;
    }
}
