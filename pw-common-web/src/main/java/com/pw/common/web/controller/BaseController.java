package com.pw.common.web.controller;

import com.pw.common.core.service.ILogService;
import com.pw.common.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

public abstract class BaseController {

    @Autowired
    ILogService syncLogService;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected Object getColumnValue(String param,Class typeClass,Map<String, Object> paramMap){
        if(paramMap.get(param) == null){
            return null;
        }

        if(typeClass.equals(Long.class)){
            return paramMap.get(param).equals("") ? 0l : Long.valueOf(paramMap.get(param).toString());
        }else if(typeClass.equals(String.class)){
            return paramMap.get(param).equals("") ? "" : paramMap.get(param).toString();
        }else if(typeClass.equals(Short.class)){
            return paramMap.get(param).equals("") ? (short)0 : Short.valueOf(paramMap.get(param).toString());
        }else if(typeClass.equals(Integer.class)){
            return paramMap.get(param).equals("") ? 0 : Integer.valueOf(paramMap.get(param).toString());
        }else if(typeClass.equals(Date.class)){
            return paramMap.get(param).equals("") ? new Date() : DateTimeUtil.stringToDate(paramMap.get(param).toString(), DateTimeUtil.DATE_PATTERN);
        }else if(typeClass.equals(Timestamp.class)){
            return paramMap.get(param).equals("") ? new Date() : DateTimeUtil.stringToDate(paramMap.get(param).toString(), DateTimeUtil.DATE_TIME_PATTERN);
        }else {
            return  null;
        }
    }
}
