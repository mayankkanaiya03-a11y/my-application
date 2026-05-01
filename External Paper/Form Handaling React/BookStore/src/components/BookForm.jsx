import { useState } from "react";

export default function BookForm() {
  const [bookId, setBookId] = useState("");
  const [bookTitle, setBookTitle] = useState("");
  const [bookAuthor, setBookAuthor] = useState("");

  const handleSubmit = (e) => {

    e.preventDefault();

    console.log({ 
      bookId: Number(bookId), 
      bookTitle, 
      bookAuthor 
    });

  };

  return (
    <form onSubmit={handleSubmit}>
      <input 
        type="number" 
        placeholder="Book ID" 
        value={bookId} 
        onChange={(e) => setBookId(e.target.value)} 
      />
      <input 
        type="text" 
        placeholder="Book Title" 
        value={bookTitle} 
        onChange={(e) => setBookTitle(e.target.value)} 
      />
      <input 
        type="text" 
        placeholder="Book Author" 
        value={bookAuthor} 
        onChange={(e) => setBookAuthor(e.target.value)} 
      />
      <button type="submit">Submit</button>
    </form>
  );
}