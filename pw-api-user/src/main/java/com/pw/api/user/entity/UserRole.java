package com.pw.api.user.entity;


import com.pw.common.entity.BaseEntity;

public class UserRole extends BaseEntity {

	//序号
	private Long id;
	//版本编号
	private Integer version;
	//用户编码
	private String userId;
	//角色编码
	private String roleId;

	public UserRole() {}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersion() {
		return version;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleId() {
		return roleId;
	}
}
