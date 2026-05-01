import { useState } from "react";

export default function Inventory() {

  const [items, setItems] = useState([
    { id: 1, name: "Apples", inStock: true },
    { id: 2, name: "Oranges", inStock: false },
    { id: 3, name: "Bananas", inStock: true },
  ]);

  const toggleStock = (id) => {

    const newItems = items.map(item => 
      item.id === id ? { ...item, inStock: !item.inStock } : item
    );

    setItems(newItems);

  };

  return (
    <div>
      <h2>In Stock Items</h2>

        {items.filter(item => item.inStock).map(item => (
          <p onClick={() => toggleStock(item.id)} >
            {item.name}
          </p>
        ))}

      <h2>Out of Stock Items</h2>
      
        {items.filter(item => !item.inStock).map(item => (
          <p onClick={() => toggleStock(item.id)} >
            {item.name}
          </p>
        ))}
      
    </div>
  );
}