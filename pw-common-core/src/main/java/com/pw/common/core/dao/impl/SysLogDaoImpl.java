package com.pw.common.core.dao.impl;


import com.pw.common.core.dao.SysLogDao;
import com.pw.common.entity.SysLog;
import org.springframework.stereotype.Repository;

@Repository("logDao")
public class SysLogDaoImpl extends BaseDaoImpl<SysLog> implements SysLogDao {
}
