package com.example.demo.Exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Dto.ResponseDto;

/**
 * @ControllerAdvice which will intercept all the controllers and look for the exceptions thrown.
 */
@ControllerAdvice
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

}
