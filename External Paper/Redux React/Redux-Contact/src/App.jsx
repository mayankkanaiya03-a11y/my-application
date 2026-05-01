import { Provider } from "react-redux"
import contactStore from "./store/contact.store"
import Contact from "./components/Contact"


function App() {

  return (
    <>
      <Provider store={contactStore}>
        <Contact />
      </Provider>
    </>
  )
}

export default App
