import React from 'react'
import WithCounter from './WithCounter'

const Counter = (props) => {
  return <>
    <h1>Cars Info</h1>

    <h2>Count: {props.count}</h2>
    <button onClick={props.incrementCount}>Increment</button>
  </>
}



const EnhancedCarCounter = WithCounter(Counter)



const CarCounter = (props) => {
  return <>
    <EnhancedCarCounter />
  </>
}

export default CarCounter
