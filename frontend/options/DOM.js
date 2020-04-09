const DOM = {
  dropTarget: document.querySelector(".wrapper"),

  todoBox: document.querySelector("#todo"),
  doingBox: document.querySelector("#doing"),
  doneBox: document.querySelector("#done"),
};

const cerateColumnDom = (columnName) => {
  return document.querySelector(`#${columnName}`);
};

const createDOM = (columnName) => {
  return {
    columnName: `${columnName}`,
    column: document.querySelector(`#${columnName}`),
    addBox: document.querySelector(`#${columnName}_add_area`),
    textArea: document.querySelector(`#${columnName}_add_area textarea`),
    addButton: document.querySelector(`.${columnName}_add_btn`),
    cancelButton: document.querySelector(`.${columnName}_cancel_btn`),
  };
};
