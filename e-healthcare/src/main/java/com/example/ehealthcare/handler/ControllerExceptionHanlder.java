package com.example.ehealthcare.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.ehealthcare.handler.ex.CustomApiException;
import com.example.ehealthcare.handler.ex.CustomException;
import com.example.ehealthcare.handler.ex.CustomValidationApiException;
import com.example.ehealthcare.handler.ex.CustomValidationException;
import com.example.ehealthcare.util.Script;
import com.example.ehealthcare.web.dto.CMRespDto;
// 오류 발새 시 낚아채서 응답하기
@RestController
@ControllerAdvice
public class ControllerExceptionHanlder {
 
	@ExceptionHandler(CustomValidationException.class)
	public String validationException(CustomValidationException e) {
		/* CMRespDto, Script 비교
		 1. 클라이언트에게 응답할 때는 Script 좋음.
		 2. Ajax통신 - CMRespDto
		 3. Android 통신 - CMRespDto
		 */
		if(e.getErrorMap() == null) {
			return Script.back(e.getMessage());
		}else {
			return Script.back(e.getErrorMap().toString());
		}
		
	}
	// 유효성 검사 실패시 처리방법 경우1) JS 형태로
	@ExceptionHandler(CustomException.class)
	public String exception(CustomException e) {

		return Script.back(e.getMessage());
	}

	// 유효성 검사 실패시 처리방법 경우2) ? = CMRespDto
	@ExceptionHandler(CustomValidationApiException.class)
	public ResponseEntity<?> validationApiException(CustomValidationApiException e) {
		return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomApiException.class)
	public ResponseEntity<?> apiException(CustomApiException e) {
		return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST);
	}
}
