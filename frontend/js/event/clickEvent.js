import { commonDOM, createDOM, cerateColumnDom } from "../../options/DOM.js";
import classNameObj from "../../options/columnClassName.js";
import { renderTaskTemplate } from "../../template/template.js";
import modifyOption from "../../options/modifyOption.js";
import { requestBodyAdd, requestBodyEdit } from "../../options/requestBody.js";
import { fetchAdd, fetchDelete, fetchEdit } from "../fetch/httpRequest.js";
import TODO_URL from "../../constants/url.js";

//column_click------------------------------------------------------------------------------------
const columnClickEventHandler = async (event, className, DOM) => {
  const targetClassName = event.target.className;

  if (targetClassName === className.plusButton) {
    activatingHandler(DOM.addBox);
  } else if (targetClassName === className.addButton) {
    await addBtnHandler(DOM.textArea, DOM.columnName);
    await fetchAdd(TODO_URL.ADD, requestBodyAdd).then((resBody) => {
      DOM.task_list.innerHTML += renderTaskTemplate(
        requestBodyAdd.title,
        resBody.data,
        DOM.columnName
      );
    });
  } else if (targetClassName === className.cancelButton) {
    activatingHandler(DOM.addBox);
  } else if (targetClassName === "deletion") {
    const handler = await deletionBtnHandler(event);

    await fetchDelete(TODO_URL.DELETE(handler));
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
  const inputValue = textareaDom.value;
  textareaDom.value = "";

  if (className === "todo") {
    requestBodyAdd.title = inputValue;
    requestBodyAdd.categoryNum = 1;
  } else if (className === "doing") {
    requestBodyAdd.title = inputValue;
    requestBodyAdd.categoryNum = 2;
  } else if (className === "done") {
    requestBodyAdd.title = inputValue;
    requestBodyAdd.categoryNum = 3;
  }
};

const deletionBtnHandler = (event) => {
  const taskElement = event.target.closest(".task");
  const taskId = taskElement.dataset.taskId;
  taskElement.remove();
  return taskId;
};

const modifyModalHandler = (event) => {
  modifyOption.targetElement = event.target.closest(".task");
  modifyOption.titleElement = modifyOption.targetElement.querySelector(
    ".task_value"
  );
  modifyOption.targetId = event.target.closest(".task").dataset.taskId;

  commonDOM.blind.className = "blind_on";
  commonDOM.modal.style.visibility = "visible";
  commonDOM.modal_textarea.value = modifyOption.titleElement.innerText;
};
//modal_click------------------------------------------------------------------------------------
const modalClickEventHandler = (event) => {
  const targetClassName = event.target.className;

  if (targetClassName === "save_note") {
    modalSaveNoteHandler();
  } else if (targetClassName === "modal_cancel") {
    modalCancelHandler();
  }
};

const modalCancelHandler = () => {
  commonDOM.blind.className = "blind_off";
  commonDOM.modal.style.visibility = "hidden";
};

const modalSaveNoteHandler = async () => {
  const modifyValue = commonDOM.modal_textarea.value;
  if (modifyValue === "") {
    alert("수정하려는 내용이 없습니다.");
  } else {
    requestBodyEdit.title = modifyValue;
    console.log(requestBodyEdit);
    fetchEdit(TODO_URL.EDIT(modifyOption.targetId), requestBodyEdit);

    modifyOption.titleElement.innerText = modifyValue;
    modalCancelHandler();
  }
};

const registerModalClickEvent = () => {
  commonDOM.modal.addEventListener("click", modalClickEventHandler);
};

//menu_click------------------------------------------------------------------------------------
const menuClickHandler = () => {
  const menuClassName = commonDOM.menu_box.className;

  if (menuClassName === "menu_box") {
    commonDOM.menu_box.style.visibility = "visible";
    commonDOM.menu_box.className = "menu_box_active";
  } else {
    commonDOM.menu_box.className = "menu_box";
  }
};

const registerMenuClickEvent = () => {
  commonDOM.menu_tab.addEventListener("click", menuClickHandler);
};
//------------------------------------------------------------------------------------
export function initClickEvent() {
  registerColumnClickEvent("todo");
  registerColumnClickEvent("doing");
  registerColumnClickEvent("done");
  registerModalClickEvent();
  registerMenuClickEvent();
}

export default initClickEvent;
