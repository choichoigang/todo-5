import { renderList } from "../render/render.js";

export async function fetchTodoList(url, columnDom, className) {
  const response = await fetch(url);
  const responseJSON = await response.json();

  await renderList(columnDom, responseJSON.task, className);
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

export async function fetchMove(url, data) {
  const fetchOption = {
    method: "POST",
    mode: "cors",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  };

  const response = await fetch(url, fetchOption);
}
