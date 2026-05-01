import React, { useState } from 'react'

const CountComponent = (props) => {

    const [count, setCount] = useState(0);

    const incrementCount = () => {
        setCount(count + 1);
    }

    return props.render(count, incrementCount);
}

export default CountComponent
