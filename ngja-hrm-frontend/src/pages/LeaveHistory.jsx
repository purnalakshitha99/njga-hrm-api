import React from "react";
import "../css/LeaveHistory.css";

function LeaveHistory() {
  return (
    <>
      <div className="container-xxl flex-grow-1 container-p-y ">
        <div className="row p-0 m-0 mb-4  d-flex justify-content-center">
          <div className="col-4">
            <div className="card">
              <div className="card-body">
                <div className="d-flex align-items-start justify-content-between">
                  <div className="">
                    <span>All Leaves</span>
                    <div className="d-flex align-items-end mt-2">
                      <h4 className="mb-0 me-2">30</h4>
                    </div>
                    {/*                                        <p class="mb-0">Total Leaves</p>*/}
                  </div>
                  <div className="avatar">
                    <span className="avatar-initial rounded bg-label-primary">
                      <i className="bx bx-user bx-sm" />
                    </span>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="col-4 ">
            <div className="card">
              <div className="card-body">
                <div className="d-flex align-items-start justify-content-between">
                  <div className="content-left">
                    <span>Rejected Leaves</span>
                    <div className="d-flex align-items-end mt-2">
                      <h4 className="mb-0 me-2">10</h4>
                    </div>
                    {/*                                        <p class="mb-0">Last week analytics </p>*/}
                  </div>
                  <div className="avatar">
                    <span className="avatar-initial rounded bg-label-danger">
                      <i className="bx bx-user-check bx-sm" />
                    </span>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="col-4">
            <div className="card">
              <div className="card-body">
                <div className="d-flex align-items-start justify-content-between">
                  <div className="content-left">
                    <span>Accepted Leaves</span>
                    <div className="d-flex align-items-end mt-2">
                      <h4 className="mb-0 me-2">5</h4>
                      {/*                                            <small class="text-danger">(-14%)</small>*/}
                    </div>
                    {/*                                        <p class="mb-0">Last week analytics</p>*/}
                  </div>
                  <div className="avatar">
                    <span className="avatar-initial rounded bg-label-success">
                      <i className="bx bx-group bx-sm" />
                    </span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        {/* Users List Table */}
        {/*                <div class="row mb-3">*/}
        {/*                    <div class="col-sm-6 ">*/}
        <div className="card">
          <div className="card-header">
            <div className="row mb-3">
              <h5 className="card-title">Search Filter</h5>
              {/*                        <div class="d-flex justify-content-between align-items-center row py-3 gap-3 gap-md-0">*/}
              <div className="d-flex justify-content-between align-items-center row gap-3 gap-md-0">
                <div className="col-md-4 user_role">
                  <select id="UserRole" className="form-select text-capitalize">
                    <option value="">Select Department</option>
                    <option value="Admin">IT</option>
                    <option value="Author">IT</option>
                    <option value="Editor">IT</option>
                  </select>
                </div>
                <div className="col-md-4 user_plan">
                  <select id="UserPlan" className="form-select text-capitalize">
                    <option value=""> Select Leave Type</option>
                    <option value="Basic">Gate Pass</option>
                    <option value="Company">Half Day</option>
                  </select>
                </div>
                <div className="col-md-4 user_status">
                  <select
                    id="FilterTransaction"
                    className="form-select text-capitalize"
                  >
                    <option value=""> Select Status</option>
                    <option value="Pending" className="text-capitalize">
                      Pending
                    </option>
                    <option value="Active" className="text-capitalize">
                      Accepted
                    </option>
                    <option value="Inactive" className="text-capitalize">
                      Rejected
                    </option>
                  </select>
                </div>
              </div>
              {/*                            <div class="col-sm-12 col-md-9">*/}
              {/*                                <div class="dt-action-buttons text-xl-end text-lg-start text-md-end text-start d-flex align-items-start justify-content-md-start justify-content-start flex-wrap me-1">*/}
              <div className="dt-action-buttons text-lg-start  ">
                <div className="me-3">
                  <div
                    id="DataTables_Table_0_filter"
                    className="dataTables_filter pt-4 w-100"
                  >
                    <label className="search ">
                      <input
                        type="search"
                        className="form-control     "
                        placeholder="Search Employee Name"
                        aria-controls="DataTables_Table"
                      />
                    </label>
                    <button
                      className="btn add-new btn-primary m-l-1 "
                      tabIndex={0}
                    >
                      <span>Search</span>
                    </button>
                  </div>
                </div>
                {/*                                </div>*/}
              </div>
            </div>
          </div>
        </div>
        <div className="card mt-4 ">
          <div className="card-header ">
            <div className="row mb-3 ">
              <div className="card-datatable table-responsive">
                <div
                  id="DataTables_Table_0_wrapper1"
                  className="dataTables_wrapper dt-bootstrap5 no-footer  "
                >
                  <table className="table table-striped mb-4">
                    <thead>
                      <tr>
                        <th>Name</th>
                        <th>Department</th>
                        <th>Leave_type</th>
                        <th>Date</th>
                        <th>In_time</th>
                        <th>Out_time</th>
                        <th>Status</th>
                      </tr>
                    </thead>
                    <tbody className="table-border-bottom-0">
                      <tr className="table-row">
                        <td>
                          <span className="">Viduth Ranaweera</span>
                        </td>
                        <td>IT</td>
                        <td>Gate Pass</td>
                        <td>2023-01-01</td>
                        <td>
                          <span className="p-1 rounded bg-label-danger me-1">
                            10-00am
                          </span>
                        </td>
                        <td>
                          <span className="p-1 rounded bg-label-danger me-1">
                            12-00pm
                          </span>
                        </td>
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
                              >
                                <i className="bx bx-edit-alt me-1" /> Edit
                              </a>
                              <a
                                className="dropdown-item"
                                href="javascript:void(0);"
                              >
                                <i className="bx bx-history me-1" /> View
                              </a>
                            </div>
                          </div>
                        </td>
                      </tr>
                      <tr className="table-row">
                        <td>
                          <span className="">Viduth Ranaweera</span>
                        </td>
                        <td>IT</td>
                        <td>Gate Pass</td>
                        <td>2023-01-01</td>
                        <td>
                          <span className="p-1 rounded bg-label-danger me-1">
                            10-00am
                          </span>
                        </td>
                        <td>
                          <span className="p-1 rounded bg-label-danger me-1">
                            12-00pm
                          </span>
                        </td>
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
                              >
                                <i className="bx bx-edit-alt me-1" /> Re-Post
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
                      <tr className="table-row">
                        <td>
                          <span className="">Viduth Ranaweera</span>
                        </td>
                        <td>IT</td>
                        <td>Gate Pass</td>
                        <td>2023-01-01</td>
                        <td>
                          <span className="p-1 rounded bg-label-danger me-1">
                            10-00am
                          </span>
                        </td>
                        <td>
                          <span className="p-1 rounded bg-label-danger me-1">
                            12-00pm
                          </span>
                        </td>
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
                              >
                                <i className="bx bx-edit-alt me-1" /> Re-Post
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
                      <tr className="table-row">
                        <td>
                          <span className="">Viduth Ranaweera</span>
                        </td>
                        <td>IT</td>
                        <td>Gate Pass</td>
                        <td>2023-01-01</td>
                        <td>
                          <span className="p-1 rounded bg-label-danger me-1">
                            10-00am
                          </span>
                        </td>
                        <td>
                          <span className="p-1 rounded bg-label-danger me-1">
                            12-00pm
                          </span>
                        </td>
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
                              >
                                <i className="bx bx-edit-alt me-1" /> Re-Post
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

                  <div className="row mx-2">
                    <div className="col-sm-12 col-md-6">
                      <div
                        style={{ textAlign: "left" }}
                        className="dataTables_info"
                        id="DataTables_Table_0_info"
                        role="status"
                        aria-live="polite"
                      >
                        Showing 1 to 10 of 50 entries
                      </div>
                    </div>
                    <div className="col-sm-12 col-md-6">
                      <div
                        className="dataTables_paginate paging_simple_numbers"
                        id="DataTables_Table_0_paginate"
                      >
                        <ul className="pagination">
                          <li
                            className="paginate_button page-item previous disabled"
                            id="DataTables_Table_0_previous"
                          >
                            <a
                              aria-controls="DataTables_Table_0"
                              aria-disabled="true"
                              role="link"
                              data-dt-idx="previous"
                              tabIndex={0}
                              className="page-link"
                            >
                              Previous
                            </a>
                          </li>
                          <li className="paginate_button page-item active">
                            <a
                              href="#"
                              aria-controls="DataTables_Table_0"
                              role="link"
                              aria-current="page"
                              data-dt-idx={0}
                              tabIndex={0}
                              className="page-link"
                            >
                              1
                            </a>
                          </li>
                          <li className="paginate_button page-item ">
                            <a
                              href="#"
                              aria-controls="DataTables_Table_0"
                              role="link"
                              data-dt-idx={1}
                              tabIndex={0}
                              className="page-link"
                            >
                              2
                            </a>
                          </li>
                          <li className="paginate_button page-item ">
                            <a
                              href="#"
                              aria-controls="DataTables_Table_0"
                              role="link"
                              data-dt-idx={2}
                              tabIndex={0}
                              className="page-link"
                            >
                              3
                            </a>
                          </li>
                          <li className="paginate_button page-item ">
                            <a
                              href="#"
                              aria-controls="DataTables_Table_0"
                              role="link"
                              data-dt-idx={3}
                              tabIndex={0}
                              className="page-link"
                            >
                              4
                            </a>
                          </li>
                          <li className="paginate_button page-item ">
                            <a
                              href="#"
                              aria-controls="DataTables_Table_0"
                              role="link"
                              data-dt-idx={4}
                              tabIndex={0}
                              className="page-link"
                            >
                              5
                            </a>
                          </li>
                          <li
                            className="paginate_button page-item next"
                            id="DataTables_Table_0_next"
                          >
                            <a
                              href="#"
                              aria-controls="DataTables_Table_0"
                              role="link"
                              data-dt-idx="next"
                              tabIndex={0}
                              className="page-link"
                            >
                              Next
                            </a>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default LeaveHistory;
