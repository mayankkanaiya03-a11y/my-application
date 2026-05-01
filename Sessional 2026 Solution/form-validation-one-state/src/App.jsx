import React, { useState } from 'react';

export default function App() {
  // 1. Single state object to manage all three fields
  const [student, setStudent] = useState({
    studentName: '',
    rollNumber: '',
    course: ''
  });

  // 2. Event handler to update the state object dynamically
  const handleChange = (e) => {
    const { name, value } = e.target;
    setStudent({
      ...student,
      [name]: value
    });
  };

  // 3. Form submission handler
  const handleSubmit = (e) => {
    e.preventDefault(); // Prevents the page from reloading
    console.log("Final Student Data:", student); // Logs data to console
    // Not clearing the state ensures the fields and preview remain visible
  };

  return (
    <div>
      <h2>Student Registration Form</h2>
      
      <form onSubmit={handleSubmit}>
        <div>
          <h2>Student Name: </h2>
          <input 
            type="text" 
            name="studentName" 
            value={student.studentName} 
            onChange={handleChange} 
          />
        </div>

        <div>
          <h2>Roll Number: </h2>
          <input 
            type="number" 
            name="rollNumber" 
            value={student.rollNumber} 
            onChange={handleChange} 
          />
        </div>

        <div>
          <h2>Course: </h2>
          <input 
            type="text" 
            name="course" 
            value={student.course} 
            onChange={handleChange} 
          />
        </div>

        <button type="submit">Register</button>
      </form>

      <hr />

      {/* 4. Live UI Display below the form */}
      <div>
        <h3>Live Preview</h3>
        <p><strong>Name:</strong> {student.studentName}</p>
        <p><strong>Roll Number:</strong> {student.rollNumber}</p>
        <p><strong>Course:</strong> {student.course}</p>
      </div>
    </div>
  );
}