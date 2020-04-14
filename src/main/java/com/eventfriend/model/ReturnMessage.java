package com.eventfriend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReturnMessage {
	private String code;
	private String message;
}
