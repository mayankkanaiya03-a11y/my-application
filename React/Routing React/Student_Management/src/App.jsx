import { Route, Routes } from "react-router"
import StudentNavigation from "./components/StudentNavigation"


function App() {

  return (
    <>
      

      <Routes>

        <Route path="/dashboard" element={<h1>Dashboard</h1>} />
        <Route path="/teachers" element={<h1>Teachers</h1>} />


        {/* <Route path="/students/:id" element={<h1>Specific student</h1>} /> */}
        
        <Route path="/students" element={<StudentNavigation />} >
        
          <Route path=":id" element={<h1>Specific student</h1>} />
          <Route path="grades" element={<h1>Student Grades</h1>} />
          <Route path="attendance" element={<h1>Student Attendance</h1>} />
          <Route path="fees" element={<h1>Student Fees</h1>} />

        </Route>

      </Routes>
    </>
  )
}

export default App
