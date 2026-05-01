import React from 'react'
import WithCounter from './WithCounter'

const Counter = (props) => {
    return <>
    <h1>Bikes Info</h1>

    <h2>Count: {props.count}</h2>
    <button onClick={props.incrementCount}>Increment</button>
  </>
}

const EnhancedBikeCounter = WithCounter(Counter)

const BikeCounter = () => {
  return(
    <>
        <EnhancedBikeCounter />
    </>
  )
}

export default BikeCounter
