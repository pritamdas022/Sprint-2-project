package com.bms.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BookDTO {

	private int id;
	@NotNull
	private String bookName;
	@NotNull
	private String authorName;
	@NotNull
	@NotNull
	private int bookPrice;
}
