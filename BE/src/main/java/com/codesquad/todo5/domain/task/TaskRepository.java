package com.codesquad.todo5.domain.task;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    @Query("SELECT id, title, content, IF(is_deleted, 'true', 'false') as is_deleted, priority, category_to, category, category_key, user, user_key, author FROM task WHERE id = :id AND is_deleted = FALSE")
    Task findTaskById(Long id);

    @Query("SELECT id, title, content, IF(is_deleted, 'true', 'false') as is_deleted, priority, category_to, category, category_key, user, user_key, author FROM task WHERE id = :id")
    Task findTaskByIdIncludingDeleted(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE task t SET t.title = :title, t.content = :content WHERE t.id = :id")
    void modifyTaskContentsById(String title, String content, Long id);

    @Modifying
    @Transactional
    @Query("INSERT INTO task (title, content, user, user_key, author, category, category_key, priority) VALUES (:title, :content, :userId, :userKey, :author, :categoryId, :categoryKey, :priority)")
    void addTaskByUserAndCategoryId(String title, String content, String author, Long userId, int userKey, Long categoryId, int categoryKey, int priority);

    @Query("SELECT LAST_INSERT_ID()")
    Long lastInsertId();

    @Query("SELECT * FROM task t WHERE t.priority >= :targetIndex AND t.category = :categoryId")
    List<Task> findTasksByTargetIndex(int targetIndex, Long categoryId);

    @Query("SELECT * FROM task WHERE priority > 1 AND priority <= :targetIndex AND category = :categoryId")
    List<Task> findTasksByTargetIndexWithoutTheFirst(int targetIndex, Long categoryId);

    @Modifying
    @Transactional
    @Query("UPDATE task t SET t.category = :categoryTo, t.priority = :priority WHERE t.id = :id")
    void setNewCategoryAndPriorityByTaskId(Long categoryTo, int priority, Long id);

    @Modifying
    @Transactional
    @Query("UPDATE task t SET t.priority = t.priority + 1 WHERE t.priority >= :priority AND t.category = :categoryId AND t.id != :targetId")
    void updateTaskPriorityWithoutTargetByIdForNextCategory(int priority, Long categoryId, Long targetId);

    @Query("SELECT u.name FROM task t LEFT OUTER JOIN user u ON t.user = u.id WHERE t.id = :id")
    String findUserNameByTaskId(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE task t SET is_deleted = true WHERE t.id = :id")
    void deleteTaskById(Long id);

    @Transactional
    @Query("SELECT category FROM task WHERE id = :taskId")
    Long findCategoryIdByTaskId(Long taskId);

    @Modifying
    @Transactional
    @Query("UPDATE task SET priority = priority - 1 WHERE id IN (SELECT id FROM (SELECT id FROM task WHERE priority >= :targetIndex AND category = :categoryId)at)")
    void subtractAfterPropertiesByTargetIndexForTheCategory(int targetIndex, Long categoryId);
    // UPDATE task SET priority = priority - 1 WHERE priority >= :targetIndex AND category = :categoryId

    @Modifying
    @Transactional
    @Query("UPDATE task SET priority = priority + 1 WHERE id IN (SELECT id FROM (SELECT id FROM task WHERE priority >= :targetIndex AND category = :categoryId)at)")
    void plusAfterPrioritiesByTargetIndexForTheCategory(int targetIndex, Long categoryId);

    @Modifying
    @Transactional
    @Query("UPDATE task SET priority = priority - 1 WHERE priority <= :targetIndex AND id != :taskId AND category = :categoryId")
    void subtractAfterPrioritiesByTargetIndexForTheFirstTask(int targetIndex, Long categoryId, Long taskId);
}
