package com.pw.web.system.interceptor;

import com.alibaba.fastjson.JSON;
import com.pw.common.application.ApplicationGlobalNames;
import com.pw.common.constants.DbCollection;
import com.pw.common.constants.MessageCode;
import com.pw.common.util.AuthIDUtils;
import com.pw.common.vo.SessionInfo;
import com.pw.common.web.vo.DataDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("/login") || requestURI.endsWith(".html")||requestURI.endsWith("/codecreate")) {
            return true;
        }
    	
		String authId = request.getHeader(ApplicationGlobalNames.AUTH_ID);
		if(authId==null){
			printInfo(response, "未授予权限，即将跳转登录页面");
			return false;
		}
		
		SessionInfo si = DbCollection.cacheMap.get(AuthIDUtils.getUserId(authId).get());
		if (si == null) {
			printInfo(response, "SESSION超时或未登陆，即将跳转登录页面");
			return false;
		}
				
		if (authId.equals(si.getAuthId()) == false){ //判断是否存在并且判断是否新的AUTH-ID
			printInfo(response, "您已在"+(StringUtils.isBlank(si.getIp()) ? "其他地方" : si.getIp())+"登陆");
			return false;
		}
		
        request.getSession().setAttribute(ApplicationGlobalNames.SESSION_KEY_USER, si);
        
        return true;
    }
    
	private void printInfo(HttpServletResponse response, String message){
		try {
			DataDto dto = new DataDto();
			dto.setCode(MessageCode.authority_error);
			dto.setMessage(message);
			
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(JSON.toJSONString(dto));
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
