package com.pw.service.user.service;

import com.pw.api.user.service.CodeService;
import com.pw.common.core.service.BaseService;
import com.pw.common.entity.Columns;
import com.pw.common.entity.Tables;
import com.pw.common.page.PageBean;
import com.pw.common.page.PageParam;
import com.pw.common.util.GenUtils;
import com.pw.service.user.dao.CodeDao;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Service("codeService")
public class CodeServiceImpl extends BaseService implements CodeService {

    @Autowired
    CodeDao codeDao;

    @Override
    public PageBean getTables(PageParam pageParam, Map<String, Object> paramMap) {
        PageBean pageBean = codeDao.listPage(pageParam, paramMap);
        return pageBean;
    }

    @Override
    public byte[] generatorCode(String[] buttonsNames, String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for(String tableName : tableNames){
            //查询表信息
            Tables table = codeDao.getTable(tableName);
            //查询列信息
            List<Columns> columns = codeDao.getColumns(tableName);
            //生成代码
            GenUtils.generatorCode(table, columns, zip, buttonsNames);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
