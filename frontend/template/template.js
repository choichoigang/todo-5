const itemTemplate = (inputValue, className) => {
  return ` <div class="task" draggable="true">
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

const renderItem = (inputValue, className, id) => {
  return ` <div class="task" draggable="true" task_data_id="${id}">
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

export { itemTemplate, renderItem };
