package com.codesquad.todo5.domain.category;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

  @Query("SELECT id, name, created_date_time, IF(is_deleted, 'true', 'false') as is_deleted FROM category WHERE is_deleted = FALSE")
  List<Category> findAllElements();

  @Query("SELECT count(*) FROM category c")
  int countNumber();
}
