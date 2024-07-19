import React from "react";
import "../css/LeaveIssues.css";

function LeaveIssues() {
  return (
    <>
      <div className="content-wrapper">
        {/* Content */}
        <div className="container-xxl">
          <h4 className="py-3 mb-4">Leave issues</h4>

          <div className="d-flex justify-content-start ">
            <div className="mb-5" id="leave-issue-outer">
              <select id="defaultSelect2" className="form-select">
                <option>-Select-</option>
                <option value={1}>Short-Leave</option>
                <option value={2}>Half-Day</option>
                <option value={3}>Gate-Pass</option>
              </select>
            </div>
            <div className="mb-3 w-20  ">
              <div className="">
                <input
                  className="form-control  dropdown-toggle"
                  type="date"
                  defaultValue="2021-06-18"
                  id="html5-date-input"
                />
              </div>
            </div>
          </div>
          <div className="card">
            <div className="table-responsive text-nowrap">
              <table className="table table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Leave-Type</th>
                    <th>Check-out</th>
                    <th>Check-in</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody className="table-border-bottom-0">
                  <tr>
                    <td>
                      <span className="fw-medium">PT12345</span>
                    </td>
                    <td>Saman Kumara</td>
                    <td>2024/01/05</td>
                    <td>Short-Leave</td>
                    <td>09.50</td>
                    <td>11.20</td>
                    <td>
                      <div className="dropdown">
                        <button
                          type="button"
                          className="btn p-0 dropdown-toggle hide-arrow"
                          data-bs-toggle="dropdown"
                        >
                          <i className="bx bx-dots-vertical-rounded" />
                        </button>
                        <div className="dropdown-menu">
                          <a
                            className="dropdown-item"
                            data-bs-toggle="modal"
                            data-bs-target="#modalCenter"
                            href="javascript:void(0);"
                          >
                            <i className="bx bx-edit-alt me-1" />
                            Update
                          </a>
                          <a
                            className="dropdown-item"
                            href="javascript:void(0);"
                          >
                            <i className="bx bx-trash me-1" /> Delete
                          </a>
                        </div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <span className="fw-medium">PT12345</span>
                    </td>
                    <td>Saman Kumara</td>
                    <td>2024/01/05</td>
                    <td>Short-Leave</td>
                    <td>09.50</td>
                    <td>11.20</td>
                    <td>
                      <div className="dropdown">
                        <button
                          type="button"
                          className="btn p-0 dropdown-toggle hide-arrow"
                          data-bs-toggle="dropdown"
                        >
                          <i className="bx bx-dots-vertical-rounded" />
                        </button>
                        <div className="dropdown-menu">
                          <a
                            className="dropdown-item"
                            data-bs-toggle="modal"
                            data-bs-target="#modalCenter"
                            href="javascript:void(0); "
                          >
                            <i className="bx bx-edit-alt me-1" />
                            Update
                          </a>
                          <a
                            className="dropdown-item"
                            href="javascript:void(0);"
                          >
                            <i className="bx bx-trash me-1" /> Delete
                          </a>
                        </div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <span className="fw-medium">PT12345</span>
                    </td>
                    <td>Saman Kumara</td>
                    <td>2024/01/05</td>
                    <td>Short-Leave</td>
                    <td>09.50</td>
                    <td>11.20</td>
                    <td>
                      <div className="dropdown">
                        <button
                          type="button"
                          className="btn p-0 dropdown-toggle hide-arrow"
                          data-bs-toggle="dropdown"
                        >
                          <i className="bx bx-dots-vertical-rounded" />
                        </button>
                        <div className="dropdown-menu">
                          <a
                            className="dropdown-item"
                            href="javascript:void(0);"
                            data-bs-toggle="modal"
                            data-bs-target="#modalCenter"
                          >
                            <i className="bx bx-edit-alt me-1" />
                            Update
                          </a>
                          <a
                            className="dropdown-item"
                            href="javascript:void(0);"
                          >
                            <i className="bx bx-trash me-1" /> Delete
                          </a>
                        </div>
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>

            <div className="col-lg-4 col-md-6">
              <div className="mt-3">
                {/* Modal */}
                <div
                  className="modal fade"
                  id="modalCenter"
                  tabIndex={-1}
                  aria-hidden="true"
                >
                  <div
                    className="modal-dialog modal-dialog-centered"
                    role="document"
                  >
                    <div className="modal-content">
                      <div className="modal-header">
                        <h5 className="modal-title" id="modalCenterTitle">
                          Leave-Type
                        </h5>
                        <button
                          type="button"
                          className="btn-close"
                          data-bs-dismiss="modal"
                          aria-label="Close"
                        />
                      </div>
                      <div className="modal-body">
                        <div className="row">
                          <div className="col mb-3">
                            <label
                              htmlFor="nameWithTitle"
                              className="form-label"
                            >
                              Name
                            </label>
                            <input
                              type="text"
                              id="nameWithTitle"
                              className="form-control"
                              placeholder="Enter Name"
                            />
                          </div>
                        </div>
                        <div className="mb-3">
                          <label htmlFor="defaultSelect" className="form-label">
                            Change Type
                          </label>
                          <select id="defaultSelect" className="form-select">
                            <option>Default select</option>
                            <option value={1}>Short-Leave</option>
                            <option value={2}>Half-Day</option>
                            <option value={3}>Gate-Pass</option>
                          </select>
                        </div>
                        <div className="row g-2">
                          <div className="col mb-0">
                            <label
                              htmlFor="emailWithTitle"
                              className="form-label"
                            >
                              Check-Out
                            </label>
                            <input
                              type="time"
                              id="emailWithTitle"
                              className="form-control"
                            />
                          </div>
                          <div className="col mb-0">
                            <label
                              htmlFor="dobWithTitle"
                              className="form-label"
                            >
                              Check-In
                            </label>
                            <input
                              type="time"
                              id="dobWithTitle"
                              className="form-control"
                            />
                          </div>
                        </div>
                      </div>
                      <div className="modal-footer">
                        <button
                          type="button"
                          className="btn btn-outline-secondary"
                          data-bs-dismiss="modal"
                        >
                          Close
                        </button>
                        <button type="button" className="btn btn-primary">
                          Save changes
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          {/*              Content*/}
        </div>

      </div>
    </>
  );
}

export default LeaveIssues;
