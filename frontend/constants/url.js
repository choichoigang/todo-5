const TODO_URL = {
  TODO_LIST: "http://13.209.180.92:8080/api/category/1/all",
  DOING_LIST: "http://13.209.180.92:8080/api/category/2/all",
  DONE_LIST: "http://13.209.180.92:8080/api/category/3/all",
  ADD: "http://13.209.180.92:8080/api/task/add",
  ACTIVITY: "http://13.209.180.92:8080/api/user/1/activity",
  AUTH: " http://13.209.180.92:8080/api/user/auth",
  DELETE: (taskId) => {
    return `http://13.209.180.92:8080/api/task/${taskId}/delete`;
  },
  EDIT: (taskId) => {
    return `http://13.209.180.92:8080/api/task/${taskId}/edit`;
  },
  MOVE: (taskId) => {
    return `http://13.209.180.92:8080/api/task/${taskId}/move`;
  },
};

export default TODO_URL;
