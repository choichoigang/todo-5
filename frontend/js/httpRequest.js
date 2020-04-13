import { renderList } from "./render.js";

export async function fetchTodoList(url, columnDom, className) {
  const dataFetch = await fetch(url);
  const fetchJson = await dataFetch.json();

  await renderList(columnDom, fetchJson.data, className);
}

// const fetchOption = {
//   method: "POST",
//   mode: "cors",
//   headers: { "Content-Type": "application/json" },
//   body: JSON.stringify(data),
// };
