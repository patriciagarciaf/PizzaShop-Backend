// package com.example.demo.Exceptions;

// import org.springframework.http.HttpStatus;
// import org.springframework.validation.BindingResult;
// import org.springframework.validation.FieldError;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseStatus;


// //TODO: Mirar @RestControllerAdvice --> https://www.bezkoder.com/spring-boot-restcontrolleradvice/
// @ControllerAdvice
// public class APIExcepcionHandler {

// 	@ExceptionHandler(MethodArgumentNotValidException.class)
// 	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
// 	@ResponseBody
// 	public APIerror handleValidationError(MethodArgumentNotValidException notValid) {
// 		BindingResult bindingResult = notValid.getBindingResult();
// 		FieldError fieldError = bindingResult.getFieldError();
// 		String defaultMessage = fieldError.getDefaultMessage();
// 		return new APIerror(fieldError.toString(), defaultMessage);
// 		//return new APIerror("Validation error.", defaultMessage);
// 	}
// }

