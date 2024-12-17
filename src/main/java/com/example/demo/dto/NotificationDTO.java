package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
		private Long id;
		private String customerId;
		private String mensagem;
		private LocalDateTime dataHoraEnvio;
}
