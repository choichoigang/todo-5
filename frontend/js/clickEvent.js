import { createDOM, cerateColumnDom } from "../options/DOM.js";
import classNameObj from "../options/columnClassName.js";
import itemTemplate from "../template/template.js";

const activatingHandler = (addBoxDom) => {
  const displayValue = addBoxDom.style.display;

  if (!displayValue) {
    addBoxDom.style.display = "flex";
  } else {
    addBoxDom.style.display = "";
  }
};

const addBtnHandler = (textareaDom, className) => {
  const inputValue = textareaDom.value;
  return itemTemplate(inputValue, className);
};
