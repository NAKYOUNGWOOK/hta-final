package com.groupware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.repository.EmpRepository;

@Service
public class EmpService {
	@Autowired
	private EmpRepository empRepository;

}
