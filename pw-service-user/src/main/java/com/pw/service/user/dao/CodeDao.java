package com.pw.service.user.dao;

import com.pw.common.core.dao.BaseDao;
import com.pw.common.entity.Columns;
import com.pw.common.entity.Tables;

import java.util.List;

public interface CodeDao extends BaseDao {

    public Tables getTable(String tableName);

    public List<Columns> getColumns(String tableName);

}
