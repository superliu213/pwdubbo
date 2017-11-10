package com.pw.service.user.dao;

import com.pw.api.user.entity.GroupRole;
import com.pw.common.core.dao.BaseDao;

import java.util.List;

public interface GroupRoleDao extends BaseDao<GroupRole> {

    void deleteByGroupId(String groupId);

    void deleteByRoleId(String roleId) ;

    List<String> getRoleList(String groupId);

}
