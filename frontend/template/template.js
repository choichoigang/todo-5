const itemTemplate = (inputValue, className) => {
  return ` <div>
    <div id="task1" class="${className}_task" draggable="true">
      <div class="title">
        <span>${inputValue}</span>
        <button><i class="fas fa-trash-alt"></i></button>
      </div>
      <div class="writer">
        <span>Added by</span>
        <span> hoi</span>
      </div>
    </div>
  </div>`;
};

export default itemTemplate;
