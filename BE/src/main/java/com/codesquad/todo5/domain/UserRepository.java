package com.codesquad.todo5.domain;

import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserItem, Long> {
  @Query("SELECT * FROM USER where name = :name")
  Optional<UserItem> findByName(String name);
}
