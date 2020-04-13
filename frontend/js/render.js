import { itemTemplate, renderItem } from "../template/template.js";
import { commonDOM } from "../options/DOM.js";
import URL from "../constants/url.js";

const renderTodoList = (className) => {
  if (className === "todo") {
    fetchList(URL.TODO_LIST, commonDOM.todoBox);
  } else if (className === "doing") {
    fetchList(URL.DOING_LIST, commonDOM.doingBox);
  } else if (className === "done") {
    fetchList(URL.DONE_LIST, commonDOM.doneBox);
  }
};

async function fetchList(url, columnDom) {
  const dataFetch = await fetch(url);
  const fetchJson = await dataFetch.json();

  renderList(columnDom, fetchJson.data);
}

const renderList = (columnDom, dataList) => {
  dataList.forEach((el) => {
    columnDom.innerHTML += renderItem(el.title, "todo", el.id);
  });
};

const testing = () => {
  renderTodoList("todo");
};

export default testing;
