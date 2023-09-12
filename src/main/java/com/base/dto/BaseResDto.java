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

	public BaseResDto(int status, T result) {
		this.status = status;
		this.result = result;
	}

	public BaseResDto(int status, List<ErrorDto> errors) {
		this.status = status;
		this.errors = errors;
	}

	public static <T> BaseResDto<T> build(HttpStatus status, T result) {
		return new BaseResDto<>(status.value(), result);
	};

	public static <T> BaseResDto<T> ok(T result) {
		return new BaseResDto<>(HttpStatus.OK.value(), result);
	};

	public static <T> BaseResDto<T> error(HttpStatus status, ErrorDto errorDto) {
		List<ErrorDto> errors = new ArrayList<>();
		errors.add(errorDto);
		return new BaseResDto<>(status.value(), errors);
	};
}
