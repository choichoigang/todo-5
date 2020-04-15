
package com.codesquad.todo5.exception;

public class UserNotFoundException extends RudimentaryException {
  public UserNotFoundException() {
    super("USER NOT FOUND !!");
  }
}