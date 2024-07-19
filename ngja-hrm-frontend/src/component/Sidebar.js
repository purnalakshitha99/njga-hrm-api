import React, { useState } from "react";
import "../css/sidebar.css";
import { Link } from "react-router-dom";

export default function Sidebar() {
  const [activeItem, setActiveItem] = useState(null);
  const [activeMenuItem, setActiveMenuItem] = useState(null);
  const [employeeDropdownOpen, setEmployeeDropdownOpen] = useState(false);
  const [leavesDropdownOpen, setLeavesDropdownOpen] = useState(false);
  const [sidebarOpen, setSidebarOpen] = useState(true); // Track sidebar open/close state

  const handleMenuItemClick = (menuItem) => {
    setActiveMenuItem(menuItem);
  };

  const handleItemClick = (itemName) => {
    if (activeItem === itemName) {
      setActiveItem(null); // Deselect the item if it's already active
    } else {
      setActiveItem(itemName); // Set the clicked item as active
      setEmployeeDropdownOpen(false);
      setLeavesDropdownOpen(false);
    }
  };

  const closeDropdowns = () => {
    setEmployeeDropdownOpen(false);
    setLeavesDropdownOpen(false);
    setActiveItem(null);
  };

  const handleEmployeeDropdownToggle = () => {
    setEmployeeDropdownOpen(!employeeDropdownOpen);
    setLeavesDropdownOpen(false); // Close other dropdowns
    setActiveItem(null);
  };

  const handleLeavesDropdownToggle = () => {
    setLeavesDropdownOpen(!leavesDropdownOpen);
    setEmployeeDropdownOpen(false); // Close other dropdowns
    setActiveItem(null);
  };

  const toggleSidebar = () => {
    setSidebarOpen(!sidebarOpen);
    closeDropdowns(); // Close all dropdowns when sidebar is closed
  };

  return (
    <nav className={`sidebar ${sidebarOpen ? "open" : "close"}`}>
      {/* Sidebar content goes here */}
      <div>
        <header>
          <div className="image-text">
            <span className="image">
              <img src="logo.png" alt="" />
            </span>
            <div className="text logo-text">
              <span className="sidebar-title text-uppercase text-truncate app-brand-text demo menu-text fw-bold ms-2">
                NGJA
              </span>
            </div>
          </div>
          <i className="bx bx-chevron-right toggle" onClick={toggleSidebar} />
        </header>

        <div className="menu-bar">
          <div className="menu">
            <ul className="menu-links">
              <li
                className={`nav-link ${
                  activeItem === "Dashboard" ? "active-item" : ""
                }`}
                onClick={() => handleItemClick("Dashboard")}
              >
                {" "}
                <Link
                  to={"/"}
                  className="d-inline-flex align-items-center rounded border-0 collapsed d-flex p-2"
                >
                  <i className="menu-icon tf-icons bx bx-home-circle" />
                  <div className="text-truncate ml-3" data-i18n="Dashboard">
                    Dashboard
                  </div>
                </Link>
              </li>

              <li className="nav-link">
                <div
                  className={`btn-toggle ${
                    employeeDropdownOpen ? "active-item" : ""
                  }`}
                  onClick={handleEmployeeDropdownToggle}
                >
                  <div className="d-inline-flex align-items-center d-flex p-2">
                    <i className="menu-icon tf-icons bx bx-user"></i>{" "}
                    <div className="text-truncate ml-3" data-i18n="Employee">
                      Employee
                      <i
                        className={`bx ${
                          employeeDropdownOpen
                            ? "bx-chevron-down"
                            : "bx-chevron-right"
                        } toggle`}
                        style={{ marginLeft: "60px" }}
                      />
                    </div>
                  </div>
                </div>
              </li>

              <div className={`collapse ${employeeDropdownOpen ? "show" : ""}`}>
                <ul className="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li className="menu-item">
                    <Link
                      to={"/all-employees"}
                      className={`link-body-emphasis d-inline-flex text-decoration-none rounded ${
                        activeMenuItem === "allEmployees"
                          ? "active-menu-item"
                          : ""
                      }`}
                      style={{
                        marginLeft: "30px",

                        opacity: "0.7",
                        color: activeMenuItem === "allEmployees" ? "black" : "",
                        // backgroundColor:
                        //   activeMenuItem === "allEmployees" ? "gray" : "",
                      }}
                      onClick={() => handleMenuItemClick("allEmployees")}
                    >
                      <span
                        className="dot"
                        style={{
                          marginRight: "27px",
                          color:
                            activeMenuItem === "allEmployees" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "allEmployees" ? "30px" : "12px",
                        }}
                      >
                        &#8226;
                      </span>
                      <span
                        style={{
                          color:
                            activeMenuItem === "allEmployees" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "allEmployees" ? "18px" : "16px",
                        }}
                      >
                        All Employees
                      </span>
                    </Link>
                  </li>

                  <li className="menu-item">
                    <Link
                      to={"/register"}
                      className={`link-body-emphasis d-inline-flex text-decoration-none rounded ${
                        activeMenuItem === "register" ? "active-menu-item" : ""
                      }`}
                      style={{
                        marginLeft: "30px",

                        opacity: "0.7",
                      }}
                      onClick={() => handleMenuItemClick("register")}
                    >
                      <span
                        className="dot"
                        style={{
                          marginRight: "27px",
                          color: activeMenuItem === "register" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "register" ? "30px" : "12px",
                        }}
                      >
                        &#8226;
                      </span>{" "}
                      <span
                        style={{
                          color: activeMenuItem === "register" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "register" ? "18px" : "16px",
                        }}
                      >
                        Register
                      </span>
                    </Link>
                  </li>


                  <li className="menu-item">
                    <Link
                      to={"/finger-print"}
                      className={`link-body-emphasis d-inline-flex text-decoration-none rounded ${
                        activeMenuItem === "fingerprint"
                          ? "active-menu-item"
                          : ""
                      }`}
                      style={{
                        marginLeft: "30px",

                        opacity: "0.7",
                        color: activeMenuItem === "fingerprint" ? "black" : "",
                        // backgroundColor:
                        //   activeMenuItem === "allEmployees" ? "gray" : "",
                      }}
                      onClick={() => handleMenuItemClick("fingerprint")}
                    >
                      <span
                        className="dot"
                        style={{
                          marginRight: "27px",
                          color:
                            activeMenuItem === "fingerprint" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "fingerprint" ? "30px" : "12px",
                        }}
                      >
                        &#8226;
                      </span>
                      <span
                        style={{
                          color:
                            activeMenuItem === "fingerprint" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "fingerprint" ? "18px" : "16px",
                        }}
                      >
                        Finger Print
                      </span>
                    </Link>
                  </li>

                  <li className="menu-item">
                    <Link
                      to={"/attendence"}
                      className={`link-body-emphasis d-inline-flex text-decoration-none rounded ${
                        activeMenuItem === "Attendance" ? "active-menu-item" : ""
                      }`}
                      style={{
                        marginLeft: "30px",

                        opacity: "0.7",
                      }}
                      onClick={() => handleMenuItemClick("Attendance")}
                    >
                      <span
                        className="dot"
                        style={{
                          marginRight: "27px",
                          color: activeMenuItem === "Attendance" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "Attendance" ? "30px" : "12px",
                        }}
                      >
                        &#8226;
                      </span>{" "}
                      <span
                        style={{
                          color: activeMenuItem === "Attendance" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "Attendance" ? "18px" : "16px",
                        }}
                      >
                        Attendance
                      </span>
                    </Link>
                  </li>
                  <li className="menu-item">
                    <Link
                      to={"/attendance-issues"}
                      className={`link-body-emphasis d-inline-flex text-decoration-none rounded ${
                        activeMenuItem === "Attendance-issues" ? "active-menu-item" : ""
                      }`}
                      style={{
                        marginLeft: "30px",

                        opacity: "0.7",
                      }}
                      onClick={() => handleMenuItemClick("Attendance-issues")}
                    >
                      <span
                        className="dot"
                        style={{
                          marginRight: "27px",
                          color: activeMenuItem === "Attendance-issues" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "Attendance-issues" ? "30px" : "12px",
                        }}
                      >
                        &#8226;
                      </span>{" "}
                      <span
                        style={{
                          color: activeMenuItem === "Attendance-issues" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "Attendance-issues" ? "18px" : "16px",
                        }}
                      >
                        Attendance Issues
                      </span>
                    </Link>
                  </li>
                </ul>
              </div>

              <li className="nav-link">
                <div
                  className={`btn-toggle ${
                    leavesDropdownOpen ? "active-item" : ""
                  }`}
                  onClick={handleLeavesDropdownToggle}
                >
                  <div className="d-inline-flex align-items-center d-flex p-2">
                    <i className="menu-icon tf-icons bx bx-detail"></i>
                    <div className="text-truncate ml-3" data-i18n="Employee">
                      Leaves
                      <i
                        className={`bx ${
                          leavesDropdownOpen
                            ? "bx-chevron-down"
                            : "bx-chevron-right"
                        } toggle`}
                        style={{ marginLeft: "85px" }}
                      />
                    </div>
                  </div>
                </div>
              </li>

              <div className={`collapse ${leavesDropdownOpen ? "show " : ""}`}>
                <ul className="btn-toggle-nav list-unstyled fw-normal pb-1 ">
                  <li className="menu-item">
                    <Link
                      to={"/leave-history"}
                      className={`link-body-emphasis d-inline-flex text-decoration-none rounded ${
                        activeMenuItem === "history" ? "active-menu-item" : ""
                      }`}
                      style={{
                        marginLeft: "33px",

                        opacity: "0.7",
                      }}
                      onClick={() => handleMenuItemClick("history")}
                    >
                      <span
                        className="dot"
                        style={{
                          marginRight: "27px",
                          color: activeMenuItem === "history" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "history" ? "30px" : "12px",
                        }}
                      >
                        &#8226;
                      </span>{" "}
                      <span
                        style={{
                          color: activeMenuItem === "history" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "history" ? "18px" : "16px",
                        }}
                      >
                        History
                      </span>
                    </Link>
                  </li>

                  <li className="menu-item">
                    <Link
                      to={"/leave-profile"}
                      className={`link-body-emphasis d-inline-flex text-decoration-none rounded ${
                        activeMenuItem === "profile" ? "active-menu-item" : ""
                      }`}
                      style={{
                        marginLeft: "32px",

                        opacity: "0.7",
                        opacity: "0.7",
                      }}
                      onClick={() => handleMenuItemClick("profile")}
                    >
                      <span
                        className="dot"
                        style={{
                          marginRight: "27px",
                          color: activeMenuItem === "profile" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "profile" ? "30px" : "12px",
                        }}
                      >
                        &#8226;
                      </span>
                      <span
                        style={{
                          color: activeMenuItem === "profile" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "profile" ? "18px" : "16px",
                        }}
                      >
                        Leave Profile
                      </span>
                    </Link>
                  </li>
                  <li className="menu-item">
                    <Link
                      to={"/pending-leaves"}
                      className={`link-body-emphasis d-inline-flex text-decoration-none rounded ${
                        activeMenuItem === "pending" ? "active-menu-item" : ""
                      }`}
                      style={{
                        marginLeft: "32px",

                        opacity: "0.7",
                        opacity: "0.7",
                      }}
                      onClick={() => handleMenuItemClick("pending")}
                    >
                      <span
                        className="dot"
                        style={{
                          marginRight: "27px",
                          color: activeMenuItem === "pending" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "pending" ? "30px" : "12px",
                        }}
                      >
                        &#8226;
                      </span>
                      <span
                        style={{
                          color: activeMenuItem === "pending" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "pending" ? "18px" : "16px",
                        }}
                      >
                        Pending Leaves
                      </span>
                    </Link>
                  </li>
                  <li className="menu-item">
                    <Link
                      to={"/leave-issues"}
                      className={`link-body-emphasis d-inline-flex text-decoration-none rounded ${
                        activeMenuItem === "issues" ? "active-menu-item" : ""
                      }`}
                      // className="text-truncate mb-0"
                      // data-i18n="Attendance"
                      style={{
                        marginLeft: "31px",

                        opacity: "0.7",
                      }}
                      onClick={() => handleMenuItemClick("issues")}
                    >
                      <span
                        className="dot"
                        style={{
                          marginRight: "27px",
                          color: activeMenuItem === "issues" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "issues" ? "30px" : "12px",
                        }}
                      >
                        &#8226;
                      </span>
                      <span
                        style={{
                          color: activeMenuItem === "issues" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "issues" ? "18px" : "16px",
                        }}
                      >
                        Leave Issues
                      </span>
                    </Link>
                  </li>
                </ul>
              </div>
              <li
                className={`nav-link ${
                  activeItem === "notice" ? "active-item" : ""
                }`}
                onClick={() => handleItemClick("notice")}
              >
                <Link
                  to={"./notice"}
                  className="d-inline-flex align-items-center rounded border-0 collapsed d-flex p-2 "
                  style={{
                    color: activeItem === "notice" ? "blue" : "#697A8D",
                  }}
                >
                  <i class="bx bx-notepad me-2"></i>
                  <div className="text-truncate ml-3 ">Notice</div>
                </Link>
              </li>

              {/* <li
                className={`nav-link ${
                  activeItem === "noticet" ? "active-item" : ""
                }`}
                onClick={() => handleItemClick("noticet")}
              >
                <Link
                  to={"/notice"}
                  className="d-inline-flex align-items-center rounded border-0 collapsed d-flex p-2 "
                >
                  <i class="bx bx-notepad me-2"></i>
                  <span
                        className="dot"
                        style={{
                          marginRight: "27px",
                          color: activeMenuItem === "profile" ? "blue" : "",
                          fontSize:
                            activeMenuItem === "profile" ? "30px" : "12px",
                        }}
                      >Notice</span>
                 
                </Link>
              </li> */}

              <li
                className={`nav-link ${
                  activeItem === "Sign Out" ? "active-item" : ""
                }`}
                onClick={() => handleItemClick("Sign Out")}
              >
                <a
                  className="d-inline-flex align-items-center rounded border-0 collapsed d-flex p-2 "
                  style={{
                    color: activeItem === "notice" ? "#697A8D" : "",
                  }}
                >
                  <i class="bx bx-power-off me-2"></i>
                  <div className="text-truncate ml-3 " data-i18n="Dashboard">
                    Sign Out
                  </div>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>
  );
}
