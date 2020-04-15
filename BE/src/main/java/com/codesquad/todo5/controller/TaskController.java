package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.category.Category;
import com.codesquad.todo5.domain.task.Task;
import com.codesquad.todo5.domain.task.TaskRepository;
import com.codesquad.todo5.dto.task.TaskCreateRequestDto;
import com.codesquad.todo5.dto.task.TaskModifyRequestDto;
import com.codesquad.todo5.dto.task.TaskMoveRequestDto;
import com.codesquad.todo5.dto.task.TaskShowResponseDto;
import com.codesquad.todo5.exception.ResourceNotFoundException;
import com.codesquad.todo5.response.ApiResponse;
import com.codesquad.todo5.service.TodoService;
import com.codesquad.todo5.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  //handling with newly created card
  @PostMapping("/task/add")
  public ResponseEntity<ApiResponse> addTask(@RequestBody TaskCreateRequestDto dto) {
    //TODO 작업해야함: TaskService 참고
    Long lastInsertId = todoService.addTask(dto);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    response.setData(lastInsertId);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  //handling with existing card
  @GetMapping("/task/{id}/show")
  public ResponseEntity<ApiResponse> showTask(@PathVariable Long id) {
    //TODO 작업해야함: TaskService 참고
    TaskShowResponseDto taskShowResponseDto = todoService.showTask(id);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    response.setData(taskShowResponseDto);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/task/{id}/edit")
  public ResponseEntity<ApiResponse> editTask(@PathVariable Long id, @RequestBody TaskModifyRequestDto dto) {
    // DATA 업데이트시 값을 반환하기 때문에 반환된 값을 한번 더 검증 하도록 했는데, 한번 더 검증하는 과정이 꼭 필요한지는 모르겠다.
    todoService.editTask(id, dto).orElseThrow(ResourceNotFoundException::new);
    logger.debug("Number of a task: {} ", id);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/task/{id}/delete")
  public ResponseEntity<ApiResponse> deleteCard(@PathVariable Long id) {
    //TODO 작업해야함: TaskService 참고
    logger.debug("Number of a task: {} ", id);
    todoService.deleteTask(id);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/task/{id}/move")
  public ResponseEntity<ApiResponse> moveTask(@PathVariable Long id,
      @RequestBody TaskMoveRequestDto dto) {
    logger.debug("Dto : {} ", dto);
    //TODO: 카테고리가 존재하지 않는 인덱스 번호에 이동할 경우에도 true라고 반환되며 값 자체가 반환된다. 이는 UPDATE 쿼리에서 에러 처리를 제대로 반환하지 않는 문제에서 기인하는 것으로 추정된다.
    taskRepository.updateTaskCategoryById(dto.getCategoryTo(), dto.getPriority(), id);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}