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
