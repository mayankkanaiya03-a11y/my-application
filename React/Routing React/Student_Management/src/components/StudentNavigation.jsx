import React from 'react'
import { NavLink, Outlet } from 'react-router'

const StudentNavigation = () => {
  return (
    <div>
      
      <nav className='pageNav'>

        <NavLink to="/students/grades">Grades</NavLink>
        <NavLink to="/students/attendance">Attendance</NavLink>
        <NavLink to="/students/fees">Fees</NavLink>

      </nav>

      <Outlet />
    </div>
  )
}

export default StudentNavigation
