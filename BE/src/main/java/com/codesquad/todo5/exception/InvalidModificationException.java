
package com.codesquad.todo5.exception;

import com.codesquad.todo5.response.ApiResponseCode;

public class InvalidModificationException extends RudimentaryException {
  public InvalidModificationException() { super(ApiResponseCode.BAD_PARAMETER.getMessage()); }
}