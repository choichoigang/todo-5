export const requestBodyAdd = {
  title: "",
  content: "test",
  author: "jypthemiracle",
  categoryNum: Number,
};

export const requestBodyEdit = {
  author: "string",
  categoryFrom: 0,
  categoryNum: 0,
  categoryTo: 0,
  content: "",
  title: String,
};

export const requestBodyMove = {
  priority: Number,
  categoryFrom: Number,
  categoryTo: Number,
};
