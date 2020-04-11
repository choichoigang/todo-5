package com.codesquad.todo5.domain;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

  @Query("SELECT task.id, task.title, task.content, task.is_deleted, task.category,"
      + "task.category_key, task.user, task.user_key, task.priority FROM task"
      + "WHERE task.is_deleted = FALSE")
  List<Task> findAllTaskItemsDeletedFalse();

  @Query("SELECT task.id, task.title, task.content, task.is_deleted, task.category,"
      + "task.category_key, task.user, task.user_key, task.priority FROM task"
      + "WHERE task.is_deleted = FALSE"
      + "AND id = :id")
  List<Task> findTaskItemById(@Param(value = "id") Long id);

}