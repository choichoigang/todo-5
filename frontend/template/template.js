import { judgeCategoryName } from "../js/render/render.js";

export const makeTaskTemplate = (inputValue, id, className) => {
  return ` <div class="task" draggable="true" data-task-id="${id}">
    <div id="task1" class="${className}_task">
      <div class="title">
      <span class="task_value">${inputValue}</span>
      <div>
      <button class="deletion"><i class="fas fa-trash-alt"></i></button>
      <button class="modify"><i class="far fa-sticky-note"></i></button>
      </div>
    </div>
      <div class="writer">
        <span>Added by</span>
        <span> hoi</span>
      </div>
    </div>
  </div>`;
};

export const makeActionAdd = (taskTitle, categoryTo) => {
  const categoryToName = judgeCategoryName(categoryTo);

  return `<div class="log">
  <div class="profile">
    <img
      src="https://images.unsplash.com/photo-1513333420772-7b64ad15ca96?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1868&q=80"
    />
  </div>
  <div class="content">
    <span class="user_id">@hoi </span>
    <span class="action">added </span>
    <span class="task_title">${taskTitle} </span>
    <span class="column_name">to ${categoryToName}</span>
  </div>
</div>`;
};

export const makeActionRemove = (taskTitle, categoryTo) => {
  const categoryToName = judgeCategoryName(categoryTo);

  return `<div class="log">
  <div class="profile">
    <img
      src="https://images.unsplash.com/photo-1513333420772-7b64ad15ca96?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1868&q=80"
    />
  </div>
  <div class="content">
    <span class="user_id">@hoi </span>
    <span class="action">delete </span>
    <span class="task_title">${taskTitle} </span>
    <span class="column_name">${categoryToName}</span>
  </div>
</div>`;
};

export const makeActionUpdate = (taskTitle, categoryTo) => {
  const categoryToName = judgeCategoryName(categoryTo);

  return `<div class="log">
  <div class="profile">
    <img
      src="https://images.unsplash.com/photo-1513333420772-7b64ad15ca96?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1868&q=80"
    />
  </div>
  <div class="content">
    <span class="user_id">@hoi </span>
    <span class="action">updated </span>
    <span class="task_title">${taskTitle} </span>
    <span class="column_name">to ${categoryToName}</span>
  </div>
</div>`;
};

export const makeActionMove = (taskTitle, categoryFrom, categoryTo) => {
  const categoryToName = judgeCategoryName(categoryTo);
  const categoryFromName = judgeCategoryName(categoryFrom);
  return `<div class="log">
  <div class="profile">
    <img
      src="https://images.unsplash.com/photo-1513333420772-7b64ad15ca96?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1868&q=80"
    />
  </div>
  <div class="content">
    <span class="user_id">@hoi </span>
    <span class="action">moved </span>
    <span class="task_title">${taskTitle} </span>
    <span class="from_column">from ${categoryFromName} </span>
    <span class="to_column">to ${categoryToName}</span>
  </div>
</div>`;
};
