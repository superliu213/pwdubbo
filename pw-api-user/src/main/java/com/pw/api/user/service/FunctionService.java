package com.pw.api.user.service;


import com.pw.api.user.entity.Function;
import com.pw.common.page.PageBean;
import com.pw.common.page.PageParam;

import java.util.List;
import java.util.Map;

public interface FunctionService {

	public PageBean getFunctionPageBean(PageParam pageParam, Map<String, Object> paramMap);

	List<Function> getAllFunctions();

	List<Function> getFunctionsNoButton(String userId);

	void removeFunctionByKey(Long id);

	void addFunction(Function function);

	void updateFunction(Function function);

	void initData();

	List<String> getButtonPosition(String formName, String user);

}
