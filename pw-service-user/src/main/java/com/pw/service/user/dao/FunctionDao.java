package com.pw.service.user.dao;

import com.pw.api.user.entity.Function;
import com.pw.common.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

public interface FunctionDao extends BaseDao<Function> {

    List<Function> getFunctionsNoButtonByAdmin(Map<String, Object> paramMap);

    List<Function> getFunctionsNoButtonByUserId(Map<String, Object> paramMap);

    List<String> getButtonPosition(Map<String, Object> paramMap);

    List getFunctionUsed(Long id);

}
