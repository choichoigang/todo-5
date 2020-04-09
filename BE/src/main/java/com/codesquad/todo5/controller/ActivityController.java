package com.codesquad.todo5.controller;

import com.codesquad.todo5.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ActivityController {
  @GetMapping("/{membernum}/activity")
  public ResponseEntity<ApiResponse> showUserActivity(@RequestParam String membernum) {
    return null;
  }
}
