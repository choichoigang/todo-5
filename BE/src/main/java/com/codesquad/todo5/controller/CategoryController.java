package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.CategoryItem;
import com.codesquad.todo5.domain.TaskItem;
import com.codesquad.todo5.domain.UserItem;
import com.codesquad.todo5.dto.CategoryItemDto;
import com.codesquad.todo5.dto.TaskItemDto;
import com.codesquad.todo5.utils.ApiResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class CategoryController {

  private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

  @GetMapping("/category/all")
  public ResponseEntity<ApiResponse> showAllCategoryItem() {
    CategoryItem todo = CategoryItem.create("todo");
    todo.setId(1L);
    CategoryItem doing = CategoryItem.create("doing");
    doing.setId(2L);
    CategoryItem done = CategoryItem.create("done");
    done.setId(3L);

    CategoryItemDto todoDto = new CategoryItemDto(todo);
    CategoryItemDto doingDto = new CategoryItemDto(doing);
    CategoryItemDto doneDto = new CategoryItemDto(done);

    List<CategoryItemDto> taskItemDtoList = new ArrayList<>();
    taskItemDtoList.add(todoDto);
    taskItemDtoList.add(doingDto);
    taskItemDtoList.add(doneDto);

    ApiResponse response = new ApiResponse();
    response.setData(taskItemDtoList);
    response.setStatus(true);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/category/{num}/all")
  public ResponseEntity<ApiResponse> showAllTaskItemsByCategoryNum(@PathVariable int num) {
    logger.debug("Number of category: {}", num);
    //basic setting
    UserItem testUser = UserItem.create("crongro");
    CategoryItem todo = CategoryItem.create("오늘의 할 일");
    TaskItem taskItem = TaskItem.create("github 공부하기", "호눅스 짱짱맨이에요.", testUser.getUserName(), 1);
    TaskItem taskItem2 = TaskItem.create("swift 공부하기", "JK 짱짱맨이에요.", testUser.getUserName(), 2);
    TaskItem taskItem3 = TaskItem.create("java 공부하기", "pobi 짱짱맨이에요.", testUser.getUserName(), 3);

    List<TaskItem> todoItemList = new ArrayList<>();
    todoItemList.add(taskItem);
    todoItemList.add(taskItem2);
    todoItemList.add(taskItem3);
    todo.setTask(todoItemList);

    //dto setting
    List<TaskItemDto> taskItemDtoList =
        todo.getTask().stream().map(taskitem -> new TaskItemDto(taskitem))
            .collect(Collectors.toList());

    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    response.setData(taskItemDtoList);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/category/{num}/add")
  public ResponseEntity<ApiResponse> addCategoryItem(@PathVariable int num) {
    logger.debug("Number of category: {}", num);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/category/{num}/delete")
  public ResponseEntity<ApiResponse> deleteCategoryItem(@PathVariable int num) {
    logger.debug("Number of category: {}", num);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}