	package com.groupware.service;
	
	import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.repository.TodolistDAO;
import com.groupware.vo.Todolist;
	
	@Service
	public class TodolistService {
		@Autowired
		public TodolistDAO tdDao;
		
		private Todolist vo;
		
		public ArrayList<Todolist> getTodolist() throws SQLException{
			System.out.println("------------service----------");
			ArrayList<Todolist> all= tdDao.getTodolistAll();	
			return all;
		}
	
	
		public boolean insert(Todolist tdl) {
			
			return tdDao.insertTodolist(tdl);
		}
	
	
		public boolean delete(int num) {
			
			return tdDao.deleteTodolist(num);
		}
	
	
		public ArrayList<Todolist> getTodolistOne(int employeeNo) {
			
			return tdDao.getTodolistOne(employeeNo);
		}
		
	
	}
