package com.demo.dto;

import lombok.Data;

@Data
public class NewsDto {

	private String id;

	private String title;

	private String fileLink;

	private String shortDescript;

	private Long publisTime;
}
