package com.codesquad.todo5.exception;

import com.codesquad.todo5.utils.ApiResponse;
import com.codesquad.todo5.utils.ErrorMessagesCollection;

public class RudimentaryException extends RuntimeException {
  private String errorMessage;

  public RudimentaryException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public ApiResponse returnErrorMessage() {
    return new ApiResponse(ErrorMessagesCollection.BASE_ERROR, errorMessage);
  }
}
