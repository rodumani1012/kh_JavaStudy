package com.test01;

import java.net.URI;
import java.net.URISyntaxException;

public class URI01 {

	public static void main(String[] args) throws URISyntaxException {
		URI u = new URI("http://localhost:8787/Java19_URI_Web/res.jsp?tname=%EC%B5%9C%EC%A4%80%EC%97%B0&taddr=%EA%B2%BD%EA%B8%B0%EB%8F%84+%EC%88%98%EC%9B%90");
		
		System.out.println(u.getScheme()); //uri의 스키마
		System.out.println(u.getHost()); //호스트
		System.out.println(u.getPort()); //포트
		System.out.println(u.getPath()); //경로
		System.out.println(u.getQuery()); // QueryString은 어떻게 되는지
		
	}
}
