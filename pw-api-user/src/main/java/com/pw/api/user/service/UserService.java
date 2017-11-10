package com.pw.api.user.service;


import com.pw.api.user.entity.User;
import com.pw.common.page.PageBean;
import com.pw.common.page.PageParam;

import java.util.List;
import java.util.Map;

public interface UserService {

	PageBean getUsers(PageParam pageParam, Map<String, Object> paramMap);

	List<User> getAllUsers();

	void removeUserByKey(Long id);

	void addUser(User user);

	void updateUser(User user);

	void initData();
	
	Boolean checkLoginUser(Map<String, Object> paramMap);

	void passwordreset(Long id, Integer version);

	void updatepassword(Long id, String oldPassword, String newPassword, Integer version);

	User getUser(Long id);

}
