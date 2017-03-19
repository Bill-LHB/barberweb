package com.lhb.barber.control;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhb.barber.model.Member;
import com.lhb.barber.server.MemberServer;
@Controller
@RequestMapping("/member")
public class MemberAction {
	@Autowired
	private MemberServer memberServer;
	
	@RequestMapping(value="/operation",method=RequestMethod.POST)
	public String operation(String operation,Member member,Model model){
		String message="";			
		if("addmember".equals(operation)){
			if(!memberServer.addMember(member))				
				message="添加会员失败!";		
		}
		if("updatemember".equals(operation)){		
			if(!memberServer.updateMember(member))
				message="修改会员失败！";
		}	
		model.addAttribute("message", message);	
		return "redirect:/system/allmenmberMode.do";
	}
	/**
	 * 添加会员
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addmember")
	public String addMember(String operation,Member member,Model model){	
		model.addAttribute("operation", "addmember");		
		return "member/add_member";
	}
	
	/**
	 * 删除会员
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deletemember/{Member_id}")
	public String deleteMember(@PathVariable Integer Member_id,Model model){		
		Member member=memberServer.getMemberById(Member_id);
		memberServer.deleteMember(member);
		model.addAttribute("member", "");		
		return "redirect:/system/allmember.do";	
	}
	
	/**
	 * 更新会员
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updatemember/{Member_id}")
	public String updateMember(@PathVariable Integer Member_id,Model model){
		Member member=memberServer.getMemberById(Member_id);
		
		model.addAttribute("operation", "updatemember");
		model.addAttribute("member", member);		
		return "member/add_member";		
	}
	
	/**
	 * 所有会员
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allmember/{curPage}")
	public String  getAllModules(@PathVariable Integer curPage,String message,Model model){	
		if(message!=null && !message.equals("")){
			model.addAttribute("message", message);	
		}			
		List<Member> memberList=memberServer.getAllMember(curPage);	
		model.addAttribute("memberList", memberList);	
		return "member/list_member";		
	}
}
