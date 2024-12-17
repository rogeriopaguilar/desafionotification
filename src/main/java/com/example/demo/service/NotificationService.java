package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dominio.Notification;
import com.example.demo.dto.NotificationDTO;
import com.example.demo.repository.NotificationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationService {

	private NotificationRepository notificationRepository;
	
	public List<Notification> findAllNotifications(){
		return notificationRepository.findAll();
	}
	
	public Notification createNotification(NotificationDTO dto) {
		
		Notification notification = new Notification();
		notification.setCustomerId(dto.getCustomerId());
		notification.setDataHoraEnvio(dto.getDataHoraEnvio());
		notification.setMensagem(dto.getMensagem());
		
		return notificationRepository.save(notification);
	}
}
