package com.codesquad.todo5.controller;

import com.codesquad.todo5.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {

  //handling with existing card
  @GetMapping("/{tasknum}/show")
  public ResponseEntity<ApiResponse> showCard(@PathVariable int tasknum) {
    return null;
  }

  @GetMapping("/{tasknum}/edit")
  public ResponseEntity<ApiResponse> editCard(@PathVariable int tasknum) {
    return null;
  }

  @GetMapping("/{tasknum}/delete")
  public ResponseEntity<ApiResponse> deleteCard(@PathVariable int tasknum) {
    return null;
  }

  //handling with newly created card
  @GetMapping("/{tasknum}/add")
  public ResponseEntity<ApiResponse> addCard(@PathVariable int tasknum) {
    return null;
  }
}
