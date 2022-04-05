import React, { useState} from 'react'

function MyComponentsFunc({ name, children }) => {
  let [item, setItem] = useState(9);

  return (
    <div>
      <h3>나는 {name}</h3>
      {children}
    </div>
  )
}

export default MyComponentsFunc