package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dominio.Notification;
import com.example.demo.dto.NotificationDTO;
import com.example.demo.service.NotificationService;

@RestController
@RequestMapping("/api/v1/")
public class NotificationController {
	
	private NotificationService notificationService;
	
	
	
	public NotificationController(NotificationService notificationService) {
		super();
		this.notificationService = notificationService;
	}



	@GetMapping(path="/findAllNotifications")
	public ResponseEntity<List<NotificationDTO>> findAllNotifications(){
		return ResponseEntity.ok(
				notificationService.findAllNotifications().stream()
					.map(n -> new NotificationDTO(n.getId(),n.getCustomerId(),n.getMensagem(),n.getDataHoraEnvio())).toList());
	}
	
	
	@PostMapping(path="/createNotification")
	public ResponseEntity<Void> createNotification(@RequestBody NotificationDTO notificationDTO){
	    notificationService.createNotification(notificationDTO);
	    return ResponseEntity.accepted().build();
	}
	
}
