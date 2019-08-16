package com.spr.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spr.mvc.model.biz.MyMVCBiz;
import com.spr.mvc.model.dto.MyMVCDto;

@Controller
public class SprController {

	@Autowired //선언 후 값을 넣어주기 위함.
	private MyMVCBiz biz;
	
	@RequestMapping("/list.spr")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "boardlist";
	}
	
	@RequestMapping("/selectOne.spr")
	public String selectOne(@RequestParam("seq") int seq, Model model) {
		
		model.addAttribute("dto", biz.selectOne(seq));
		
		return "selectOne";
	}
	
	@RequestMapping("/insert.spr")
	public void insert() {
		
	}
	
	@RequestMapping("/insert_res.spr")
	public String insert_res(@ModelAttribute MyMVCDto dto) {
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			return "redirect:list.spr";	
		} else {
			System.out.println("삽입 실패");
			return "redirect:insert.spr";
		}
	}
	
	@RequestMapping("/updateform.spr")
	public String updateform(@ModelAttribute MyMVCDto dto, Model model) {
		
		model.addAttribute("dto", biz.selectOne(dto.getSeq()));
		
		return "update_res";
	}
	
	@RequestMapping("/update_res.spr")
	public String update_res(@ModelAttribute MyMVCDto dto, Model model) {
		
		int res = biz.update(dto);
		
		if (res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getSeq()));
			return "selectOne";
		} else {
			System.out.println("수정 실패");
			model.addAttribute("dto", biz.selectOne(dto.getSeq()));
			return "update_res";
		}
	}
	
	@RequestMapping("/delete.spr")
	public String delete(@ModelAttribute MyMVCDto dto, Model model) {
		
		int res = biz.delete(dto.getSeq());
		
		if (res > 0) {
			return "redirect:list.spr";
		} else {
			model.addAttribute("dto", biz.selectOne(dto.getSeq()));
			return "selectOne";
		}
	}

	@RequestMapping("/muldel.spr")
	public String muldel(int[] chk){

		int res = biz.muldel(chk);

		if (res > 0) {
			return "redirect:list.spr";
      	}else {
	        return "redirect:list.spr";
      	}
	}
}
