package com.mvc.my;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.my.model.biz.MyMVCBiz;
import com.mvc.my.model.dto.MyMVCDto;

@Controller
public class MyMVCController {

	@Autowired
	private MyMVCBiz biz;
	
	// get 방식으로 들어왔을 때만 boardlist.do를 맵핑해준다.
	// post 방식으로 들어오면 에러뜬다.
	// 둘다 해주려면 method = {RequestMethod.GET, RequestMethod.POST}
	@RequestMapping(value = "/boardlist.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "boardlist";
	}
	
	// void로 mapping만 해두면 해당 url로 이동한다.
	@RequestMapping("/insert.do")
	public void insert() {
		
	}
	
	@RequestMapping("/insert_res.do")
	public String insert_res(@ModelAttribute MyMVCDto dto, Model model) {
		// writer, title, content의 setter를 가지고 있는 dto를 파라미터로 써두면
		// 알아서 값이 들어감.
		
		int res = biz.insert(dto);
		
		if (res > 0) {
			return "redirect:boardlist.do";
		} else {
			return "redirect:insert.do";
		}
	}
	
	@RequestMapping("selectOne.do") //MyMVCDto 는 command 객체이다!
	public String selectOne(@ModelAttribute MyMVCDto dto, Model model) {
		
		model.addAttribute("dto", biz.selectOne(dto.getSeq()));
		
		return "selectOne";
	}
	
	@RequestMapping("updateform.do")
	public String updateform(@ModelAttribute MyMVCDto dto, Model model) {
		
		model.addAttribute("dto", biz.selectOne(dto.getSeq()));
		
		return "update_res";
	}
	
	@RequestMapping("update_res.do")
	public String update_res(@ModelAttribute MyMVCDto dto, Model model) {
		
		int res = biz.update(dto);
		
		if(res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getSeq()));
			return "selectOne";			
		} else {
			model.addAttribute("dto", biz.selectOne(dto.getSeq()));
			return "update_res";
		}
	}
	
	@RequestMapping("delete.do")
	public String delete(@ModelAttribute MyMVCDto dto, Model model) {
		
		int res = biz.delete(dto.getSeq());
		
		if (res > 0) {
			return "redirect:boardlist.do";
		} else {
			model.addAttribute("dto", biz.selectOne(dto.getSeq()));
			return "redirect:selectOne.do";
		}
		
	}
	
}
