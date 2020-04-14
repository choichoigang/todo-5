package com.codesquad.todo5.dto.task;

import com.codesquad.todo5.domain.task.Task;
import com.codesquad.todo5.domain.task.TaskRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@NoArgsConstructor
public class TaskShowResponseDto {
  private Long id;
  private String title;
  private String content;
  private int priority;
  private String author;
  private int categoryFrom;
  private int categoryTo;
  private Long categoryNum;

//  var id: Int?
//  var title: String
//  var content: String
//  var priority: Int?
//  var author: String
//  var categoryFrom: Int? //카드 move에서만 사용
//  var categoryTo: Int? //카드 move에서만 사용
//  var categoryNum: Int


//  public TaskShowResponseDto(Task item, Long categoryId) {
////    this.id = item.getId();
//    this.title = item.getTitle();
//    this.content = item.getContent();
//    this.userName = taskRepository.findUserNameByTaskId(item.getId());
//    this.priority = item.getPriority();
//    this.categoryId = categoryId;
//  }
//
  public TaskShowResponseDto(Long id, String title, String content, int priority, Long categoryNum) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.priority = priority;
    this.categoryNum = categoryNum;
  }

  public TaskShowResponseDto(Long id, String title, String content, String author, int priority, Long categoryNum) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.author = author;
    this.priority = priority;
    this.categoryNum = categoryNum;
  }
}
