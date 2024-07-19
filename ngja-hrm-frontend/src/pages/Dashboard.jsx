import React from 'react'
import Sidebar from '../components/Sidebar'
import { Link } from 'react-router-dom'



function Dashboard() {
  return (
    <div>
      <h3><Link to="/AllEmployees">All Employees</Link></h3>
      <h3> <Link to="/Attendance">Attendance</Link> </h3>
    <h3> <Link to="/PendingLeaves">Pending Leaves</Link> </h3>
    
    

    </div>
  )
}

export default Dashboard