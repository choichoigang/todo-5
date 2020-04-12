package com.codesquad.todo5.exception;

import com.codesquad.todo5.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ApiResponse handleError(ResourceNotFoundException exception) {
    return exception.returnErrorMessage();
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ApiResponse handleUserNotFoundException(UserNotFoundException exception) { return exception.returnErrorMessage(); }

  @org.springframework.web.bind.annotation.ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ApiResponse handleInvalidModificationError(InvalidModificationException exception) { return exception.returnErrorMessage(); }
}
