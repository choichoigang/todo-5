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

const registerTextareaEvent = (textareaDom) => {
  textareaDom.textarea.addEventListener("input", (event) => {
    textareaHandler(event, textareaDom.addButton);
  });
};

const initTextareaEvent = () => {
  registerTextareaEvent(createTextareaDOM("todo"));
  registerTextareaEvent(createTextareaDOM("doing"));
  registerTextareaEvent(createTextareaDOM("done"));
};

export default initTextareaEvent;
