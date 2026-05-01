import React from 'react'

const WithCounter = (WrappedComponent) => {
  
    const HOCComponents = (props) => {
        const [count, setCount] = React.useState(0)

        const incrementCount = () => {
            setCount(count + 1)
        }

        return (
            <WrappedComponent
                count={count}
                incrementCount={incrementCount}
                {...props}
            />
        )
    }
    return HOCComponents
}

export default WithCounter
