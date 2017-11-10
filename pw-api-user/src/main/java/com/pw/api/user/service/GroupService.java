package com.pw.api.user.service;


import com.pw.api.user.entity.Group;
import com.pw.common.page.PageBean;
import com.pw.common.page.PageParam;

import java.util.List;
import java.util.Map;

public interface GroupService {
	
	PageBean getGroupPageBean(PageParam pageParam, Map<String, Object> paramMap);

	List<Group> getAllGroups();

	void removeGroupByKey(Long id);

	void addGroup(Group group);

	void updateGroup(Group group);

	void initData();

	List<String> getGroupRole(String groupId);

	void groupRole(String groupId, String[] ids);

	List<String> getUserGroup(String userId);

	void userGroup(String userId, String[] ids);

}
