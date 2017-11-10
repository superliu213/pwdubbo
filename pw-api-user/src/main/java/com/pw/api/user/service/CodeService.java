package com.pw.api.user.service;


import com.pw.common.page.PageBean;
import com.pw.common.page.PageParam;

import java.util.Map;

public interface CodeService {

    public PageBean getTables(PageParam pageParam, Map<String, Object> paramMap);

    public byte[] generatorCode(String[] buttonsNames, String[] tableNames);

}
