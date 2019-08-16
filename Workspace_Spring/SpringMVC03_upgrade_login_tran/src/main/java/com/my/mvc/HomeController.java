package com.my.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.my.mvc.dto.CustomerDto;
import com.my.mvc.model.biz.CustomerBiz;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CustomerBiz biz;

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		logger.info("<<<list>>>");
		
		model.addAttribute("list", biz.selectList());
		
		return "list";
	}
	
	@RequestMapping("/registform.do")
	public String registform() {
		logger.info("<<<registform>>>");
		
		return "registform";
	}
	
	@RequestMapping("/regist_res.do")
	public String regist_res(@ModelAttribute CustomerDto dto, Model model) {
		logger.info("<<<regist_res>>>");
		
		int res = biz.insert(dto);
		
		if (res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getId()));
			return "selectOne";			
		} else {
			System.out.println("회원가입 실패");
			return "redirect:registform.do";
		}
 
	}
	
	@RequestMapping("/selectOne.do")
	public String selectOne(Model model, String id) {
		logger.info("<<<selectOne>>>");
		
		model.addAttribute("dto", biz.selectOne(id));
		
		return "selectOne";
	}
	
	@RequestMapping("/updateform.do")
	public String updateform(Model model, String id) {
		logger.info("<<<updateform>>>");
		
		model.addAttribute("dto", biz.selectOne(id));
		
		return "updateform";
	}
	
	@RequestMapping("/update_res.do")
	public String update_res(@ModelAttribute CustomerDto dto, Model model) {
		logger.info("<<<update_res>>>");
		
		int res = biz.update(dto);
		
		if (res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getId()));
			return "selectOne";
		} else {
			model.addAttribute("dto", biz.selectOne(dto.getId()));
			return "updateform";
		}
	}
	
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) {
		logger.info("<<<delete>>>");
		
		int res = biz.delete(id);
		
		if (res > 0) {
			return "redirect:list.do";
		} else {
			model.addAttribute("dto", biz.selectOne(id));
			return "selectOne";
		}
	}
	
	@RequestMapping("/loginform.do")
	public String loginform() {
		
		return "login";
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public Map<String, Boolean> login(String id, String pw, HttpSession session) {
		
		/*
		 * @ResponseBody : java 객체를 response객체에 binding(묶어) 해준다.
		 * 					객체 값을 그대로 리턴해준다.
		 * 					내가 원하는 값을 넘기고 싶을때 사용하면 됨.
		 * @RequestBody : request객체로 넘어오는 데이터를 java 객체로 만들어줌
		 */
		CustomerDto dto = biz.login(id, pw);
		boolean loginChk = false;
		
		if(dto != null) {
			session.setAttribute("login", dto);
			loginChk = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("loginChk", loginChk);
				
		return map;
	}
	
	@RequestMapping("/test.do")
	public String test() {
		
		biz.test();
		return "redirect:list.do";
	}
}
