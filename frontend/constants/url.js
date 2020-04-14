const TODO_URL = {
  TODO_LIST: "http://13.209.180.92:8080/api/category/1/all",
  DOING_LIST: "http://13.209.180.92:8080/api/category/2/all",
  DONE_LIST: "http://13.209.180.92:8080/api/category/3/all",
  ADD: "http://13.209.180.92:8080/api/task/add",
  DELETE: (taskID) => {
    return `http://13.209.180.92:8080/api/task/${taskID}/delete`;
  },
};

export default TODO_URL;
