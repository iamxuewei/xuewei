package com.xuewei.controller;

import javax.servlet.http.HttpServletRequest;
import com.xuewei.vo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseController {
	/**
	 * 获取request对象
	 * @return
	 */
	public HttpServletRequest getRequest(){
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取缓存中的用户对象
	 * @return
	 */
	protected User getThisUser(){
		return (User) getRequest().getSession().getAttribute(
				"user");
	}

}
