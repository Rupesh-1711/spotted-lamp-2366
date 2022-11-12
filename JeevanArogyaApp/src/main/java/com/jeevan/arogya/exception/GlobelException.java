package com.jeevan.arogya.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobelException {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetail> myMNVHandler(MethodArgumentNotValidException me) {
		
		MyErrorDetail err = new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetail> userException(UserException ue,WebRequest req) {
		
		MyErrorDetail err = new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ue.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetail> loginException(LoginException le, WebRequest req){

		MyErrorDetail err = new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(le.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> Exception(Exception e,WebRequest req) {
		
		MyErrorDetail err = new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(VaccinationCenterException.class)
	public ResponseEntity<MyErrorDetail> VaccinationCenterException(VaccinationCenterException vce, WebRequest req){
		
		MyErrorDetail err = new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(vce.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
}

