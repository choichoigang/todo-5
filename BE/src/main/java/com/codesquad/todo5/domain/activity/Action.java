package com.codesquad.todo5.domain.activity;

import com.codesquad.todo5.utils.EnumType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Action implements EnumType {
  ADD("추가"),
  REMOVE("삭제"),
  UPDATE("수정"),
  MOVE("이동");

  private final String action;

  public String getAction() {
    return action;
  }

  @Override
  public String getId() {
    return this.name();
  }
}
