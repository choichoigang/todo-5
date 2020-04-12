package com.codesquad.todo5.domain.task;

import com.codesquad.todo5.domain.category.Category;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

  @Query("SELECT id, title, content, IF(is_deleted, 'true', 'false') as is_deleted, priority, category_to, category, category_key, user, user_key FROM task WHERE id = :id AND is_deleted = FALSE")
  Task findTaskById(Long id);

  @Modifying
  @Transactional
  @Query("UPDATE task t SET t.title = :title, t.content = :content WHERE t.id = :id")
  void modifyTaskContentsById(String title, String content, Long id);

  @Modifying
  @Transactional
  @Query("INSERT INTO task (title, content, user, user_key, category, category_key, priority) VALUES (:title, :content, :userId, :userKey,:categoryId, :categoryKey, :priority)")
  void addTaskByUserAndCategoryId(String title, String content, Long userId, int userKey, Long categoryId, int categoryKey, int priority);

  @Modifying
  @Transactional
  @Query("UPDATE task t SET t.category = :categoryTo, t.priority = :priority WHERE t.id = :id")
  void updateTaskCategoryById(int categoryTo, int priority, Long id);

}