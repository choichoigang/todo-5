package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.category.Category;
import com.codesquad.todo5.dto.category.CategoryDeleteRequestDto;
import com.codesquad.todo5.dto.category.CategoryNameEditRequestDto;
import com.codesquad.todo5.dto.category.CategoryWithTasksDto;
import com.codesquad.todo5.response.ApiResponse;
import com.codesquad.todo5.service.TodoService;
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
public class CategoryController {
  private final TodoService todoService;

  public CategoryController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/category/all")
  public ResponseEntity<ApiResponse> showAllCategoryItem() {
    ApiResponse response = new ApiResponse();
    response.setData(todoService.findAllTasks());
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/category/add")
  public ResponseEntity<ApiResponse> addCategoryItem() {
    Category addCategory = todoService.addCategory();
    ApiResponse response = new ApiResponse();
    response.setData(addCategory);
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/category/{id}/all")
  public ResponseEntity<CategoryWithTasksDto> showSpecificCategory(@PathVariable Long id) {
    CategoryWithTasksDto categoryWithTasksDto = todoService.findCategory(id);
    //ApiResponse response = new ApiResponse();
    //response.setData(categoryWithTasksDto);
    //response.setStatus(true);
    return new ResponseEntity<>(categoryWithTasksDto, HttpStatus.OK);
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
      CategoryDeleteRequestDto dto) {
    Category deleteCategory = todoService.deleteCategory(id, dto);
    ApiResponse response = new ApiResponse();
    response.setData(deleteCategory);
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
