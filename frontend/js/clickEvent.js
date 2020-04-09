import { createDOM, cerateColumnDom } from "../options/DOM.js";
import classNameObj from "../options/columnClassName.js";
import itemTemplate from "../template/template.js";

const ClickEventHandler = (event, className, DOM) => {
  const targetClassName = event.target.className;
  if (targetClassName === className.plusButton) {
    activatingHandler(DOM.addBox);
  } else if (targetClassName === className.addButton) {
    DOM.column.innerHTML += addBtnHandler(DOM.textArea, DOM.columnName);
  } else if (targetClassName === className.cancelButton) {
    activatingHandler(DOM.addBox);
  }
};

const activatingHandler = (addBoxDom) => {
  const displayValue = addBoxDom.style.display;

  if (!displayValue) {
    addBoxDom.style.display = "flex";
  } else {
    addBoxDom.style.display = "";
  }
};

const addBtnHandler = (textareaDom, className) => {
  const inputValue = textareaDom.value;
  return itemTemplate(inputValue, className);
};

const registerClickEvent = (ColumnName) => {
  cerateColumnDom(`${ColumnName}`).addEventListener("click", (event) => {
    ClickEventHandler(
      event,
      classNameObj(`${ColumnName}`),
      createDOM(`${ColumnName}`)
    );
  });
};

export function testEvent() {
  registerClickEvent("todo");
  registerClickEvent("doing");
  registerClickEvent("done");
}

export default testEvent;
