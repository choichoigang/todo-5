package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.TaskItem;
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
  public ResponseEntity<ApiResponse> showCard(@PathVariable int num) {
    logger.debug("Number of a task: {} ", num);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    TaskItem taskItem = TaskItem.create("github 공부하기", "호눅스 짱짱맨이에요.", "crongro", 1);
    taskItem.setId(1L);
    response.setData(taskItem);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/task/{num}/edit")
  public ResponseEntity<ApiResponse> editCard(@PathVariable int num) {
    logger.debug("Number of a task: {} ", num);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/task/{num}/delete")
  public ResponseEntity<ApiResponse> deleteCard(@PathVariable int num) {
    logger.debug("Number of a task: {} ", num);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  //handling with newly created card
  @GetMapping("/task/add")
  public ResponseEntity<ApiResponse> addCard() {
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
