package com.example.demo.Exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Dto.ResponseDto;

import lombok.extern.slf4j.Slf4j;

/**
 * @ControllerAdvice which will intercept all the controllers and look for the exceptions thrown.
 */
@ControllerAdvice
@Slf4j
public class EmployeePayrollHandlerException {
	/**
	 * To handle Validation Errors create @ExceptionHandler method for MethodArgumentNotValidException class is defined.
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDto responseDTO = new ResponseDto("Exception while processing REST Request",errMsg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	 @ExceptionHandler(EmployeePayrollException.class)
	    public ResponseEntity<ResponseDto> handleEmployeePayrollException(EmployeePayrollException exception){
	        ResponseDto responseDTO = new ResponseDto("Exception while processing REST Request", exception.getMessage());
	        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	    }
	 /**
	  * Exception Handler for Incorrect Date Format
	  */
	 private static  final String message = "Exception while Prosessing REST Request";
	    @ExceptionHandler(HttpMessageNotReadableException.class)
	    public ResponseEntity<ResponseDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
	        log.error("Invalid Date Format",exception);
	        ResponseDto responseDTO = new ResponseDto(message,"Should have date in the Format of dd MMM yyyy");
	        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.BAD_REQUEST);
	    }

}
