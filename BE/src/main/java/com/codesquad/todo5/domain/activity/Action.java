package com.codesquad.todo5.domain;

import com.codesquad.todo5.utils.EnumType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Action implements EnumType {
  ADD("ADD"),
  REMOVE("REMOVE"),
  UPDATE("UPDATE"),
  MOVE("MOVE");

  private final String action;

  public String getAction() {
    return action;
  }

  @Override
  public String getId() {
    return this.name();
  }
}
