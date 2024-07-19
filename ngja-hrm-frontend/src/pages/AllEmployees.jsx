import React from "react";
import { Link } from "react-router-dom";
import '../css/Employee.css'


function AllEmployees() {
  return (
    <div>
     
      <div className="container-xxl flex-grow-1  ">
        <h4 className="py-3 mb-4">Employees</h4>
        {/*              Content*/}
        {/*               search bar*/}
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
        <div className="row py-2 ">
          <div className="col-lg col-12">
            <div>
              <div className="row ">
                <div className="col-12 mb-2 mb-md-0 col-md ">
                  <div>
                    <select
                      className="form-select "
                      
                      aria-label="Default select example"
                    >
                      <option selected="">By Branch</option>
                      <option value={1}>Colombo</option>
                      <option value={2}>Ratnapura</option>
                      <option value={3}>Galle</option>
                    </select>
                  </div>
                </div>
                <div className="col-12 mb-2 mb-md-0 col-md">
                  <div>
                    <select
                      className="form-select"
                     
                      aria-label="Default select example"
                    >
                      <option selected="">By Department</option>
                      <option value={1}>Gem</option>
                      <option value={2}>Jewellery</option>
                      <option value={3}>License</option>
                    </select>
                  </div>
                </div>
                <div className="col-12 mb-2 mb-md-0 col-md">
                  <div>
                    <select
                      className="form-select"
                    
                      aria-label="Default select example"
                    >
                      <option selected="">By Category</option>
                      <option value={1}>Standard</option>
                      <option value={2}>PL</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="mt-3 ">
            <button type="button" className="btn btn-primary">
              <span>
              <i class='bx bx-user-plus'></i>
              </span>
              Add Employee
            </button>
          </div>
        </div>
        </div>
        {/*              add button*/}
        {/*              filter by */}
        {/*              table*/}
        <div className="card " id="employees">
          <h5 className="card-header" id="emphead">All Employees</h5>
          <div className="table-responsive text-nowrap">
            <table className="table">
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Name</th>
                  <th>Contact Number</th>
                  <th>Branch</th>
                  <th>Department</th>
                  <th>Category</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody className="table-border-bottom-0">
                <tr>
                  <td>
                    <span className="fw-medium">15567</span>
                  </td>
                  <td>Albert Cook</td>
                  <td>
                    <span className="fw-medium">0716598265</span>
                  </td>
                  <td>
                    <span className="fw-medium">Colombo</span>
                  </td>
                  <td>
                    <span className="fw-medium">Gem</span>
                  </td>
                  <td>
                    <span className="fw-medium">Standard</span>
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
                        <a className="dropdown-item" href="javascript:void(0);">
                          <i className="bx bx-edit-alt me-1" /> Edit
                        </a>
                        <Link to={'/user-profile'} className="dropdown-item" href="javascript:void(0);">
                        <i class='bx bx-user-circle'/> View Profile
                        </Link>
                      </div>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span className="fw-medium">15568</span>
                  </td>
                  <td>Sasida Dilhan</td>
                  <td>
                    <span className="fw-medium">0756987159</span>
                  </td>
                  <td>
                    <span className="fw-medium">Colombo</span>
                  </td>
                  <td>
                    <span className="fw-medium">Gem</span>
                  </td>
                  <td>
                    <span className="fw-medium">Standard</span>
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
                        <a className="dropdown-item" href="javascript:void(0);">
                          <i className="bx bx-edit-alt me-1" /> Edit
                        </a>
                        <a className="dropdown-item" href="javascript:void(0);">
                        <i class='bx bx-user-circle'/> View Profile
                        </a>
                      </div>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span className="fw-medium">15569</span>
                  </td>
                  <td>Purna Lakshitha</td>
                  <td>
                    <span className="fw-medium">0716598265</span>
                  </td>
                  <td>
                    <span className="fw-medium">Ratnapura</span>
                  </td>
                  <td>
                    <span className="fw-medium">Gem</span>
                  </td>
                  <td>
                    <span className="fw-medium">PL</span>
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
                        <a className="dropdown-item" href="javascript:void(0);">
                          <i className="bx bx-edit-alt me-1" /> Edit
                        </a>
                        <a className="dropdown-item" href="javascript:void(0);">
                        <i class='bx bx-user-circle'/> View Profile
                        </a>
                      </div>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span className="fw-medium">15570</span>
                  </td>
                  <td>Dasun Kavinga</td>
                  <td>
                    <span className="fw-medium">0773615752</span>
                  </td>
                  <td>
                    <span className="fw-medium">Galle</span>
                  </td>
                  <td>
                    <span className="fw-medium">Jewellery</span>
                  </td>
                  <td>
                    <span className="fw-medium">Standard</span>
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
                        <a className="dropdown-item" href="javascript:void(0);">
                          <i className="bx bx-edit-alt me-1" /> Edit
                        </a>
                        <a className="dropdown-item" href="javascript:void(0);">
                        <i class='bx bx-user-circle'/> View Profile
                        </a>
                      </div>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span className="fw-medium">15580</span>
                  </td>
                  <td>Chanaka Nagoda</td>
                  <td>
                    <span className="fw-medium">0751436751</span>
                  </td>
                  <td>
                    <span className="fw-medium">Colombo</span>
                  </td>
                  <td>
                    <span className="fw-medium">Gem</span>
                  </td>
                  <td>
                    <span className="fw-medium">Standard</span>
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
                        <a className="dropdown-item" href="javascript:void(0);">
                          <i className="bx bx-edit-alt me-1" /> Edit
                        </a>
                        <a className="dropdown-item" href="javascript:void(0);">
                        <i class='bx bx-user-circle'/> View Profile
                        </a>
                      </div>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        {/*/ Basic Bootstrap Table */}
        {/*pagination */}
        
       
        <div className="pegination-custom">
        <nav aria-label="Page navigation" id="pagination">
                <ul className="pagination">
                  <li className="page-item first">
                    <a className="page-link" href="javascript:void(0);">
                      <i className="tf-icon bx bx-chevrons-left" />
                    </a>
                  </li>
                  <li className="page-item prev">
                    <a className="page-link" href="javascript:void(0);">
                      <i className="tf-icon bx bx-chevron-left" />
                    </a>
                  </li>
                  <li className="page-item">
                    <a className="page-link" href="javascript:void(0);">
                      1
                    </a>
                  </li>
                  <li className="page-item">
                    <a className="page-link" href="javascript:void(0);">
                      2
                    </a>
                  </li>
                  <li className="page-item active">
                    <a className="page-link" href="javascript:void(0);">
                      3
                    </a>
                  </li>
                  <li className="page-item">
                    <a className="page-link" href="javascript:void(0);">
                      4
                    </a>
                  </li>
                  <li className="page-item">
                    <a className="page-link" href="javascript:void(0);">
                      5
                    </a>
                  </li>
                  <li className="page-item next">
                    <a className="page-link" href="javascript:void(0);">
                      <i className="tf-icon bx bx-chevron-right" />
                    </a>
                  </li>
                  <li className="page-item last">
                    <a className="page-link" href="javascript:void(0);">
                      <i className="tf-icon bx bx-chevrons-right" />
                    </a>
                  </li>
                </ul>
              </nav>
        </div>
     
      </div>
     
    </div>
  );
}

export default AllEmployees;
