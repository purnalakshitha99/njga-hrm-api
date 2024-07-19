import React from "react";
import Maternity from './custom/maternity.png'

function MaternityLeaves() {
  return (
    <div
      className="tab-pane fade "
      id="navs-top-maternityLeave"
      role="tabpanel"
    >
      <div className="row mb-4 d-flex gap-2">
        <h4>Maternity Leave </h4>
        <div className="col-3">
          <div className="">
            {/* Card content for Compulsory Leaves */}
            <div className="content-left">
              {/* <span>All Leaves</span> */}
              <img
                className="h-px-100 w-px-100 rounded overflow-hidden "
                id="medicalimage"
                src={Maternity}
                alt="maternity"
              />
              {/* <p class="mb-0">Total Leaves</p> */}
            </div>
          </div>
        </div>

        <div className="col-sm-6 col-xl">
          <div className="card h-px-100">
            {/* Card content for another Medical Leaves card */}
            <div className="d-flex align-items-center justify-content-between m-3">
              <div className="content-left">
                <div className="d-flex align-items-end mt-2">
                  <h4 className="mb-0 me-2">84 Days </h4>
                </div>
                <span>Remaining</span>
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
      {/* Filter item card */}
      <div className="col-md-12 card mb-4">
        <div className="card-body">
          {/* Content for the filter item card */}
          <div className="card-body">
            <div className="row">
              <div className="col-5">
                <div className="mb-3 row">
                  <label htmlFor="medicalid" className="form-label">
                    Date
                  </label>
                  <div className="col-md-8">
                    <input
                      className="form-control"
                      type="date"
                      defaultValue="2021-06-18"
                      id="medicalid"
                    />
                  </div>
                </div>
              </div>
              <div className="col-5">
                <div className="mb-3">
                  <label
                    htmlFor="exampleFormControlSelect1"
                    className="form-label"
                  >
                    Select Status
                  </label>
                  <select
                    className="form-select"
                    id="exampleFormControlSelect1"
                    aria-label="Default select example"
                  >
                    <option selected="">Open this select menu</option>
                    <option value={1}>Accept</option>
                                    <option value={2}>Reject</option>
                  </select>
                </div>
              </div>
              <div className="col-2">
                <button type="button" className="btn btn-primary mt-4 ">
                  Search
                </button>
              </div>
            </div>
          </div>
          <div className="ms-3">Results : 4 rows found</div>
        </div>
      </div>
      {/* Table of leaves */}
      <div className="col-md-12 card">
        <div className="card-body">
          {/* Content for the table of leaves */}
          {/*                            Table of leaves*/}
          <div className="table-responsive text-nowrap">
            <table className="table">
              <thead>
                <tr>
                  <th>From</th>
                  <th>To</th>
                 
                  <th>Status</th>
                </tr>
              </thead>
              <tbody className="table-border-bottom-0 ">
                <tr>
                  <td>
                    <span className="fw-medium">2022/03/31</span>
                  </td>
                  <td>2022/04/31</td>
                  
                  <td>
                    <span className="badge bg-label-primary me-1">Accept</span>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span className="fw-medium">2022/03/31</span>
                  </td>
                  <td>2022/04/31</td>
                  
                  <td>
                    <span className="badge bg-label-primary me-1">Accept</span>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span className="fw-medium">2022/03/31</span>
                  </td>
                  <td>2022/04/31</td>
                  
                  <td>
                    <span className="badge bg-label-primary me-1">Accept</span>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
}

export default MaternityLeaves;
