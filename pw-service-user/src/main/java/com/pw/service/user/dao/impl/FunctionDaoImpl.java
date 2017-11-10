package com.pw.service.user.dao.impl;

import com.pw.api.user.entity.Function;
import com.pw.common.core.dao.impl.BaseDaoImpl;
import com.pw.service.user.dao.FunctionDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("functionDao")
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements FunctionDao {
    @Override
    public List<Function> getFunctionsNoButtonByAdmin(Map<String, Object> paramMap) {
        List<Function> result = super.getSqlSession().selectList(getStatement("getFunctionsNoButtonByAdmin"), paramMap);
        return result;
    }

    @Override
    public List<Function> getFunctionsNoButtonByUserId(Map<String, Object> paramMap) {
        List<Function> result = super.getSqlSession().selectList(getStatement("getFunctionsNoButtonByUserId"), paramMap);
        return result;
    }

    @Override
    public List<String> getButtonPosition(Map<String, Object> paramMap) {
        List<String> result = super.getSqlSession().selectList(getStatement("getButtonPosition"), paramMap);
        return result;
    }

    @Override
    public List getFunctionUsed(Long id) {
        List result = super.getSqlSession().selectList(getStatement("getFunctionUsed"), id);
        return result;
    }

}
