import { commonDOM } from "../../options/DOM.js";
import URL from "../../constants/url.js";
import { fetchLogIn } from "../../js/fetch/httpRequest.js";

const logInHandler = () => {
  commonDOM.log_in_box.className = "log_in_deactivation";
};

export const registerLogInEvent = () => {
  commonDOM.log_in_button.addEventListener("click", () => {
    fetchLogIn(URL.AUTH).then((data) => {
      if (data.status === false) {
        return;
      } else {
        logInHandler();
      }
    });
  });
};
