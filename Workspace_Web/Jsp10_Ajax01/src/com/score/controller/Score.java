package com.score.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/calscore")
public class Score extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		int sum = kor + eng + math;
		double avg = (double)sum/3;
		String grade;
		switch ((int)avg/10) {
		case 10:
		case 9:
			grade = "A";			
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		
		System.out.println(name + ", " + kor + ", " + eng + ", " + math + ", " + sum + ", " + avg + ", " + grade);
		
		// json 형식으로 리턴하기
		// json_simple.jar
		JSONObject obj = new JSONObject();
		obj.put("name", name); // 내부적으로 해쉬맵 형태로 만들어져 있음. HashMap<key, value>
		obj.put("sum", sum); //그리고 내부적으로 정렬되어 있지 않아서 출력하면 뒤죽박죽으로 나온다.
		obj.put("avg", avg);
		obj.put("grade", grade);
		
		out.println(obj.toJSONString()); // obj를 toJSONString() 으로 받아온다.
		// obj.get("name") 처럼 쓰면 key값에 맞는 value를 리턴해준다.
		
		System.out.println("servlet에서 보내는 데이터 : " + obj.toJSONString());
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		doGet(request, response);
	}

}
