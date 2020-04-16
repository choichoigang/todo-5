import { renderTaskTemplate } from "../../template/template.js";
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
      columnDom.innerHTML += renderTaskTemplate(el.title, el.id, className);
    }
  });
};

export const initRenderTodoList = () => {
  registerTodoList("todo");
  registerTodoList("doing");
  registerTodoList("done");
};
