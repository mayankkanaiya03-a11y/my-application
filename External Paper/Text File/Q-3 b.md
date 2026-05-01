# **Q-3 b**







# **HOC Design Pattern**







## WithCounter.jsx





import React from 'react'



const WithCounter = (WrappedComponent) => {

&#x20; 

&#x20;   const HOCComponents = (props) => {

&#x20;       const \[count, setCount] = React.useState(0)



&#x20;       const incrementCount = () => {

&#x20;           setCount(count + 1)

&#x20;       }



&#x20;       return (

&#x20;           <WrappedComponent

&#x20;               count={count}

&#x20;               incrementCount={incrementCount}

&#x20;               {...props}

&#x20;           />

&#x20;       )

&#x20;   }

&#x20;   return HOCComponents

}



export default WithCounter







## CarCounter.jsx





import React from 'react'

import WithCounter from './WithCounter'



const Counter = (props) => {

&#x20; return <>

&#x20;   <h1>Cars Info</h1>



&#x20;   <h2>Count: {props.count}</h2>

&#x20;   <button onClick={props.incrementCount}>Increment</button>

&#x20; </>

}







const EnhancedCarCounter = WithCounter(Counter)







const CarCounter = (props) => {

&#x20; return <>

&#x20;   <EnhancedCarCounter />

&#x20; </>

}



export default CarCounter





## BikeCounter.jsx





import React from 'react'

import WithCounter from './WithCounter'



const Counter = (props) => {

&#x20;   return <>

&#x20;   <h1>Bikes Info</h1>



&#x20;   <h2>Count: {props.count}</h2>

&#x20;   <button onClick={props.incrementCount}>Increment</button>

&#x20; </>

}



const EnhancedBikeCounter = WithCounter(Counter)



const BikeCounter = () => {

&#x20; return(

&#x20;   <>

&#x20;       <EnhancedBikeCounter />

&#x20;   </>

&#x20; )

}



export default BikeCounter

























# **OR**



# **Render Props Design Patterns**





## CountCopmponent.jsx



import React, { useState } from 'react'



const CountComponent = (props) => {



&#x20;   const \[count, setCount] = useState(0);



&#x20;   const incrementCount = () => {

&#x20;       setCount(count + 1);

&#x20;   }



&#x20;   return props.render(count, incrementCount);

}



export default CountComponent







## CarCounter.jsx



import React from 'react'

import CountComponent from './CountComponent'



const CarCounter = () => {

&#x20; return (

&#x20;   <CountComponent

&#x20;       render={

&#x20;           (count, incrementCount) => {

&#x20;               return (

&#x20;                   <div>

&#x20;                       <h1>Cars Info</h1>

&#x20;                       <h2>Cars: {count}</h2>

&#x20;                       <button onClick={incrementCount}>Increment</button>

&#x20;                   </div>

&#x20;               )

&#x20;           }

&#x20;       }

&#x20;   />

&#x20; )

}



export default CarCounter





## BikeCounter.jsx



import React from 'react'

import CountComponent from './CountComponent'



const BikeCounter = () => {

&#x20; return (

&#x20;   <CountComponent

&#x20;     render={

&#x20;       (count, incrementCount) => {

&#x20;         return (

&#x20;           <div>

&#x20;             <h1>Bikes Info</h1>

&#x20;             <h2>Bikes: {count}</h2>

&#x20;           </div>

&#x20;         )

&#x20;       }

&#x20;     }

&#x20;   />

&#x20; )

}



export default BikeCounter










## 

