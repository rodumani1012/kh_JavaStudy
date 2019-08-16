package com.hello.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.HelloBiz;

@Controller
public class HelloController {

	@Autowired
	private HelloBiz biz;
	
	// TODO : 04.controller(hello.ho)
	@RequestMapping("/hello.ho")
	public String getHello(Model model) {
		
		// TODO : 05.biz.getHello();
		model.addAttribute("message", biz.getHello());
		// TODO : 09.model에 return값 담기
		
		return "/WEB-INF/views/hello.jsp";
	}
	
//	@RequestMapping("/bye.ho")
//	public String getBye(@RequestParam("name")String str, Model model) {
//		
//		model.addAttribute("message", str);
//		
//		return "/WEB-INF/views/bye.jsp";
//	}
	
	@RequestMapping("/bye.ho")
	public ModelAndView getBye(@RequestParam("name")String str) {
		// String name 파라미터에 자동으로 index.html에서 보내준 쿼리스트링을 받아냄.
		// String name == request.getParameter("name")
		// String str 처럼 이름이 다른 변수로 쓸 경우 name파라미터를 받아오려면
		// @RequestParam("name")이라고 명시적으로 써줘야함.
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message", "Bye, "+str);
		
		return mav;
	}
}

/*
	@RequestMapping
	- url을 class 또는 method와 mapping시켜주는 역할을 한다.
	- annotation을 쓰지 않을 때 지정했던 Controller 등록을 위한
		url bean 설정을 생략할 수 있다.
	
	@RequestParam
	- key=value 형태로 넘어오는 queryString을 mapping된 
		메서드의 파라미터로 지정해 준다.
	- 주로 get방식으로 들어오는 request에서 사용한다.
	
	@ModelAttribute
	- ModelAttribute annotation은 화면의 form 속성에서 넘어온 model을
		mapping된 method의 파라미터로 지정해준다.
	- 주로 post 타입으로 넘어오는 form 속성의 model 값을 받아올 때 사용한다.
		(get/post 모두 사용 가능)
	
	@SessionAttribute
	- session에서 model의 정보를 유지하고 싶을 경우 사용한다.
*/
