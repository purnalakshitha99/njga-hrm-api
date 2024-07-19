import React from "react";

function NoticeHistory() {
  return (
    <>
      <div className="tab-pane fade " id="navs-top-profile" role="tabpanel">
        <div className="card">
          <div className="table-responsive text-nowrap">
            <table className="table table-striped">
              <thead>
                <tr>
                  <th>Title</th>
                  <th>Date</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody className="table-border-bottom-0">
                <tr className="table-row">
                  <td>
                    <span className="">Angular Project</span>
                  </td>
                  <td>2024/01/07</td>
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
                          <i className="bx bx-edit-alt me-1" /> Re-Post
                        </a>
                        <a className="dropdown-item" href="javascript:void(0);">
                          <i className="bx bx-trash me-1" /> Delete
                        </a>
                      </div>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span className="fw-medium">React Project</span>
                  </td>
                  <td>2024/01/03</td>
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
                          <i className="bx bx-edit-alt me-1" /> Re-Post
                        </a>
                        <a className="dropdown-item" href="javascript:void(0);">
                          <i className="bx bx-trash me-1" /> Delete
                        </a>
                      </div>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span className="fw-medium">VueJs Project</span>
                  </td>
                  <td>2024/01/01</td>
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
                          <i className="bx bx-edit-alt me-1" /> Re-Post
                        </a>
                        <a className="dropdown-item" href="javascript:void(0);">
                          <i className="bx bx-trash me-1" /> Delete
                        </a>
                      </div>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span className="fw-medium">Bootstrap Project</span>
                  </td>
                  <td>2023/12/30</td>
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
                          <i className="bx bx-edit-alt me-1" /> Re-Post
                        </a>
                        <a className="dropdown-item" href="javascript:void(0);">
                          <i className="bx bx-trash me-1" /> Delete
                        </a>
                      </div>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </>
  );
}

export default NoticeHistory;
