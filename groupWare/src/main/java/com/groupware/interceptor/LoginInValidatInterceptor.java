package com.groupware.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class LoginInValidatInterceptor implements HandlerInterceptor{ 
	
	//preHandle() 메서드는  컨트롤러가 호출되기 전에 실행
	/* return이 true 인 경우 - 실제 handler 호출 / false인 경우 중지 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception{
		
		System.out.println("preHandle() 실행 시점 : 컨트롤러가 호출되기 전에 실행 --------");
		
		HttpSession session = req.getSession();
		
		//세션에 loginUser 존재할 경우 요청 로직 정상 실행
		if (session.getAttribute("loginUser") != null) {
			System.out.println("세션 데이터 존재 true 반환 및 요청 url로 정상 실행");
			return true;
		}else {
			System.out.println("세션 데이터 미존제 false 반환 및 login.html로 이동");
			System.out.println("loginUser가 null " + req.getContextPath() + "login?prev="+req.getServletPath());
			res.sendRedirect(req.getContextPath() + "login?prev="+req.getServletPath());
			return false;
		}
		
	}
}
