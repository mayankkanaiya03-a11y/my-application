# **Q-3 a**







## App.jsx





import { Route, Routes } from "react-router"

import StudentNavigation from "./components/StudentNavigation"





function App() {



&#x20; return (

&#x20;   <>

&#x20;     



&#x20;     <Routes>



&#x20;       <Route path="/dashboard" element={<h1>Dashboard</h1>} />

&#x20;       <Route path="/teachers" element={<h1>Teachers</h1>} />





&#x20;       {/\* <Route path="/students/:id" element={<h1>Specific student</h1>} /> \*/}

&#x20;       

&#x20;       <Route path="/students" element={<StudentNavigation />} >

&#x20;       

&#x20;         <Route path=":id" element={<h1>Specific student</h1>} />

&#x20;         <Route path="grades" element={<h1>Student Grades</h1>} />

&#x20;         <Route path="attendance" element={<h1>Student Attendance</h1>} />

&#x20;         <Route path="fees" element={<h1>Student Fees</h1>} />



&#x20;       </Route>



&#x20;     </Routes>

&#x20;   </>

&#x20; )

}



export default App







## StudentNavigation.jsx



import React from 'react'

import { NavLink, Outlet } from 'react-router'



const StudentNavigation = () => {

&#x20; return (

&#x20;   <div>

&#x20;     

&#x20;     <nav className='pageNav'>



&#x20;       <NavLink to="/students/grades">Grades</NavLink>

&#x20;       <NavLink to="/students/attendance">Attendance</NavLink>

&#x20;       <NavLink to="/students/fees">Fees</NavLink>



&#x20;     </nav>



&#x20;     <Outlet />

&#x20;   </div>

&#x20; )

}



export default StudentNavigation







