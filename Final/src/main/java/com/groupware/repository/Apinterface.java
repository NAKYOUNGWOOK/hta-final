package com.groupware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.entity.Approval;

public class Apinterface {

	public interface ApBoardRepository extends JpaRepository<Approval, Long> {
		
	}

	public List<Approval> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Approval approval) {
		// TODO Auto-generated method stub
		
	}
}
