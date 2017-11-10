package com.pw.service.user.dao.impl;

import com.pw.api.user.entity.UserGroup;
import com.pw.common.core.dao.impl.BaseDaoImpl;
import com.pw.service.user.dao.UserGroupDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userGroupDao")
public class UserGroupDaoImpl extends BaseDaoImpl<UserGroup> implements UserGroupDao {

    @Override
    public void deleteByUserId(String userId) {
        super.getSqlSession().delete(getStatement("deleteByUserId"),userId);
    }

    @Override
    public void deleteByGroupId(String groupId) {
        super.getSqlSession().delete(getStatement("deleteByGroupId"),groupId);

    }

    @Override
    public List<String> getUserGroupByUserId(String userId) {
        List<String> reuslt = super.getSqlSession().selectList(getStatement("getUserGroupByUserId"),userId);
        return reuslt;
    }

}
