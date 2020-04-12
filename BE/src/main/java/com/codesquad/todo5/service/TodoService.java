package com.codesquad.todo5.service;

import com.codesquad.todo5.domain.activity.ActivityRepository;
import com.codesquad.todo5.domain.category.Category;
import com.codesquad.todo5.domain.category.CategoryRepository;
import com.codesquad.todo5.domain.task.Task;
import com.codesquad.todo5.domain.task.TaskRepository;
import com.codesquad.todo5.domain.user.User;
import com.codesquad.todo5.dto.category.CategoryEditRequestDto;
import com.codesquad.todo5.dto.task.TaskCreateDto;
import com.codesquad.todo5.dto.task.TaskEditDto;
import com.codesquad.todo5.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {
  private final CategoryRepository categoryRepository;
  private final ActivityRepository activityRepository;
  private final TaskRepository taskRepository;
  private final UserService userService;

  public TodoService(CategoryRepository categoryRepository,
      ActivityRepository activityRepository,
      TaskRepository taskRepository, UserService userService) {
    this.categoryRepository = categoryRepository;
    this.activityRepository = activityRepository;
    this.taskRepository = taskRepository;
    this.userService = userService;
  }

  @Transactional
  public Category addCategory() {
    int categoryNum = categoryRepository.countNumber() - 1;
    Category newCategory = Category.create("새로운 카테고리 " + categoryNum);
    categoryRepository.save(newCategory);
    return newCategory;
  }

  @Transactional
  public Category editCategory(Long categoryId, CategoryEditRequestDto dto) {
    Category editedCategory = categoryRepository.findById(categoryId).orElseThrow(ResourceNotFoundException::new);
    editedCategory.setName(dto.getName());
    categoryRepository.save(editedCategory);
    return editedCategory;
  }

  @Transactional
  public Category deleteCategory(Long categoryId, CategoryEditRequestDto dto) {
    Category deletedCategory = categoryRepository.findById(categoryId).orElseThrow(ResourceNotFoundException::new);
    deletedCategory.setDeleted(dto.isDeleted);
    categoryRepository.save(deletedCategory);
    return deletedCategory;
  }

  @Transactional(readOnly = true)
  public Iterable<Category> findAllTasks() {
    return categoryRepository.findAllElements();
    //실제로 멀티유저임을 고려하면 findbyUserId로 하는 것이 사실 맞음...
  }

  @Transactional
  public Task addTask(TaskCreateDto dto) {
    Category category = categoryRepository.findById(dto.getCategoryNum()).orElseThrow(ResourceNotFoundException::new);
    //User testUser = userService.getUserByName("jypthemiracle"); join을 써서 User 가져오게 해야 함..
    Task newTask = Task.create(dto.getTitle(), dto.getContent(), category.getTask().size());
    category.addTask(newTask);
    return newTask;
  }

  @Transactional
  public Task editTask(Long cardId, TaskEditDto dto) {
    Task editTask = taskRepository.findById(cardId).orElseThrow(ResourceNotFoundException::new);
    editTask.updateTask(dto);
    taskRepository.save(editTask);
    return editTask;
  }

  @Transactional
  public Task deleteTask(Long cardId) {
    Task deletedTask = taskRepository.findById(cardId).orElseThrow(ResourceNotFoundException::new);
    deletedTask.setDeleted(true);
    taskRepository.save(deletedTask);
    return deletedTask;
  }
}
