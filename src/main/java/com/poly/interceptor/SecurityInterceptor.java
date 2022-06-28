package com.poly.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.poly.entity.Account;



@Service
public class SecurityInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)	throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			if(!((Account) session.getAttribute("user")).isAdmin()){
				response.sendRedirect(request.getContextPath() + "/");
				return false;
			} else {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath() + "/");
		return false;
	}
}
