package com.codesquad.todo5.service;

import com.codesquad.todo5.domain.activity.ActivityRepository;
import com.codesquad.todo5.domain.category.Category;
import com.codesquad.todo5.domain.category.CategoryRepository;
import com.codesquad.todo5.domain.task.Task;
import com.codesquad.todo5.domain.task.TaskRepository;
import com.codesquad.todo5.domain.user.User;
import com.codesquad.todo5.domain.user.UserRepository;
import com.codesquad.todo5.dto.category.CategoryDeleteRequestDto;
import com.codesquad.todo5.dto.category.CategoryNameEditRequestDto;
import com.codesquad.todo5.dto.category.CategoryWithTasksDto;
import com.codesquad.todo5.dto.task.TaskCreateRequestDto;
import com.codesquad.todo5.dto.task.TaskModifyRequestDto;
import com.codesquad.todo5.dto.task.TaskShowResponseDto;
import com.codesquad.todo5.exception.InvalidModificationException;
import com.codesquad.todo5.exception.ResourceNotFoundException;
import com.codesquad.todo5.exception.UserNotFoundException;
import com.codesquad.todo5.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ActivityRepository activityRepository;

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;

  @Transactional
  public Category addCategory() {
    int categoryNum = categoryRepository.countNumber() - 1;
    Category newCategory = new Category("새로운 카테고리 " + categoryNum);
    categoryRepository.save(newCategory);
    return newCategory;
  }

  @Transactional
  public Category editCategory(Long categoryId, CategoryNameEditRequestDto dto) {
    Category editedCategory = categoryRepository.findById(categoryId).orElseThrow(ResourceNotFoundException::new);
    editedCategory.setName(dto.getName());
    categoryRepository.save(editedCategory);
    return editedCategory;
  }

  @Transactional
  public Category deleteCategory(Long categoryId, CategoryDeleteRequestDto dto) {
    Category deletedCategory = categoryRepository.findById(categoryId).orElseThrow(ResourceNotFoundException::new);
    deletedCategory.setDeleted(dto.isDeleted);
    categoryRepository.save(deletedCategory);
    return deletedCategory;
  }

  @Transactional(readOnly = true)
  public List<Category> findAllTasks() {
    List<Category> categories = categoryRepository.findAllElements();
    return categories;
  }

  @Transactional
  public Long addTask(TaskCreateRequestDto dto) {
    Category category = categoryRepository.findById(dto.getCategoryNum()).orElseThrow(ResourceNotFoundException::new);
    User user = userRepository.findByName(dto.getAuthor()).orElseThrow(UserNotFoundException::new);
    Long userId = userRepository.findIdByUserName(dto.getAuthor());

    taskRepository.addTaskByUserAndCategoryId(dto.getTitle(), dto.getContent(), dto.getAuthor(), dto.getCategoryNum(), category.getTask().size(), category.getTask().size() + 1, userId);
    Long lastInsertId = taskRepository.lastInsertId();
    return lastInsertId;
  }

  @Transactional(readOnly = true)
  public TaskShowResponseDto showTask(Long taskId) {
    Task task = taskRepository.findById(taskId).orElseThrow(ResourceNotFoundException::new);
    String userName = taskRepository.findUserNameByTaskId(taskId);
    Long categoryId = taskRepository.findCategoryIdByTaskId(taskId);

    return new TaskShowResponseDto(taskId, task.getTitle(), task.getContent(), userName, task.getPriority(), categoryId, task.isDeleted());

  }

  @Transactional
  public Optional<Task> editTask(Long taskId, TaskModifyRequestDto dto) {
    String modifiedTitle = dto.getTitle();
    String modifiedContent = dto.getContent();
    Task targetTask = taskRepository.findById(taskId).orElseThrow(ResourceNotFoundException::new);

    if (isInvalidModification(targetTask, modifiedTitle, modifiedContent)) {
      throw new InvalidModificationException();
    }

    taskRepository.modifyTaskContentsById(modifiedTitle, modifiedContent, taskId);

    return taskRepository.findById(taskId);
  }

  @Transactional
  public void deleteTask(Long taskId) {
    Task deletedTask = taskRepository.findById(taskId).orElseThrow(ResourceNotFoundException::new);
    taskRepository.deleteTaskById(taskId);
  }

  private boolean isInvalidModification(Task task, String modifiedTitle, String modifiedContent) {
    return task.getTitle().equals(modifiedTitle) && task.getContent().equals(modifiedContent);
  }

  @Transactional(readOnly = true)
  public CategoryWithTasksDto findCategory(Long categoryId) {
    Category category = categoryRepository.findById(categoryId).orElseThrow(ResourceNotFoundException::new);
    List<TaskShowResponseDto> dtoList = category.getTask().stream().map(element -> new TaskShowResponseDto(element.getId(),
        element.getTitle(), element.getContent(), userRepository.findUserByTaskId(element.getId()), element.getPriority(), categoryId, element.isDeleted()))
        .collect(Collectors.toList());
    return new CategoryWithTasksDto(category, dtoList);
  }
}