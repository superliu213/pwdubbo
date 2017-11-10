package com.pw.service.user.dao;

import com.pw.api.user.entity.UserGroup;
import com.pw.common.core.dao.BaseDao;

import java.util.List;

public interface UserGroupDao extends BaseDao<UserGroup> {

    void deleteByUserId(String userId);

    void deleteByGroupId(String groupId);

    List<String> getUserGroupByUserId(String userId);

}
