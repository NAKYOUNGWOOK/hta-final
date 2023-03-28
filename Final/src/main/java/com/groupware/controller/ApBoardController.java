package com.groupware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupware.entity.Approval;
import com.groupware.repository.Apinterface;

import lombok.extern.slf4j.Slf4j;

@Controller
public class ApBoardController {
	
	@Autowired
	public Apinterface approvalRepository;
	
	@GetMapping("/approval")
	public <Approval> String getApboard(Model model) {
		List<com.groupware.entity.Approval> approval = approvalRepository.findAll();
		model.addAttribute(approval);
		return "webapp/approval";
	}
	
	@GetMapping("/approval/new")
	public String newApproval(Model model) {
		model.addAttribute("approval", new Approval());
		return "webapp/approval";
	}
	
	@PostMapping("/approval")
	public String createApproval(@ModelAttribute Approval approval) {
		approvalRepository.save(approval);
		return "redirect:/approval";
	}
	
	//수정, 삭제 기능 추가 해야함
}
