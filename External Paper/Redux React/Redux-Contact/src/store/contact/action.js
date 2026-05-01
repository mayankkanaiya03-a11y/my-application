import { ADD_CONTACT, FETCH_CONTACT_BY_ID } from "./actionType";

export const fetchContactById = (id) => {
  return {
    type: FETCH_CONTACT_BY_ID,
    payload: id,
  };
}

export const addContact = (id,contact) => {
  return {
    type: ADD_CONTACT,
    payload: {id,contact},
  };
}