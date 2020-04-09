package com.codesquad.todo5.controller;

import com.codesquad.todo5.utils.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {

  private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

  //handling with existing card
  @GetMapping("/task/{num}/show")
  public ResponseEntity<ApiResponse> showCard(@PathVariable int tasknum) {
    logger.debug("Number of a task: {} ", tasknum);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/task/{num}/edit")
  public ResponseEntity<ApiResponse> editCard(@PathVariable int tasknum) {
    logger.debug("Number of a task: {} ", tasknum);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/task/{num}/delete")
  public ResponseEntity<ApiResponse> deleteCard(@PathVariable int tasknum) {
    logger.debug("Number of a task: {} ", tasknum);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  //handling with newly created card
  @GetMapping("/task/{num}/add")
  public ResponseEntity<ApiResponse> addCard(@PathVariable int tasknum) {
    logger.debug("Number of a task: {} ", tasknum);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
