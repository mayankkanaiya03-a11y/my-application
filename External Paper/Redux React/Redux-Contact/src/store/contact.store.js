import { createStore } from "redux";
import contactReducer from "./contact/contactReducer";

const contactStore = createStore(contactReducer);

export default contactStore;