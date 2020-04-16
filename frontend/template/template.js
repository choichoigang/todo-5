export const renderTaskTemplate = (inputValue, id, className) => {
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

export const renderActionAdd = (taskTitle, columnName) => {
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
    <span class="column_name">to ${columnName}</span>
  </div>
</div>`;
};

export const renderActionDelete = (taskTitle, columnName) => {
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
    <span class="column_name">${columnName}</span>
  </div>
</div>`;
};

export const renderActionEdit = (taskTitle, columnName) => {
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
    <span class="column_name">${columnName}</span>
  </div>
</div>`;
};

export const renderActionMove = (taskTitle, fromColumnName, toColumnName) => {
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
    <span class="from_column">from ${fromColumnName} </span>
    <span class="to_column">to ${toColumnName}</span>
  </div>
</div>`;
};
