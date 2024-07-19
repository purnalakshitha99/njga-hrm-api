import React, { useEffect, useState } from "react";
import "../css/AttendanceIssues.css";
import AddLeaves from "./modals/AddLeaves";
import AxiosInstance from "../api/Axios";

function AttendanceIssues() {
  const [attandanceIssue, setAttandanceIssue] = useState([]);
  const [fromDate, setFromDate] = useState("2021-06-18");
  const [toDate, setToDate] = useState("2021-06-18");
  const [employeeDetails, setEmployeeDetails] = useState({});

  useEffect(() => {
    const fetchEmployees = async () => {
      try {
        const response = await AxiosInstance.get("attendances", {
          headers: {
            VERSION: "V1",
          },
        });
        console.log("attendance", response);
        setAttandanceIssue(response.data); // Assuming the response data is an array of employees
      } catch (error) {
        console.error("Error fetching employees:", error);
        // Handle error, maybe show a message to the user
      }
    };
    fetchEmployees();
  }, []);



  useEffect(() => {
    const fetchEmployeeDetails = async (empId) => {
      try {
        const response = await AxiosInstance.get(`employee/id/${empId}`);
        console.log("employee details", response);
        setEmployeeDetails((prevDetails) => ({
          ...prevDetails,
          [empId]: response.data,
        }));
      } catch (error) {
        console.error("Error fetching employee details:", error);
      }
    };

    // Fetch employee details for each attendance issue
    attandanceIssue.forEach((attendance) => {
      fetchEmployeeDetails(attendance.employee_id);
    });
  }, [attandanceIssue]);
  // Filter attendance entries with status = "PENDING"
  const pendingAttendance = attandanceIssue.filter(
    (attendance) => attendance.status === "PENDING"
  );

  // Filter attendance entries within the date range
  const filteredAttendance = pendingAttendance.filter(
    (attendance) => attendance.date >= fromDate && attendance.date <= toDate
  );
  return (
    <div>
      <h4 className="py-3 mb-4" id="attIssues">
        Attendance Issues
      </h4>

      <div className=" card mb-3 p-3">
        <div className="input-group input-group-merge mt-3 " id="search">
          <span className="input-group-text" id="basic-addon-search31">
            <i className="bx bx-search" />
          </span>
          <input
            type="text"
            className="form-control"
            placeholder="Search..."
            aria-label="Search..."
            aria-describedby="basic-addon-search31"
          />
        </div>
      </div>

      <div className="card p-5 mt-5 ml-2 mr-3">
        <div className="row mt-1" id="date">
          <div className="mb-3 w-20 ">
            <div className="">
              From
              <input
                className="form-control btn-outline-primary dropdown-toggle"
                type="date"
                value={fromDate}
                onChange={(e) => setFromDate(e.target.value)}
                id="fromDate"
              />
            </div>
          </div>
          <div className="mb-3 w-20 ">
            <div className="">
              To
              <input
                className="form-control btn-outline-primary dropdown-toggle"
                type="date"
                value={toDate}
                onChange={(e) => setToDate(e.target.value)}
                id="toDate"
              />
            </div>
          </div>
        </div>
        <div className="card">
          <div className="table-responsive text-nowrap">
            <table className="table table-striped">
              <thead>
                <tr>
                  <th>Date</th>
                  <th>Employee Id</th>
                  <th>Name</th>
                  <th>Contact</th>
                  <th>Check-In</th>
                  <th>Check-Out</th>

                  <th>Action</th>
                </tr>
              </thead>
              <tbody className="table-border-bottom-0">
                {filteredAttendance.map((attendance, index) => (
                  <tr key={index}>
                    <td>{attendance.date}</td>
                    <td>{attendance.employeeId}</td>
                    <td>{employeeDetails[attendance.employee_id]?.firstName} {employeeDetails[attendance.employee_id]?.lastName}</td>
                    <td>{employeeDetails[attendance.employee_id]?.contactNumber}</td>
                    <td>{attendance.actual_check_in}</td>
                    <td>{attendance.actual_check_out}</td>

                    <td>
                      <button
                        type="button"
                        className="btn btn-primary"
                        data-bs-toggle="modal"
                        data-bs-target="#largeModal"
                      >
                        Add Leave
                      </button>

                      <div
                        class="modal fade"
                        id="largeModal"
                        tabindex="-1"
                        aria-hidden="true"
                      >
                        <div class="modal-dialog modal-lg" role="document">
                          <div class="modal-content">
                            <div class="modal-header">
                              <h5 class="modal-title" id="exampleModalLabel3">
                                Create Leave
                              </h5>
                              <button
                                type="button"
                                class="btn-close"
                                data-bs-dismiss="modal"
                                aria-label="Close"
                              ></button>
                            </div>
                            <div class="modal-body">
                              <AddLeaves />
                            </div>
                            <div class="modal-footer">
                              <button
                                type="button"
                                class="btn btn-outline-secondary"
                                data-bs-dismiss="modal"
                              >
                                Close
                              </button>
                              <button type="button" class="btn btn-primary">
                                Save changes
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
}

export default AttendanceIssues;
