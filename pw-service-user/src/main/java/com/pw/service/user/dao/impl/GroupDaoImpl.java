package com.pw.service.user.dao.impl;

import com.pw.api.user.entity.Group;
import com.pw.common.core.dao.impl.BaseDaoImpl;
import com.pw.service.user.dao.GroupDao;
import org.springframework.stereotype.Repository;

@Repository("groupDao")
public class GroupDaoImpl extends BaseDaoImpl<Group> implements GroupDao {

}
