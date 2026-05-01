import React from 'react'
import CountComponent from './CountComponent'

const BikeCounter = () => {
  return (
    <CountComponent
      render={
        (count, incrementCount) => {
          return (
            <div>
              <h1>Bikes Info</h1>
              <h2>Bikes: {count}</h2>
              <button onClick={incrementCount}>Increment Bikes</button>
            </div>
          )
        }
      }
    />
  )
}

export default BikeCounter
