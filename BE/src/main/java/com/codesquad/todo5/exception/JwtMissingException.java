package com.codesquad.todo5.exception;

public class JwtMissingException extends RudimentaryException {

  public JwtMissingException() {
    super("JWT 넣어서 보내주세요!!");
  }
}
