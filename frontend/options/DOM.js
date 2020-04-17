const commonDOM = {
  dropTarget: document.querySelector(".wrapper"),

  todoTaskList: document.querySelector("#todo .task_list"),
  doingTaskList: document.querySelector("#doing .task_list"),
  doneTaskList: document.querySelector("#done .task_list"),

  todoCounter: document.querySelector(".todo_counter"),
  doingCounter: document.querySelector(".doing_counter"),
  doneCounter: document.querySelector(".done_counter"),

  blind: document.querySelector(".blind_off"),
  modal: document.querySelector(".modify_modal"),
  modal_textarea: document.querySelector(".modify_modal textarea"),

  menu_tab: document.querySelector(".menu_tag"),
  menu_box: document.querySelector(".menu_box"),
  action_list: document.querySelector(".log_list"),

  log_in_box: document.querySelector(".log_in_activation"),
  log_in_button: document.querySelector(".log_in_button"),
};

const cerateColumnDom = (columnName) => {
  return document.querySelector(`#${columnName}`);
};

const createDOM = (columnName) => {
  return {
    columnName: `${columnName}`,
    task_list: document.querySelector(`#${columnName} .task_list`),
    addBox: document.querySelector(`#${columnName}_add_area`),
    textArea: document.querySelector(`#${columnName}_add_area textarea`),
    addButton: document.querySelector(`.${columnName}_add_btn`),
    cancelButton: document.querySelector(`.${columnName}_cancel_btn`),
  };
};

const createTextareaDOM = (columnName) => {
  return {
    textarea: document.querySelector(`#${columnName}_add_area textarea`),
    addButton: document.querySelector(`.${columnName}_add_btn`),
  };
};

export { commonDOM, createDOM, createTextareaDOM, cerateColumnDom };
