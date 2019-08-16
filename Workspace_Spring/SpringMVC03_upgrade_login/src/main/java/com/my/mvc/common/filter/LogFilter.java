package com.my.mvc.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

	// clazz : 우리가 적용시켜줄 클래스
	// String : 적용시켜줄 이름
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	// 필터가 어떻게 동작할 건지 작성.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// FilterChain : cilent와 server 사이에서 필터를 거칠 때 필터를 거치기 전과 후를 묶어주는 역할
		HttpServletRequest req = (HttpServletRequest)request;
		
		// StringUtils : null 들어가도 NullPointException을 발생시키지 않는다.
		// null이 들어가면 "" 로 반환함.
		String RemoteAddr = StringUtils.defaultString(req.getRemoteAddr());
		String uri = StringUtils.defaultString(req.getRequestURI());
		String url = StringUtils.defaultString(req.getRequestURL().toString());
		String queryString = StringUtils.defaultString(req.getQueryString());
		String referer = StringUtils.defaultString(req.getHeader("referer"));
		String agent = StringUtils.defaultString(req.getHeader("User-Agent"));
		
		StringBuffer result = new StringBuffer();
		result.append(" | ")
		// 요청을 보낸 클라이언트 또는 마지막 프록시의 IP(인터넷 프로토콜) 주소를 반환함.
		// IPv6 형태로 리턴된 localhost임.
		// Run -> Run Configurations -> Arguments 에 -Djava.net.preferIPv4Stack=true 내용 넣어주면 됨.
			  .append(RemoteAddr+"ㅋ") // 0:0:0:0:0:0:0:1
		// 요청된 uri 리턴. (쿼리스트링 빼고 루트에서부터 리턴)
			  .append(uri+"ㅋ") //  /mvc_up/list.do
			  .append(" (")
		// 요청된 url 리턴 (localhost:8787 서버의 mvc_up 안에 있는 list.do, 쿼리스트링 빼고 리턴)
			  .append(url+"ㅋ") // http://localhost:8787/mvc_up/list.do
		// 쿼리 스트링 리턴
			  .append("?"+queryString+"ㅋ") // null이면 "", ?id=admin
			  .append(") ")
		// 접속경로 (요청 전 페이지의 url, 쿼리스트링 포함!!)
			  .append(referer+"ㅋ") //  http://localhost:8787/mvc_up/
			  .append(" | ")
		// 브라우저 정보 가져오기
			  .append(agent+"ㅋ"); // Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36
		logger.info("LOG FILTER " + result.toString());
		
		// 값을 변조한 경우 req로 파라미터를 넣어주고
		// 그게 아닐 경우 request로 넣기
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {

	}

}
