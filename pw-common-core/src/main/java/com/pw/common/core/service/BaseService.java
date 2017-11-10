package com.pw.common.core.service;

import com.pw.common.core.service.impl.SyncLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Service 基类实现
 *
 */
public abstract class BaseService {

	@Autowired
	protected SyncLogService dbLog;

	protected Logger logger = LoggerFactory.getLogger(getClass());

}
