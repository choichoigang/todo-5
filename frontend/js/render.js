import { itemTemplate, renderItem } from "../template/template.js";
import { commonDOM } from "../options/DOM.js";
import URL from "../constants/url.js";
import { fetchTodoList } from "./fetch.js";

const registerTodoList = (className) => {
  if (className === "todo") {
    fetchTodoList(URL.TODO_LIST, commonDOM.todoBox, className);
  } else if (className === "doing") {
    fetchTodoList(URL.DOING_LIST, commonDOM.doingBox, className);
  } else if (className === "done") {
    fetchTodoList(URL.DONE_LIST, commonDOM.doneBox, className);
  }
};

export const renderList = (columnDom, dataList, className) => {
  dataList.forEach((el) => {
    columnDom.innerHTML += renderItem(el.title, className, el.id);
  });
};

export const initRenderTodoList = () => {
  registerTodoList("todo");
};
