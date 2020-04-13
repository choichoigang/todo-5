import { commonDOM } from "../options/DOM.js";

const option = {
  dragTargetEl: null,
  dargTargetHeight: null,
  toTarget: null,
  toTargetWrapper: null,
};

const dragEnterHandler = (event) => {
  option.toTarget = event.toElement.closest(".task");
  option.toTargetWrapper = event.toElement.closest(".box");

  if (option.toTarget && event.offsetY > option.dargTargetHeight) {
    option.toTarget.after(option.dragTargetEl);
  } else if (option.toTarget && event.offsetY < option.dargTargetHeight) {
    option.toTarget.before(option.dragTargetEl);
  } else if (option.toTargetWrapper) {
    option.toTargetWrapper.appendChild(option.dragTargetEl);
  }
};

const dragStartHandler = (event) => {
  option.dragTargetEl = event.toElement;
  option.dargTargetHeight = event.target.offsetHeight / 2;
};

const dragOverHandler = (event) => {
  event.preventDefault();
};

const initDragDropEvent = () => {
  commonDOM.dropTarget.addEventListener("dragstart", dragStartHandler);
  commonDOM.dropTarget.addEventListener("dragover", dragOverHandler);
  commonDOM.dropTarget.addEventListener("dragenter", dragEnterHandler);
};

export default initDragDropEvent;
