package com.base.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResDto<T> {
	private int status;
	private List<ErrorDto> errors;
	private T result;

	public BaseResDto(int status, ErrorDto error) {
		this.status = status;
		errors = new ArrayList<>();
		errors.add(error);
	}

	public BaseResDto(int status, T result) {
		this.status = status;
		this.result = result;
		this.errors = new ArrayList<>();
	}

	public static <T> BaseResDto<T> ok(T result) {
		return new BaseResDto<>(HttpStatus.OK.value(), result);
	}

	public static BaseResDto badRequest(ErrorDto error) {
		return new BaseResDto(HttpStatus.BAD_REQUEST.value(), error);
	}

	public static BaseResDto serverError(ErrorDto error) {
		return new BaseResDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
	}
}
