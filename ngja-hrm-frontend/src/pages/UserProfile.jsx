import React, { useState, useEffect } from 'react'; // Import useState and useEffect
import '../css/profile.css';
import Image1 from '../avatars/12.png';
import WorkDetails from './WorkDetails';
import PreviousWorkHistory from './PreviousWorkHistory';
import EducationQualifications from './EducationQualifications';
import DependentsDetails from './DependentsDetails';
import EmergencyContact from './EmergencyContact';
import AxiosInstance from "../api/Axios";

function UserProfile() {
  const [user, setUser] = useState(null);
  const [error, setError] = useState('');

  useEffect(() => {
    const fetchUser = async () => {
      try {
        const response = await AxiosInstance.get('employee/id/3');
        setUser(response.data);
      } catch (error) {
        console.error('Error fetching user:', error);
        setError('Error fetching user. Please try again later.');
      }
    };

    fetchUser();
  }, []);

  if (!user) {
    return <div>Loading user information...</div>;
  }

  return (
    <>
      <div className="container-xxl flex-grow-1 container-p-y" id='card12'>
        <h4 className="py-3 mb-4 mt-3">User Profile</h4>
        <div className="row">
          <div className="col card m-2">
            <h4 className="mt-2">Basic Details</h4>
            <div className="row">
              <div className="col">
                <div style={{ marginBottom: 20, marginRight: 20 }}>
                  <img src={Image1} alt="profile" className="rounded w-100 h-100"/>
                </div>
              </div>
              <div className="col-4 mt-3 text-left">
                <h6 className="fw-bold ">
                  <p>Name :</p>
                  <p>NIC:</p>
                  <p>Gender :</p>
                  <p>DOB :</p>
                </h6>
              </div>
              <div className="col-4 mt-3 text-left">
                <h6>{user.firstName + ' ' + user.lastName}</h6> 
                <h6>{user.nic}</h6>
                <h6>{user.gender}</h6>
                <h6>{user.dob}</h6>
              </div>
            </div>
          </div>
          <div className="col card m-2">
            <div className="row">
              <div className="col mt-2">
                <h4>Basic Details</h4>
              </div>
            </div>
            <div className="row d-flex justify-content-center mt-3">
              <div className="col-3">
                <h6 className="fw-bold text-left">
                  <p>Email:</p>
                  <p>Address :</p>
                  <p>Mobile :</p>
                </h6>
              </div>
              <div className="col-4 text-left">
                <h6>
                  <p>{user.email}</p>
                  <p>{user.address}</p>
                  <p>{user.contactNumber}</p>
                </h6>
              </div>
            </div>
          </div>
        </div>
        <div className="col-xl-6 w-100">
          <div className="nav-align-top mb-4">
            <ul className="nav nav-tabs" role="tablist">
              <li className="nav-item">
                <button type="button" className="nav-link active" role="tab" data-bs-toggle="tab" data-bs-target="#navs-top-workDetails" aria-controls="navs-top-workDetails" aria-selected="true">Work Details</button>
              </li>
              <li className="nav-item">
                <button type="button" className="nav-link" role="tab" data-bs-toggle="tab" data-bs-target="#navs-top-previousWorkHistory" aria-controls="navs-top-previousWorkHistory" aria-selected="false">Previous Work History</button>
              </li>
              <li className="nav-item">
                <button type="button" className="nav-link" role="tab" data-bs-toggle="tab" data-bs-target="#navs-top-educationQualifications" aria-controls="navs-top-educationQualifications" aria-selected="false">Education Qualifications</button>
              </li>
              <li className="nav-item">
                <button type="button" className="nav-link" role="tab" data-bs-toggle="tab" data-bs-target="#navs-top-dependentsDetails" aria-controls="navs-top-dependentsDetails" aria-selected="false">Dependents Details</button>
              </li>
              <li className="nav-item">
                <button type="button" className="nav-link" role="tab" data-bs-toggle="tab" data-bs-target="#navs-top-emergencyContact" aria-controls="navs-top-emergencyContact" aria-selected="false">Emergency Contact</button>
              </li>
            </ul>
            <div className="tab-content">
              <WorkDetails />
              <PreviousWorkHistory />
              <EducationQualifications />
              <DependentsDetails />
              <EmergencyContact />
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default UserProfile;
