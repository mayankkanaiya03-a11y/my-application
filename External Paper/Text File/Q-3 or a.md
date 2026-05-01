# **Q-3 or a**





# actionTypes.js





export const FETCH\_CONTACT\_BY\_ID = 'FETCH\_CONTACT\_BY\_ID';

export const ADD\_CONTACT = 'ADD\_CONTACT';





## action.js





import { ADD\_CONTACT, FETCH\_CONTACT\_BY\_ID } from "./actionType";



export const fetchContactById = (id) => {

&#x20; return {

&#x20;   type: FETCH\_CONTACT\_BY\_ID,

&#x20;   payload: id,

&#x20; };

}



export const addContact = (id,contact) => {

&#x20; return {

&#x20;   type: ADD\_CONTACT,

&#x20;   payload: {id,contact},

&#x20; };

}







## contactReducer.js



import { ADD\_CONTACT, FETCH\_CONTACT\_BY\_ID } from "./actionType";



const initialState = {

&#x20; contacts: \[],

&#x20; selected: null,

};



const contactReducer = (state = initialState, action) => {





&#x20; switch (action.type) {



&#x20;   case ADD\_CONTACT:

&#x20;     

&#x20;     const exist = state.contacts.some(contact => contact.id === action.payload.id);

&#x20;     if (exist) {

&#x20;       return state; // No duplicates allowed, return current state

&#x20;     }  



&#x20;     return {

&#x20;       ...state,

&#x20;       contacts: \[...state.contacts, action.payload],

&#x20;     };





&#x20;   case FETCH\_CONTACT\_BY\_ID:

&#x20;     return {

&#x20;       ...state,

&#x20;       selected: state.contacts.find(contact => contact.id === action.payload),

&#x20;     };



&#x20;   default:

&#x20;     return state;

&#x20; }

};



export default contactReducer;











