import React from 'react'
import CountComponent from './CountComponent'

const CarCounter = () => {
  return (
    <CountComponent
        render={
            (count, incrementCount) => {
                return (
                    <div>
                        <h1>Cars Info</h1>
                        <h2>Cars: {count}</h2>
                        <button onClick={incrementCount}>Increment</button>
                    </div>
                )
            }
        }
    />
  )
}

export default CarCounter
