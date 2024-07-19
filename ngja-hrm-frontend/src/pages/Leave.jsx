import React from "react";
// import Annual from '../../public/assets/img/custom/annual.png'
import Image1 from "../avatars/10.png";
import MedicalLeaves from "./leaveProfile/MedicalLeaves";
import CasualLeaves from "./leaveProfile/CasualLeaves";
import AnnualLeaves from "./leaveProfile/AnnualLeaves";
import NotCovering from "./leaveProfile/NotCovering";
import GatePassLeaves from "./leaveProfile/GatePassLeaves";
import CompulsoryLeaves from "./leaveProfile/CompulsoryLeaves";
import ShortLeaves from "../pages/leaveProfile/ShortLeaves";
import HalfDayLeaves from "./leaveProfile/HalfDayLeaves";
import LeaveToLeave from "./leaveProfile/LeaveToLeave";
import MaternityLeaves from "./leaveProfile/MaternityLeaves";
import Profile from "./leaveProfile/Profile";
import ContactDetails from "./leaveProfile/ContactDetails";

function Leave() {
  return (
    <div>
      <div className="content-wrapper">
        {/* Content */}
        <div className="container-xxl flex-grow-1 container-p-y">
          <h4 className="py-3 mb-4 d-flex justify-item-start">
            <span className="text-muted fw-light">Profile/</span> Leave{" "}
          </h4>
          {/* Basic Layout */}
          <div className="row">
            <Profile/>
            <ContactDetails/>
            {/*                        three type of leaves*/}
            <div className="row mt-3">
              <div className="col">
                <div className="nav-align-top mb-4">
                  <ul className="nav nav-tabs" role="tablist">
                    <li className="nav-item">
                      <button
                        type="button"
                        className="nav-link active"
                        role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-top-medical"
                        aria-controls="navs-top-medical"
                        aria-selected="true"
                      >
                        Medical
                      </button>
                    </li>
                    <li className="nav-item">
                      <button
                        type="button"
                        className="nav-link"
                        role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-top-casual"
                        aria-controls="navs-top-casual"
                        aria-selected="false"
                      >
                        Casual
                      </button>
                    </li>
                    <li className="nav-item">
                      <button
                        type="button"
                        className="nav-link"
                        role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-top-annual"
                        aria-controls="navs-top-annual"
                        aria-selected="false"
                      >
                        Annual
                      </button>
                    </li>
                    <li className="nav-item">
                      <button
                        type="button"
                        className="nav-link"
                        role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-top-notCovering"
                        aria-controls="navs-top-notCovering"
                        aria-selected="false"
                      >
                        Not Covering
                      </button>
                    </li>
                    <li className="nav-item">
                      <button
                        type="button"
                        className="nav-link"
                        role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-top-compulsory"
                        aria-controls="navs-top-compulsory"
                        aria-selected="false"
                      >
                        Compulsory
                      </button>
                    </li>
                    <li className="nav-item">
                      <button
                        type="button"
                        className="nav-link"
                        role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-top-shortLeave"
                        aria-controls="navs-top-shortLeave"
                        aria-selected="false"
                      >
                        Short Leave
                      </button>
                    </li>
                    <li className="nav-item">
                      <button
                        type="button"
                        className="nav-link"
                        role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-top-gatePass"
                        aria-controls="navs-top-gatePass"
                        aria-selected="false"
                      >
                        Gate Pass
                      </button>
                    </li>
                    <li className="nav-item">
                      <button
                        type="button"
                        className="nav-link"
                        role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-top-halfDay"
                        aria-controls="navs-top-halfDay"
                        aria-selected="false"
                      >
                        Half Day
                      </button>
                    </li>
                    <li className="nav-item">
                      <button
                        type="button"
                        className="nav-link"
                        role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-top-leaveToLeave"
                        aria-controls="navs-top-leaveToLeave"
                        aria-selected="false"
                      >
                        Leave to Leave
                      </button>
                    </li>
                    <li className="nav-item">
                      <button
                        type="button"
                        className="nav-link"
                        role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-top-maternityLeave"
                        aria-controls="navs-top-maternityLeave"
                        aria-selected="false"
                      >
                        Maternity Leave
                      </button>
                    </li>
                  </ul>
                  <div className="tab-content" id="tabcont">
                    {/*medical section*/}

                    <MedicalLeaves />

                    {/*                                            casual section*/}
                    <CasualLeaves />
                    {/*                                        Annual Section*/}
                    <AnnualLeaves />
                    {/*                                        Not covering Section*/}
                    <NotCovering />

                    {/* compulsory section */}

                    <CompulsoryLeaves />

                    {/*                                        Short leave Section*/}

                    <ShortLeaves />

                    {/*                                        Gate pass Section*/}

                    <GatePassLeaves />

                    {/*                                        HalfDay Section*/}
                    <HalfDayLeaves />
                    {/*                                       Leave to Leave Section*/}
                    <LeaveToLeave />
                    {/*                                       maternity leave Section*/}
                    <MaternityLeaves />
                    {/* maternity end */}
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        {/* / Content */}
        
        <div className="content-backdrop fade" />
      </div>
    </div>
  );
}

export default Leave;
