package com.pw.service.user.dao.impl;


import com.pw.api.user.entity.Role;
import com.pw.common.core.dao.impl.BaseDaoImpl;
import com.pw.service.user.dao.RoleDao;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
}
