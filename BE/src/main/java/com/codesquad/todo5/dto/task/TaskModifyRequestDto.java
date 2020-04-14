package com.codesquad.todo5.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskModifyRequestDto {
  private String title;
  private String content;
  private String author;
  private Long categoryNum;
  private Long categoryFrom;
  private Long categoryTo;
}


//{
//	"title": "THIS IS A TEST",
//	"content": "THIS IS A CONTENT",
//	"author": "test",
//	"categoryNum": 1
//}