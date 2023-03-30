package com.groupware.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	List<Message> findAllByReceiver(Message message);
	List<Message> findAllBySender(Message message);
}
