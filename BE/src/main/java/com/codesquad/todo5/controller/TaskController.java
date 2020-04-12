package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.task.Task;
import com.codesquad.todo5.domain.task.TaskRepository;
import com.codesquad.todo5.domain.user.User;
import com.codesquad.todo5.dto.task.TaskCreateDto;
import com.codesquad.todo5.dto.task.TaskEditRequestDto;
import com.codesquad.todo5.response.ApiResponse;
import com.codesquad.todo5.service.TodoService;
import com.codesquad.todo5.service.UserService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {

  private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
  private final UserService userService;
  private final TodoService todoService;
  private final TaskRepository taskRepository;

  public TaskController(UserService userService, TodoService todoService, TaskRepository taskRepository) {
    this.userService = userService;
    this.todoService = todoService;
    this.taskRepository = taskRepository;
  }

  //handling with existing card
  @GetMapping("/task/{num}/show")
  public ResponseEntity<ApiResponse> showTask(@PathVariable int num) {
    //TODO 작업해야함: TaskService 참고
    ApiResponse response = new ApiResponse();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/task/{num}/edit")
  public ResponseEntity<ApiResponse> editTask(@PathVariable int num) {
    //TODO 작업해야함: TaskService 참고
    logger.debug("Number of a task: {} ", num);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/task/{id}/move")
  public ResponseEntity<ApiResponse> moveTask(@PathVariable Long id,
      @RequestBody TaskEditRequestDto dto) {
    taskRepository.updateTaskCategoryById(dto.getCategoryTo(), id);
    Task updatedTask = taskRepository.findTaskById(id);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    response.setData(updatedTask);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/task/{num}/delete")
  public ResponseEntity<ApiResponse> deleteCard(@PathVariable int num) {
    //TODO 작업해야함: TaskService 참고
    logger.debug("Number of a task: {} ", num);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  //handling with newly created card
  @GetMapping("/task/add")
  public ResponseEntity<ApiResponse> addCard() {
    //TODO 작업해야함: TaskService 참고
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
