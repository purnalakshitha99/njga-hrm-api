import React from "react";

export default function NavBar() {
  return (
    <div>
      <nav
        className="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
        id="layout-navbar"
      >
        <div className="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
          <a
            className="nav-item nav-link px-0 me-xl-4"
            href="javascript:void(0)"
          >
            <i className="bx bx-menu bx-sm" />
          </a>
        </div>
        <div
          className="navbar-nav-right d-flex align-items-center"
          id="navbar-collapse"
        >
          {/* Search */}

          <div className="navbar-nav align-items-center">
            <div className="nav-item d-flex align-items-center">
              <i className="bx bx-search fs-4 lh-0" />
              <input
                type="text"
                className="form-control border-0 shadow-none ps-1 ps-sm-2"
                placeholder="Search..."
                aria-label="Search..."
              />
            </div>
          </div>

          <ul className="navbar-nav flex-row align-items-center ms-auto">
            <li className="nav-item navbar-dropdown dropdown-user dropdown">
              <a
                className="nav-link dropdown-toggle hide-arrow"
                href="javascript:void(0);"
                data-bs-toggle="dropdown"
              >
                <div className="avatar avatar-online">
                  <img
                    src="./assests/img/avatars/1.png"
                    alt=""
                    className="w-px-40 h-auto rounded-circle"
                  />
                </div>
              </a>
            </li>
          </ul>
          {/*/ User */}
        </div>
      </nav>
    </div>
  );
}
