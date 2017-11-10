package com.pw.api.user.service;


import com.pw.common.entity.SysLog;
import com.pw.common.page.PageBean;
import com.pw.common.page.PageParam;

import java.util.List;
import java.util.Map;

public interface LogService {

	public PageBean getLogs(PageParam pageParam, Map<String, Object> paramMap);

	List<SysLog> getLogs();

	void initData();

}
