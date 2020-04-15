import DragDropEvent from "./DragDropEvent.js";
import initClickEvent from "./clickEvent.js";
import initTextareaEvent from "./textareaEvent.js";
import { initRenderTodoList } from "./render.js";

initClickEvent();
initTextareaEvent();
DragDropEvent();
initRenderTodoList();
