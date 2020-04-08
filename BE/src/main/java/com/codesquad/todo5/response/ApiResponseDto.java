package com.codesquad.todo5.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
public class ApiResponseDto<T> {
  public static final ApiResponseDto<String> DEFAULT_OK = new ApiResponseDto<>(ApiResponseCode.OK);
  public static final ApiResponseDto<String> DEFAULT_UNAUTHORIZED = new ApiResponseDto<>(ApiResponseCode.UNAUTHORIZED);

  private ApiResponseCode code;
  private String message;
  private T data;

  private ApiResponseDto(ApiResponseCode status) {
    this.bindStatus(status);
  }

  private ApiResponseDto(ApiResponseCode status, T data) {
    this.bindStatus(status);
    this.data = data;
  }

  private ApiResponseDto(ApiResponseCode code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  private ApiResponseDto(ApiResponseCode code, ApiException e) {
    this.code = code;
    this.message = e.getMessage();
  }

  private void bindStatus(ApiResponseCode status) {
    this.code = status;
    this.message = status.getMessage();
  }

  //메소드의 파라미터의 T 이 선언되어 있다면, 리턴타입 바로앞에 <T> 제너릭 타입을 선언해 주어야한다.
  public static <T> ApiResponseDto<T> createOK(T data) {
    return new ApiResponseDto<>(ApiResponseCode.OK, data);
  }

  public static ApiResponseDto<String> createException(ApiException e) {
    return new ApiResponseDto<>(e.getStatus(), e);
  }

  public static ApiResponseDto<String> createException(ApiResponseCode code, String message) {
    return new ApiResponseDto<>(code, message, "");
  }

  public static <T> ApiResponseDto<T> createException(ApiResponseCode code, T data) {
    return new ApiResponseDto<>(code, data);
  }
}