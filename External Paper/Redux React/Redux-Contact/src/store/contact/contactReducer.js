import { ADD_CONTACT, FETCH_CONTACT_BY_ID } from "./actionType";

const initialState = {
  contacts: [],
  selected: null,
};

const contactReducer = (state = initialState, action) => {

  switch (action.type) {

    case ADD_CONTACT:
      
      const exist = state.contacts.some(contact => contact.id === action.payload.id);
      if (exist) {
        return state; // No duplicates allowed, return current state
      }  

      return {
        ...state,
        contacts: [...state.contacts, action.payload],
      };


    case FETCH_CONTACT_BY_ID:
      return {
        ...state,
        selected: state.contacts.find(contact => contact.id === action.payload),
      };

    default:
      return state;
  }
};

export default contactReducer;