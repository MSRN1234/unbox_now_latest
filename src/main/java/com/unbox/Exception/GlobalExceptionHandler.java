package com.unbox.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
  @RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>>handleMethodArgsNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String, Object> resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String message = error.getDefaultMessage();
			
			resp.put("msg","Failed");
			resp.put("Data", null);
			resp.put("Error", message);
			resp.put("status",false);
		});
		
		return new ResponseEntity<Map<String,Object>>(resp,HttpStatus.BAD_REQUEST);
	}
}
