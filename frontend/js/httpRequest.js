import { renderList } from "./render.js";

export async function fetchTodoList(url, columnDom, className) {
  const response = await fetch(url);
  const responseJSON = await response.json();
  console.log(responseJSON.data);
  await renderList(columnDom, responseJSON.data.task, className);
}

export async function fetchAdd(url, data) {
  const fetchOption = {
    method: "POST",
    mode: "cors",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  };

  const response = await fetch(url, fetchOption);
  const responseJson = await response.json();

  return responseJson;
}

export async function fetchDelete(url) {
  const fetchOption = {
    method: "POST",
    mode: "cors",
  };

  const response = await fetch(url, fetchOption);
  const responseJson = await response.json();
}

export async function fetchEdit(url, data) {
  const fetchOption = {
    method: "POST",
    mode: "cors",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  };

  const response = await fetch(url, fetchOption);
}
