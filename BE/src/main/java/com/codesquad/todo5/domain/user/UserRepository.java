package com.codesquad.todo5.domain.user;

import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  @Query("SELECT * FROM user where name = :name")
  Optional<User> findByName(String name);

//  @Query("SELECT t.id, t.title, t.content, t.is_deleted, t.priority, t.category, t.category_key, t.user, t.user_key"
//      + "FROM task AS t"
//      + "JOIN user AS u"
//      + "ON u.id = t.user"
//      + "WHERE u.name = :name")
//  User findTaskByUserName(String name);

  @Query("SELECT u.name FROM task t LEFT OUTER JOIN user u ON t.user = u.id WHERE t.id = :taskId")
  String findUserByTaskId(Long taskId);

  @Query("SELECT id FROM user WHERE name = :name")
  Long findIdByUserName(String name);
}
