import React, { useEffect, useState } from "react";
import Swal from "sweetalert2";
import AxiosInstance from "../../api/Axios";
import AddPopup from "./AddPopup";
import AttandancePopup from "./AttandancePopup";

export default function FingerPrint() {
  const [successList, setSuccessList] = useState([]);

  const [employees, setEmployees] = useState([]);
  const [userId, setUserId] = useState();
  const [fingerPrint, setFingerPrint] = useState([]);

  const [showPopup, setShowPopup] = useState(false);
  const [showAttdence, setShowAttdence] = useState(false);
  

  useEffect(() => {
    const fetchEmployees = async () => {
      try {
        const response = await AxiosInstance.get("/employees");
        setEmployees(response.data); // Assuming the response data is an array of employees
      } catch (error) {
        console.error("Error fetching employees:", error);
        // Handle error, maybe show a message to the user
      }
    };
    fetchEmployees();
  }, []);

  useEffect(() => {
    const fetchFingerprint = async () => {
      try {
        const response = await AxiosInstance.get("/fingerprints");
        setFingerPrint(response.data);
        console.log("finger employee1", fingerPrint);
        console.log("finger employee2", response);
      } catch (error) {
        console.error("Error fetching employees:", error);
      }
    };
    fetchFingerprint();
  }, []);

  const handleClick = async (id) => {
    console.log(id);
    setShowPopup(true);
    setUserId(id);
  };

  const handleClose = () => {
    setShowPopup(false);
    setShowAttdence(false)
  };

  const handleRemoveButtonClick = (index) => {
    alert("Are you sure..?");
    setSuccessList(successList.filter((item) => item.index !== index));
  };

  const hnadleAttendance = () => {
    setShowAttdence(true);
  }

  return (
    <div className="content-wrapper mt-5">
      <div className="container-xxl flex-grow-1">
        <h4 className="py-3 mb-4">Finger print</h4>

        <div className="card">
          <div
            className="input-group input-group-merge p-4"
            id="attendanceSearch"
          >
            <span className="input-group-text " id="basic-addon-search31">
              <i className="bx bx-search"></i>
            </span>
            <input
              type="text"
              className="form-control"
              placeholder="Search..."
              aria-label="Search..."
              aria-describedby="basic-addon-search31"
            />
          </div>
          <button onClick={hnadleAttendance} className="btn btn-primary">mark attandance</button>
          <div className="table-responsive text-nowrap p-3">
            <table className="table table-striped">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>NIC</th>
                  <th>Finger_Print_1</th>
                  <th>Finger_Print_2</th>
                </tr>
              </thead>
              <tbody className="table-border-bottom-0">
                {employees.map((employ, index) => (
                  <tr key={index}>
                    <td>
                      <span className="fw-medium">{employ.id}</span>
                    </td>
                    <td>{employ.first_name}</td>
                    <td>{employ.nic}</td>
                    <td>
                      {fingerPrint
                        ?.filter((fp) => fp.employee_id === employ.id)
                        .map((fp, index) => (
                          <div key={index}>
                            {fp.finger_print_id}
                            {/* Display other fingerprint data here */}
                          </div>
                        ))}
                      {fingerPrint?.filter((fp) => fp.employee_id === employ.id)
                        .length < 2 && ( // Check if the employee has less than 2 fingerprints
                        <button
                          className="btn btn-primary"
                          onClick={() => handleClick(employ.id)}
                        >
                          Add
                        </button>
                      )}
                    </td>
                  </tr>
                ))}
                {/* Add more rows as needed */}
              </tbody>
            </table>
          </div>
        </div>
      </div>
      {showPopup && <AddPopup userId={userId} handleClose={handleClose} />}
      {showAttdence && <AttandancePopup handleClose={handleClose} />}
    </div>
  );
}
