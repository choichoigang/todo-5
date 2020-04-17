package com.codesquad.todo5.exception;

public class InvalidInputException extends RudimentaryException {
    public InvalidInputException() { super("입력한 정보가 일치하지 않습니다. 다시 입력 해주세요."); }
}
