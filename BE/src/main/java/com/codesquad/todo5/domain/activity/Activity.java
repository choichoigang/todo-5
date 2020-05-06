package com.codesquad.todo5.domain.activity;

import com.codesquad.todo5.domain.task.Task;
import com.codesquad.todo5.domain.user.User;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@Table("activity")
public class Activity {

  @Id
  private Long id;
  // 컬럼으로 인식하여 에러 발생
//  private User user;
//  private Task task;
  @Column("user_name")
  private String userName;
  @Column("user")
  private Long userId;
  private String createdDate;
  private Target target;
  private Action action;
  private Long categoryFrom;
  private Long categoryTo;
  @Column("target_title")
  private String targetTitle;

  private Activity(String userName, Action action, Target entity) {

    this.userName = userName;
    this.action = action;
    this.target = entity;
//  TODO 이거 서버에서 해줘야 하는데 DEFAULT current_timestamp 선언 해줬는데 NULL로 찍혀서 임시방편 처리하였음
//  리팩토링 대상임!!
    this.createdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }

  public static Activity create(String userName, Action action, Target target) {
    return new Activity(userName, action, target);
  }

}
