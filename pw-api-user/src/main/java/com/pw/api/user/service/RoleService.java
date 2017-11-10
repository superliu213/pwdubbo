package com.pw.api.user.service;


import com.pw.api.user.entity.Role;
import com.pw.common.page.PageBean;
import com.pw.common.page.PageParam;

import java.util.List;
import java.util.Map;

public interface RoleService {

	public PageBean getPageBean(PageParam pageParam, Map<String, Object> paramMap);

	List<Role> getAllRoles();

	void removeRoleByKey(Long id);

	void addRole(Role role);

	void updateRole(Role role);

	void initData();

	List<String> getRoleFunction(String roleId);

	void roleFunction(String roleId, String[] ids);

	List<String> getUserRole(String userId);

	void userRole(String userId, String[] ids);

}
