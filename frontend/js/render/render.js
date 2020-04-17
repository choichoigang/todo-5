import {
  makeTaskTemplate,
  makeActionAdd,
  makeActionRemove,
  makeActionUpdate,
  makeActionMove,
} from "../../template/template.js";
import { commonDOM } from "../../options/DOM.js";
import URL from "../../constants/url.js";
import { fetchTodoList, fetchActionList } from "../fetch/httpRequest.js";

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
  switch (actionInfo.action) {
    case "추가": {
      commonDOM.action_list.insertAdjacentHTML(
        "afterbegin",
        makeActionAdd(actionInfo.targetTitle, actionInfo.categoryTo)
      );
      break;
    }
    case "제거": {
      commonDOM.action_list.insertAdjacentHTML(
        "afterbegin",
        makeActionRemove(actionInfo.targetTitle, actionInfo.categoryTo)
      );
      break;
    }
    case "수정": {
      commonDOM.action_list.insertAdjacentHTML(
        "afterbegin",
        makeActionUpdate(actionInfo.targetTitle, actionInfo.categoryTo)
      );
      break;
    }
    case "이동": {
      commonDOM.action_list.insertAdjacentHTML(
        "afterbegin",
        makeActionMove(
          actionInfo.targetTitle,
          actionInfo.categoryFrom,
          actionInfo.categoryTo
        )
      );
      break;
    }
  }
};

const registerActionList = () => {
  fetchActionList(URL.ACTIVITY).then((data) =>
    data.forEach((task) => {
      return renderActionList(task);
    })
  );
};

export const renderColumnCounter = () => {
  const todoTasks = commonDOM.todoTaskList.querySelectorAll(".task").length;
  const doingTasks = commonDOM.doingTaskList.querySelectorAll(".task").length;
  const doneTasks = commonDOM.doneTaskList.querySelectorAll(".task").length;

  commonDOM.todoCounter.innerText = todoTasks;
  commonDOM.doingCounter.innerText = doingTasks;
  commonDOM.doneCounter.innerText = doneTasks;
};

export const judgeCategoryName = (categoryNumber) => {
  if (categoryNumber === 1) {
    return "todo";
  } else if (categoryNumber === 2) {
    return "doing";
  } else if (categoryNumber === 3) {
    return "done";
  }
};

export const initRenderTodoList = () => {
  registerTodoList("todo");
  registerTodoList("doing");
  registerTodoList("done");
  registerActionList();
};
