import { commonDOM, createDOM, cerateColumnDom } from "../options/DOM.js";
import classNameObj from "../options/columnClassName.js";
import { itemTemplate } from "../template/template.js";
import modifyOption from "../options/modifyOption.js";

const columnClickEventHandler = (event, className, DOM) => {
  const targetClassName = event.target.className;

  if (targetClassName === className.plusButton) {
    activatingHandler(DOM.addBox);
  } else if (targetClassName === className.addButton) {
    DOM.column.innerHTML += addBtnHandler(DOM.textArea, DOM.columnName);
  } else if (targetClassName === className.cancelButton) {
    activatingHandler(DOM.addBox);
  } else if (targetClassName === "deletion") {
    deletionBtnHandler(event);
  } else if (targetClassName === "modify") {
    modifyModalHandler(event);
  }
};

const registerColumnClickEvent = (ColumnName) => {
  cerateColumnDom(`${ColumnName}`).addEventListener("click", (event) => {
    columnClickEventHandler(
      event,
      classNameObj(`${ColumnName}`),
      createDOM(`${ColumnName}`)
    );
  });
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
  // 추가 사항을 서버로 보냄
  const inputValue = textareaDom.value;
  return itemTemplate(inputValue, className);
};

const deletionBtnHandler = (event) => {
  // 삭제 내용을 서버로 보냄
  const taskElement = event.target.closest(".task");

  taskElement.remove();
};

const modifyModalHandler = (event) => {
  modifyOption.targetElement = event.target.closest(".task");
  modifyOption.titleElement = modifyOption.targetElement.querySelector(
    ".task_value"
  );

  commonDOM.blind.className = "blind_on";
  commonDOM.modal.style.visibility = "visible";
  commonDOM.modal_textarea.value = modifyOption.titleElement.innerText;
};
//------------------------------------------------------------------------------------
const modalCancelHandler = () => {
  commonDOM.blind.className = "blind_off";
  commonDOM.modal.style.visibility = "hidden";
};

const modalSaveNoteHandler = () => {
  const modifyValue = commonDOM.modal_textarea.value;
  if (modifyValue === "") {
    alert("수정하려는 내용이 없습니다.");
  } else {
    // 수정 사항을 서버로 보냄
    modifyOption.titleElement.innerText = modifyValue;
    modalCancelHandler();
  }
};

export function testEvent() {
  registerColumnClickEvent("todo");
  registerColumnClickEvent("doing");
  registerColumnClickEvent("done");
}

export default testEvent;
