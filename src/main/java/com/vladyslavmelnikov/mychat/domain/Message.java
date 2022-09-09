package com.vladyslavmelnikov.mychat.domain;

import lombok.Data;


@Data
public class Message {

	private String content;
	private User user;


}
