import { createTextareaDOM } from "../options/DOM.js";

const textareaHandler = (event, todoAddButton) => {
  const textareaValue = event.target.value;

  if (textareaValue === "") {
    todoAddButton.disabled = true;
    return;
  } else {
    todoAddButton.disabled = false;
  }
};
