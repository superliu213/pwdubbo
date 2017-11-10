package com.pw.web.system.controllers;

import com.alibaba.fastjson.JSON;
import com.pw.api.user.service.UserService;
import com.pw.common.constants.DbCollection;
import com.pw.common.util.AuthIDUtils;
import com.pw.common.util.IpAddressUtil;
import com.pw.common.util.MD5Util;
import com.pw.common.vo.SessionInfo;
import com.pw.common.web.controller.BaseController;
import com.pw.common.web.vo.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class LoginController extends BaseController {

//	@Autowired
//	ILogService dbLog;

	@Autowired
	UserService userService;

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletResponse response, HttpServletRequest request, String userId,
						String password) {

		DataDto dto = new DataDto();

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userId",userId);
		paramMap.put("userPassWord", MD5Util.MD5(password));

		if (userService.checkLoginUser(paramMap)) {
			dto.setCode(10000);
			dto.setMessage("成功");

			Short LogType = 0;
			String message = "登录成功";
			//TODO ip获取带完善
			String ipAddress = IpAddressUtil.getIdAddr(request);
//			dbLog.doBizLog(LogType, message, userId, ipAddress);

			SessionInfo si = new SessionInfo();
			si.setUserId(userId);
			String authId = AuthIDUtils.encrypt(si);
			si.setAuthId(authId);
			
			DbCollection.cacheMap.put(userId, si);
			
			List<String> authIdList = new ArrayList<>(); 
			authIdList.add(authId);
			
			dto.setData(authIdList);
			
		} else {
			dto.setCode(20000);
			dto.setMessage("失败");
		}

		String result = JSON.toJSONString(dto);

		return result;
	}
}