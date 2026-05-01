# **Q-2 c**





## BookForm.jsx





import { useState } from "react";



export default function BookForm() {

&#x20; const \[bookId, setBookId] = useState("");

&#x20; const \[bookTitle, setBookTitle] = useState("");

&#x20; const \[bookAuthor, setBookAuthor] = useState("");



&#x20; const handleSubmit = (e) => {



&#x20;   e.preventDefault();



&#x20;   console.log({ 

&#x20;     bookId: Number(bookId), 

&#x20;     bookTitle, 

&#x20;     bookAuthor 

&#x20;   });



&#x20; };



&#x20; return (

&#x20;   <form onSubmit={handleSubmit}>

&#x20;     <input 

&#x20;       type="number" 

&#x20;       placeholder="Book ID" 

&#x20;       value={bookId} 

&#x20;       onChange={(e) => setBookId(e.target.value)} 

&#x20;     />

&#x20;     <input 

&#x20;       type="text" 

&#x20;       placeholder="Book Title" 

&#x20;       value={bookTitle} 

&#x20;       onChange={(e) => setBookTitle(e.target.value)} 

&#x20;     />

&#x20;     <input 

&#x20;       type="text" 

&#x20;       placeholder="Book Author" 

&#x20;       value={bookAuthor} 

&#x20;       onChange={(e) => setBookAuthor(e.target.value)} 

&#x20;     />

&#x20;     <button type="submit">Submit</button>

&#x20;   </form>

&#x20; );

}











## App.jsx



import BookForm from "./components/BookForm"





function App() {



&#x20; return (

&#x20;   <BookForm />

&#x20; )

}



export default App



