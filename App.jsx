import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Components from './Components'

var count = 0;
function App() {
  const [count, updateCount] = useState(0)

  return (
    <>
      <Components />
      <p>count: {count}</p>
      <button onClick={()=> updateCount(count + 1)} >Click Here </button>
     
    </>
  )
}

export default App
