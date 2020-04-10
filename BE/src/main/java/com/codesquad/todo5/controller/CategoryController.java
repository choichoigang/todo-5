package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.CategoryItem;
import com.codesquad.todo5.domain.TaskItem;
import com.codesquad.todo5.domain.UserItem;
import com.codesquad.todo5.dto.TaskItemDto;
import com.codesquad.todo5.dto.CategoryWithTasksDto;
import com.codesquad.todo5.response.ApiResponse;
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
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/category/{num}/all")
  public ResponseEntity<ApiResponse> showAllTaskItemsByCategoryNum(@PathVariable int num) {
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/category/add")
  public ResponseEntity<ApiResponse> addCategoryItem() {
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/category/{num}/delete")
  public ResponseEntity<ApiResponse> deleteCategoryItem(@PathVariable int num) {
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}