package com.bike.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import sun.tools.jar.resources.jar;

@WebServlet("/BikeController")
public class BikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		BikeDao dao = new BikeDao();
		
		String command = request.getParameter("command");
		
		if (command.equals("first")) {
			response.sendRedirect("bike01.jsp");
		} else if (command.equals("first_db")) {
			// db에 저장
			String[] bikeList = request.getParameterValues("bike");
			List<BikeDto> list = new ArrayList<BikeDto>();

			for(int i = 0; i < bikeList.length; i++) {
				BikeDto dto = new BikeDto();
				String[] bike = bikeList[i].split("/");
				dto.setAddr_gu(bike[0]);
				dto.setContent_id(Integer.parseInt(bike[1]));
				dto.setContent_nm(bike[2]);
				dto.setNew_addr(bike[3]);
				dto.setCradle_count(Integer.parseInt(bike[4]));
				dto.setLongitude(Double.parseDouble(bike[5]));
				dto.setLatitude(Double.parseDouble(bike[6]));
				
				list.add(dto);
			}
				int res = dao.insert(list);
				if(res>0) {
					PrintWriter out = response.getWriter();
					out.println("<script>alert('저장성공!');</script>");
				}
			// index로
				response.sendRedirect("index.jsp");
		} else if (command.equals("second")) {
			response.sendRedirect("bike02.jsp");
		} else if (command.equals("second_db")) {
			String obj = request.getParameter("obj"); // bike02.js에서 JSON.stringify()를 통해 String으로 변환된 값을 가져옴
//			System.out.println(obj);
			
			JsonParser parser = new JsonParser(); // jsonObject를 상속받음. json을 json요소의 트리 형태로 분석한다.
			JsonElement element = parser.parse(obj); // bike02.js에서 JSON.stringify()을 통해 String으로 변환된 obj값을 
														// 트리형태로 분석. (다시 JSON 객체로 변환)
			
			List<BikeDto> list = new ArrayList<BikeDto>();
			
			for (int i = 0; i < element.getAsJsonObject().get("DATA").getAsJsonArray().size(); i++) {
				/*
				 1. JsonObject로 변환
			  		element.getAsJsonObject()
				 2. DATA라는 key를 가지고 value를 리턴
				 	element.getAsJsonObject().get("DATA")
				 3. value를 JsonArray로 변환
				 	element.getAsJsonObject().get("DATA").getAsJsonArray()
				 4. JsonArray에서 i번지의 값들을 가져온다.
				 	element.getAsJsonObject().get("DATA").getAsJsonArray().get(i)
				 5. JsonObject로 변환
				 	element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject()
				 6. JsonObject에서 key를 통해서 각각의 값을 꺼내온다.
				 	element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject().get("addr_gu")
				 7. Java에서 사용되는 type으로 변환
				 	String addr_gu = addr_gu_j.getAsString();
				 */
				JsonObject temp = element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject();
				
				JsonElement addr_gu_j = temp.get("addr_gu");
				JsonElement content_id_j = temp.get("content_id");
				JsonElement content_nm_j = temp.get("content_nm");
				JsonElement new_addr_j = temp.get("new_addr");
				JsonElement cradle_count_j = temp.get("cradle_count");
				JsonElement longtitude_j = temp.get("longitude");
				JsonElement latitude_j = temp.get("latitude");
				
				String addr_gu = addr_gu_j.getAsString(); // JsonElement를 String으로 가져옴
				int content_id = content_id_j.getAsInt();
				String content_nm = content_nm_j.getAsString();
				String new_addr = new_addr_j.getAsString();
				int cradle_count = cradle_count_j.getAsInt();
				double longitude = longtitude_j.getAsDouble();
				double latitude = latitude_j.getAsDouble();
				
				BikeDto dto = new BikeDto(addr_gu, content_id, content_nm, new_addr, cradle_count, longitude, latitude);
				
				list.add(dto);
				
				System.out.printf("%s %d %s %s %d %f %f \n",addr_gu, content_id,
						content_nm, new_addr, cradle_count, longitude, latitude);
			}
			
			dao.delete();
			
			int res = dao.insert(list);
			
			if(res == list.size()) {
				System.out.println("저장 성공");
			} else {
				System.out.println("저장 실패");
			}
			
			PrintWriter out = response.getWriter();
			out.print(res);
		}
	}

}
