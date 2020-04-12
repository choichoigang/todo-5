package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.category.Category;
import com.codesquad.todo5.dto.category.CategoryDeleteRequest;
import com.codesquad.todo5.dto.category.CategoryNameEditRequestDto;
import com.codesquad.todo5.response.ApiResponse;
import com.codesquad.todo5.service.TodoService;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
@RequestMapping("/api")
public class CategoryController {
  private final TodoService todoService;

  public CategoryController(TodoService todoService) {
    this.todoService = todoService;
  }

  private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

  @GetMapping("/category/all")
  public ResponseEntity<ApiResponse> showAllCategoryItem() {
    ApiResponse response = new ApiResponse();
    response.setData(todoService.findAllTasks());
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/category/add")
  public ResponseEntity<ApiResponse> addCategoryItem() {
    Category addCategory = todoService.addCategory();
    ApiResponse response = new ApiResponse();
    response.setData(addCategory);
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/category/{id}/edit")
  public ResponseEntity<ApiResponse> editCategoryItem(@PathVariable Long id, @RequestBody
      CategoryNameEditRequestDto dto) {
    Category editedCategory = todoService.editCategory(id, dto);
    ApiResponse response = new ApiResponse();
    response.setData(editedCategory);
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
  @PostMapping("/category/{id}/delete")
  public ResponseEntity<ApiResponse> deleteCategoryItem(@PathVariable Long id, @RequestBody
      CategoryDeleteRequest dto) {
    Category deleteCategory = todoService.deleteCategory(id, dto);
    ApiResponse response = new ApiResponse();
    response.setData(deleteCategory);
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}