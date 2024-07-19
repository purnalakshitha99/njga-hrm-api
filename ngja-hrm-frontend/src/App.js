import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import React, { useEffect } from "react";
import SideBar from "./component/Sidebar";
import NavBar from "./component/NavBar";
import LeaveIssues from "./pages/LeaveIssues";
import Footer from "./component/Footer";
import Nothing from "./pages/Nothing";
import Notice from "./pages/Notice";
import AllEmployees from "./pages/AllEmployees";
import PendingLeaves from "./pages/PendingLeaves";
import Attendance from "./pages/Attendance";
import Leave from "./pages/Leave";
import LeaveHistory from "./pages/LeaveHistory";
import RegisterForm from "./pages/RegisterForm";
import Login from "./pages/Login";
import FingerPrint from "./pages/fingerprint/FingerPrint";
import UserProfile from "./pages/UserProfile";
import AttendanceIssues from "./pages/AttendanceIssues";
import AnnualLeaves from "./pages/modals/AnnualLeaves";
import AddLeaves from "./pages/modals/AddLeaves";
import EducationQualification from "./pages/registerPages/EducationQualification";

function App() {
  useEffect(() => {
    const body = document.querySelector("body");
    const sidebar = body.querySelector("nav");
    const toggle = body.querySelector(".toggle");

    const toggleSidebar = () => {
      sidebar.classList.toggle("close");
    };

    toggle.addEventListener("click", toggleSidebar);

    return () => {
      toggle.removeEventListener("click", toggleSidebar);
    };
  }, []);

  return (
    <div className="App">
      <Router>
        <div className="row">
          <div className="col-2 ">
            <SideBar />
          </div>
          <div className="col-10  content-body ">
            <NavBar />
            <Routes>
              <Route path="/" element={<Login />} />
              <Route path="/leave-issues" element={<LeaveIssues />} />
              <Route path="/notice" element={<Notice />} />
              <Route path="/all-employees" element={<AllEmployees />} />
              <Route path="/pending-leaves" element={<PendingLeaves />} />
              <Route path="/attendence" element={<Attendance />} />

              <Route path="/user-profile" element={<UserProfile />} />
              <Route path="/leave-profile" element={<Leave />} />
              <Route path="/leave-history" element={<LeaveHistory />} />
              <Route path="/register" element={<RegisterForm />} />
              <Route path="/finger-print" element={<FingerPrint />} />
              <Route path="/attendance-issues" element={<AttendanceIssues />} />
              <Route path="/annual-leaves" element={<AnnualLeaves />} />
              <Route path="/add-leaves" element={<AddLeaves />} />
              
            </Routes>
          </div>
        </div>
      </Router>
    </div>
  );
}

export default App;
