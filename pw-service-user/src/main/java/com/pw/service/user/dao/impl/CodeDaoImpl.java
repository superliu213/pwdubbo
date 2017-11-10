package com.pw.service.user.dao.impl;

import com.pw.common.core.dao.impl.BaseDaoImpl;
import com.pw.common.entity.Columns;
import com.pw.common.entity.Tables;
import com.pw.service.user.dao.CodeDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("codeDao")
public class CodeDaoImpl extends BaseDaoImpl implements CodeDao {

    @Override
    public Tables getTable(String tableName) {
        Tables tables = super.getSqlSession().selectOne(getStatement("getTable"), tableName);
        return tables;
    }

    @Override
    public List<Columns> getColumns(String tableName) {
        List<Columns> columns = super.getSqlSession().selectList(getStatement("getColumns"), tableName);
        return columns;
    }
}
