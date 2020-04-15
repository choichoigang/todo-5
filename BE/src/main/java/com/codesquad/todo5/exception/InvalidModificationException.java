
package com.codesquad.todo5.exception;

public class InvalidModificationException extends RudimentaryException {
  public InvalidModificationException() { super("유효하지 않은 수정 요청 입니다. 다시 입력 해주세요."); }
}