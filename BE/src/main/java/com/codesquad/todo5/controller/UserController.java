package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.domain.user.User;
import com.codesquad.todo5.dto.activity.UserActivityResponseDto;
import com.codesquad.todo5.dto.user.LoginDto;
import com.codesquad.todo5.response.ApiResponse;
import com.codesquad.todo5.service.JwtService;
import com.codesquad.todo5.service.UserService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class UserController {

  private final UserService userService;
  private final JwtService jwtService;

  public UserController(UserService userService, JwtService jwtService) {
    this.userService = userService;
    this.jwtService = jwtService;
  }

  @GetMapping("/user/{userid}/activity")
  public List<UserActivityResponseDto> getUserActivityList(@PathVariable Long userid) {
    User nowUser = userService.getUserById(userid);
    List<Activity> nowUserActivities = userService.getUserActivityList(userid);
    List<UserActivityResponseDto> userActivityResponseDtoList =
        nowUserActivities.stream().map(activityitem -> new UserActivityResponseDto(activityitem, nowUser.getName())).collect(
            Collectors.toList());
    return userActivityResponseDtoList;
  }

  @GetMapping("/user/auth")
  public ResponseEntity<ApiResponse> login(HttpServletRequest req, HttpServletResponse res, LoginDto dto) {
    //TODO 원래 로그인 기능이 구현 되어 있다면 입력된 정보가 유저의 정보와 일치하는지 확인하는 절차가 필요하다. 성공 했을 때 다음 절차들을 진행하는 것이 원래 구현해야 하는 로직
//    userService.checkValidUser(dto);
    String jwtToken = jwtService.makeJwt(req);
    Cookie cookie = new Cookie("jwtToken", jwtToken);
    res.addCookie(cookie);
    ApiResponse response = new ApiResponse();
    response.setStatus(true);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}