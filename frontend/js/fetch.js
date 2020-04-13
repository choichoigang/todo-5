import { renderList } from "./render.js";

export async function fetchTodoList(url, columnDom) {
  const dataFetch = await fetch(url);
  const fetchJson = await dataFetch.json();

  renderList(columnDom, fetchJson.data);
}
