import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { addContact, fetchContactById } from "../store/contact/action";

const Contact = () => {

    const [contact, setContact] = useState('');
    const [id, setId] = useState('');

    const [selectedId, setSelectedId] = useState('');

    const dispatch = useDispatch();
    const contacts = useSelector(state=>state.contacts);
    const selectedContact = useSelector(state=>state.selected);
  return (
    <>
    
    <div>
      {contacts.map(contact => (
        <div key={contact.id}>
            <h3>{contact.id}. {contact.contact}</h3>
        </div>
      ))}
    </div>

    <div>
        id
        <input type="number" name='id' value={id} onChange={(e) => setId(e.target.value)} />
        contact
        <input type="text" name='contact' value={contact} onChange={(e) => setContact(e.target.value)} />
        <button onClick={() => dispatch(addContact(id,contact))}>
            Add Contact
        </button>
    </div>

    <div>
        <input type="number" name='selectedId' value={selectedId} onChange={(e) => setSelectedId(e.target.value)} />
        <button onClick={() => dispatch(fetchContactById(selectedId))}>
            select Contact
        </button>
    </div>

    <div>
        {selectedContact && (
            <div>
                <h1>id : {selectedContact?.id} : {selectedContact?.contact}</h1>
            </div>
        )}
    </div>
    </>
  );
}

export default Contact;
