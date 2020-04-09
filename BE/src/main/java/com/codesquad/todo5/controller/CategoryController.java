package com.codesquad.todo5.controller;

import com.codesquad.todo5.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController {

  @GetMapping("/category/all")
  public ResponseEntity<ApiResponse> showAllCategoryItem() {
    return null;
  }

  @GetMapping("/{categorynum}/all")
  public ResponseEntity<ApiResponse> showAllTaskItemsByCategoryNum(@PathVariable int categorynum) {
    return null;
  }

  @GetMapping("/{categorynum}/add")
  public ResponseEntity<ApiResponse> addCategoryItem(@PathVariable int categorynum) {
    return null;
  }

  @GetMapping("/{categorynum}/delete")
  public ResponseEntity<ApiResponse> deleteCategoryItem(@PathVariable int categorynum) {
    return null;
  }
}