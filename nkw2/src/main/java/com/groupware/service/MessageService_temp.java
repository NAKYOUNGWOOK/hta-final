package com.groupware.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupware.dto.MessageDto;
import com.groupware.entity.Message;
import com.groupware.entity.Employee;
import com.groupware.repository.EmployeeRepository;
import com.groupware.repository.MessageRepository;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class MessageService {
	private final MessageRepository messageRepository;
	private final EmployeeRepository employeeRepository;
	
	@Transactional
	public MessageDto write(MessageDto messageDto) {
		Employee receiver = EmployeeRepository.findByName(messageDto.getReceiverName());
		Employee sender = EmployeeRepository.findByName(messageDto.getSenderName());
		
		Message message = new Message();
		message.setReceiver(receiver);
		message.setSender(sender);
		
		message.setTitle(messageDto.getTitle());
		message.setContent(messageDto.getContent());
		message.setDeleteByReceiver(false);
		message.setDeleteBySender(false);
		messageRepository.save(message);
		
		return MessageDto.toDto(message);
	}
	
	
	@Transactional(readOnly = true)
	public List<MessageDto> receivedMessages(Employee Employee) {
		//받은 편지함 불러오기
		//한 명의 유저가 받은 모든 메시지
		List<Message> messages = messageRepository.findAllByReceiver(user);
		List<MessageDto> messageDtos = new ArrayList<>();
		
		for(Message message : messages) {
			//message에서 받은 편지함에서 미삭제시 보낼 때 추가하여 발송
			if(!message.isDeletedByReceiver()) {
				messageDtos.add(MessageDto.toDto(message));
			}
		}
		return messageDtos;
	}
	
	
	//받은 메시지 삭제
	@Transactional
	public Object deleteMessageByReceiver(int employeeNo, Employee employee) {
		Message message = messageRepository.findByEmployeeNo(employeeNo).orElseThrow(() -> {
			return new IllegalArgumentException("메시지를 찾을 수 없습니다.");
		});
		
		if(employee == message.getSender()) {
			message.deleteByReceiver(); //받은 사람에게 메시지 삭제
			if(message.isDeleted()) {
				//받은 사람과 보낸 사람 모두 삭제 시 DB에서 삭제
				messageRepository.delete(message);
				return "양쪽 모두 삭제";
			}
			return "한쪽만 삭제";
		}else {
			return new IllegalArgumentException("유저 정보가 일치하지 않습니다.");
		}
	}
	
	
	@Transactional(readOnly = true)
	public List<MessageDto> sentMessage(Employee employee) {
		//보낸 편지함 불러오기
		//한 명의 유저가 받은 모든 메시지
		List<Message> messages = messageRepository.findAllBySender(user);
		List<MessageDto> messageDtos = new ArrayList<>();
		
		for(Message message : messages) {
			//message에서 받은 편지함에서 미삭제 시 보낼 때 추가로 발송
			if(!message.isDeletedBySender()) {
				messageDtos.add(MessageDto.toDto(message));
			}
		}
		return messageDtos;
	}
	
	
	//보낸 메시지 삭제
	@Transactional
	public Object deleteMessageBySender(int employeeNo, Employee employee) {
		Message message = messageRepository.findByEmployeeNo(employeeNo).orElseThrow(() -> {
			return new IllegalArgumentException("메시지를 찾을 수 없습니다.");
		});
		
		if(employee == message.getSender()) {
			message.deleteBySender(); //받은 사람에게 메시지 삭제
			if(message.isDeleted()) {
				//받은 사람과 보낸 사람 모두 삭제 시 DB에서 삭제
				messageRepository.delete(message);
				return "양쪽 모두 삭제";
			}
			return "한쪽만 삭제";
		}else {
			return new IllegalArgumentException("유저 정보가 일치하지 않습니다.");
		}
	}
}
