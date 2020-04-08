const dragStartHandler = (event) => {
  event.dataTransfer.setData("ID", event.target.id);
};

const dragOverHandler = (event) => {
  event.preventDefault();
};

const dropHanlder = (event) => {
  const getID = event.dataTransfer.getData("ID");
  const dropArea = event.target.classList.contains("box");

  if (dropArea) {
    event.target.appendChild(document.getElementById(getID));
  }
};

const initDragDropEvent = () => {
  DOM.dropTarget.addEventListener("dragstart", dragStartHandler);
  DOM.dropTarget.addEventListener("dragover", dragOverHandler);
  DOM.dropTarget.addEventListener("drop", dropHanlder);
};

export default initDragDropEvent;
