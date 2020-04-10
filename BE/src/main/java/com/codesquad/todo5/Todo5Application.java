package com.codesquad.todo5;

import com.codesquad.todo5.domain.TaskItem;
import com.codesquad.todo5.domain.TaskRepository;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Todo5Application {
  public static void main(String[] args) {
    SpringApplication.run(Todo5Application.class, args);
  }
}
