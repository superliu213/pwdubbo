package com.pw.common.vo;

import java.io.Serializable;

public class SessionInfo implements Serializable{

	private static final long serialVersionUID = -8132203359845618360L;

	private String ip;
	
	/**
	 * TOKENID
	 */
	private String authId;
	
	String userId;
	
	public SessionInfo() {
		super();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SessionInfo{" +
				"userId='" + userId + '\'' +
				'}';
	}
}
