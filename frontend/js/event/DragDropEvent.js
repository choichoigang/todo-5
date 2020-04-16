import { commonDOM } from "../../options/DOM.js";
import { requestBodyMove } from "../../options/requestBody.js";
import { fetchMove } from "../fetch/httpRequest.js";
import TODO_URL from "../../constants/url.js";
import option from "../../options/DragDropOption.js";
import { renderActionList } from "../render/render.js";
import { moveActionOption } from "../../options/actionOption.js";

const dragEnterHandler = (event) => {
  const targetTask = event.toElement.closest(".task");
  const targetColumn = event.toElement.closest(".column");

  option.toTarget = targetTask;
  option.toTargetWrapper = targetColumn;

  if (option.toTarget && event.offsetY > option.dargTargetHeight) {
    option.toTarget.after(option.dragTargetEl);
  } else if (option.toTarget && event.offsetY < option.dargTargetHeight) {
    option.toTarget.before(option.dragTargetEl);
  } else if (option.toTargetWrapper) {
    option.toTargetWrapper.appendChild(option.dragTargetEl);
  }
};

const dragStartHandler = (event) => {
  const targetColumn = event.toElement.closest(".column");
  const targetTaskId = event.toElement.closest(".task").dataset.taskId;

  requestBodyMove.categoryFrom = targetColumnId.dataset.columnId;

  option.dragTargetId = targetTaskId;
  option.dragTargetEl = event.toElement;
  option.dargTargetHeight = event.target.offsetHeight / 2;
};

const dragOverHandler = (event) => {
  event.preventDefault();
};

const dragEndHandler = async (event) => {
  const targetColumn = event.target.closest(".column");
  const targetColumnTasks = Array.from(targetColumn.querySelectorAll(".task"));

  requestBodyMove.categoryTo = targetColumn.dataset.columnId;

  await targetColumnTasks.some((elNode, index) => {
    if (elNode.dataset.taskId === option.dragTargetId) {
      requestBodyMove.priority = index + 1;
    }
  });

  await fetchMove(TODO_URL.MOVE(option.dragTargetId), requestBodyMove);
};

const initDragDropEvent = () => {
  commonDOM.dropTarget.addEventListener("dragstart", dragStartHandler);
  commonDOM.dropTarget.addEventListener("dragover", dragOverHandler);
  commonDOM.dropTarget.addEventListener("dragenter", dragEnterHandler);
  commonDOM.dropTarget.addEventListener("dragend", dragEndHandler);
};

export default initDragDropEvent;
