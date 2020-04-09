const DOM = {
  dropTarget: document.querySelector(".wrapper"),

  todoBox: document.querySelector("#todo"),
  doingBox: document.querySelector("#doing"),
  doneBox: document.querySelector("#done"),
};

const cerateColumnDom = (columnName) => {
  return document.querySelector(`#${columnName}`);
};
