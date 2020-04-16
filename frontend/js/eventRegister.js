import DragDropEvent from "./event/DragDropEvent.js";
import initClickEvent from "./event/clickEvent.js";
import initTextareaEvent from "./event/textareaEvent.js";
import { initRenderTodoList } from "./render/render.js";

initClickEvent();
initTextareaEvent();
DragDropEvent();
initRenderTodoList();
