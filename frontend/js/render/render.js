import {
  makeTaskTemplate,
  makeActionAdd,
  makeActionRemove,
  makeActionUpdate,
  makeActionMove,
} from "../../template/template.js";
import { commonDOM } from "../../options/DOM.js";
import URL from "../../constants/url.js";
import { fetchTodoList } from "../fetch/httpRequest.js";

const registerTodoList = (className) => {
  if (className === "todo") {
    fetchTodoList(URL.TODO_LIST, commonDOM.todoTaskList, className);
  } else if (className === "doing") {
    fetchTodoList(URL.DOING_LIST, commonDOM.doingTaskList, className);
  } else if (className === "done") {
    fetchTodoList(URL.DONE_LIST, commonDOM.doneTaskList, className);
  }
};

export const renderList = (columnDom, dataList, className) => {
  dataList.forEach((el) => {
    if (el.deleted === true) {
      return;
    } else {
      columnDom.innerHTML += makeTaskTemplate(el.title, el.id, className);
    }
  });
};

export const renderActionList = (actionInfo) => {
  switch (actionInfo.actionName) {
    case "ADD": {
      commonDOM.action_list.insertAdjacentHTML(
        "afterbegin",
        makeActionAdd(actionInfo.taskTitle, actionInfo.categoryTo)
      );
      break;
    }
    case "REMOVE": {
      commonDOM.action_list.insertAdjacentHTML(
        "afterbegin",
        makeActionRemove(actionInfo.taskTitle, actionInfo.categoryTo)
      );
      break;
    }
    case "UPDATE": {
      commonDOM.action_list.insertAdjacentHTML(
        "afterbegin",
        makeActionUpdate(actionInfo.taskTitle, actionInfo.categoryTo)
      );
      break;
    }
    case "MOVE": {
      commonDOM.action_list.insertAdjacentHTML(
        "afterbegin",
        makeActionMove(
          actionInfo.taskTitle,
          actionInfo.categoryFrom,
          actionInfo.categoryTo
        )
      );
      break;
    }
  }
};

export const judgeCategoryName = (categoryNumber) => {
  if (categoryNumber === "1") {
    return "todo";
  } else if (categoryNumber === "2") {
    return "doing";
  } else if (categoryNumber === "3") {
    return "done";
  }
};

export const initRenderTodoList = () => {
  registerTodoList("todo");
  registerTodoList("doing");
  registerTodoList("done");
};
