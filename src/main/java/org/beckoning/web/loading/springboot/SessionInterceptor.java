package org.beckoning.web.loading.springboot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.beckoning.web.loading.constant.Constants;
import org.beckoning.web.loading.util.SessionUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURL().toString();
		String path = request.getServletPath();
		if (!StringUtils.equals("/", path) && !StringUtils.contains(url, "login")
				&& !StringUtils.contains(url, "index")) {
			if (null == SessionUtil.getSessionAttribute(Constants.SESSION_USER_KEY)) {
				request.setAttribute("result", false);
				request.setAttribute("errorMsg", "<strong>登陆信息无效</strong>，请重新进行登陆。");
				String mainUrl = SessionUtil.getRealPath();
				response.sendRedirect(mainUrl);
				return false;
			}
		}
		return true;
	}
	
}
