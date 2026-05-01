# **Q-2 b**









## Inventory.jsx







import { useState } from "react";



export default function Inventory() {



&#x20; const \[items, setItems] = useState(\[

&#x20;   { id: 1, name: "Apples", inStock: true },

&#x20;   { id: 2, name: "Oranges", inStock: false },

&#x20;   { id: 3, name: "Bananas", inStock: true },

&#x20; ]);



&#x20; const toggleStock = (id) => {



&#x20;   const newItems = items.map(item => 

&#x20;     item.id === id ? { ...item, inStock: !item.inStock } : item

&#x20;   );



&#x20;   setItems(newItems);



&#x20; };



&#x20; return (

&#x20;   <div>

&#x20;     <h2>In Stock Items</h2>



&#x20;       {items.filter(item => item.inStock).map(item => (

&#x20;         <p onClick={() => toggleStock(item.id)} >

&#x20;           {item.name}

&#x20;         </p>

&#x20;       ))}



&#x20;     <h2>Out of Stock Items</h2>

&#x20;     

&#x20;       {items.filter(item => !item.inStock).map(item => (

&#x20;         <p onClick={() => toggleStock(item.id)} >

&#x20;           {item.name}

&#x20;         </p>

&#x20;       ))}

&#x20;     

&#x20;   </div>

&#x20; );

}









## App.jsx



import Inventory from "./components/Inventory"





function App() {



&#x20; return (

&#x20;   <Inventory />

&#x20; )

}



export default App













