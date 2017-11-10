package com.pw.service.user.service;

import com.pw.api.user.service.LogService;
import com.pw.common.core.dao.SysLogDao;
import com.pw.common.core.service.BaseService;
import com.pw.common.entity.SysLog;
import com.pw.common.page.PageBean;
import com.pw.common.page.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("logService")
@Transactional
public class LogServiceImpl extends BaseService implements LogService {

	@Autowired
	SysLogDao sysLogDao;

	@Override
	public void initData() {
		Date date = new Timestamp(System.currentTimeMillis());
		SysLog log1 = new SysLog(1L, date, "admin", (short) 1, (short) 1);
		SysLog log2 = new SysLog(2L, date, "2", (short) 2, (short) 2);

		List<SysLog> sysLogs = sysLogDao.listBy(null);
		for (SysLog sysLog : sysLogs) {
			sysLogDao.deleteById(sysLog.getId());
		}

		sysLogDao.insert(log1);
		sysLogDao.insert(log2);
	}

	@Override
	public PageBean getLogs(PageParam pageParam, Map<String, Object> paramMap) {
		PageBean pageBean = sysLogDao.listPage(pageParam, paramMap);
		return pageBean;
	}

	@Override
	public List<SysLog> getLogs() {
		List<SysLog> result = sysLogDao.listBy(null);
		return result;
	}

	public void addLog(SysLog sysLog) {
		sysLogDao.insert(sysLog);
	}

}
