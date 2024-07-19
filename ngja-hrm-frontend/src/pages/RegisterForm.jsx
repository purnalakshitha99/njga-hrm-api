import React, { useEffect, useState } from "react";
import Swal from "sweetalert2";
import "../css/register.css";
import BasicDetails from "./registerPages/BasicDetails";
import AxiosInstance from "../api/Axios";
import CurrentWorkDetails from "./registerPages/CurrentWorkDetails";
import PreviousWorkHistory from "./registerPages/PreviousWorkHistory";
import EducationQualification from "./registerPages/EducationQualification";
import DependentDetails from "./registerPages/DependentDetails";
import EmergencyContact from "./registerPages/EmergencyContact";

export default function () {
  useEffect(() => {
    const handleImageUpload = (event) => {
      const input = event.target;
      const reader = new FileReader();

      reader.onload = () => {
        const image = document.getElementById("profile-image");
        if (image) {
          image.src = reader.result;
          image.style.display = "block"; // Show the image preview
        }
      };

      reader.readAsDataURL(input.files[0]);
    };

    const fileInput = document.getElementById("image-upload");
    if (fileInput) {
      fileInput.addEventListener("change", handleImageUpload);

      return () => {
        fileInput.removeEventListener("change", handleImageUpload);
      };
    }
  }, []);

  useEffect(() => {
    const form = document.getElementById("bs-validation-form");

    const handleSubmit = (event) => {
      event.preventDefault();
      form.classList.add("was-validated");

      const elements = form.elements;
      for (let i = 0; i < elements.length; i++) {
        if (!elements[i].checkValidity()) {
          elements[i].classList.add("is-invalid");
        }
      }
    };

    const handleInputChange = (event) => {
      const input = event.target;
      if (input.checkValidity()) {
        input.classList.remove("is-invalid");
      } else {
        input.classList.add("is-invalid");
      }
    };

    form.addEventListener("submit", handleSubmit);

    const inputs = form.querySelectorAll("input, textarea, select");
    inputs.forEach((input) => {
      input.addEventListener("input", handleInputChange);
    });

    // Cleanup function to remove event listeners when component unmounts
    return () => {
      form.removeEventListener("submit", handleSubmit);
      inputs.forEach((input) => {
        input.removeEventListener("input", handleInputChange);
      });
    };
  }, []);

  // Placeholder for the other useEffect functions and handlers...

  return (
    <div>
      <div className="nav-align-top mb-3 container-xxl">
        <h4 className="py-3 mb-4">Register</h4>
        <ul className="nav nav-tabs" role="tablist">
          <li className="nav-item" role="presentation">
            <button
              className="nav-link active"
              data-bs-toggle="tab"
              data-bs-target="#form-tabs-personal"
              role="tab"
              aria-selected="true"
            >
              Basic Details
            </button>
          </li>
          <li className="nav-item" role="presentation">
            <button
              className="nav-link"
              data-bs-toggle="tab"
              data-bs-target="#form-tabs-account"
              role="tab"
              aria-selected="false"
              tabIndex={-1}
            >
              Work Details
            </button>
          </li>
          <li className="nav-item" role="presentation">
            <button
              className="nav-link"
              data-bs-toggle="tab"
              data-bs-target="#form-tabs-social"
              role="tab"
              aria-selected="false"
              tabIndex={-1}
            >
              Previous Work
            </button>
          </li>
          <li className="nav-item" role="presentation">
            <button
              className="nav-link"
              data-bs-toggle="tab"
              data-bs-target="#form-tabs-education"
              role="tab"
              aria-selected="false"
              tabIndex={-1}
            >
              Education Qualification
            </button>
          </li>
          <li className="nav-item" role="presentation">
            <button
              className="nav-link"
              data-bs-toggle="tab"
              data-bs-target="#form-tabs-dependent"
              role="tab"
              aria-selected="false"
              tabIndex={-1}
            >
              Dependent Details
            </button>
          </li>
          <li className="nav-item" role="presentation">
            <button
              className="nav-link"
              data-bs-toggle="tab"
              data-bs-target="#form-tabs-emergency"
              role="tab"
              aria-selected="false"
              tabIndex={-1}
            >
              Emergency
            </button>
          </li>
        </ul>

        <div className="tab-content">
          <div
            className="tab-pane fade active show"
            id="form-tabs-personal"
            role="tabpanel"
          >
            <div className="d-flex justify-content-start mb-3">
              <p className="d-inline fs-4">Basic Details</p>
              <p className="d-inline p-2 text-danger">*Required</p>
            </div>
            <BasicDetails />
          </div>
          <div className="tab-pane fade" id="form-tabs-account" role="tabpanel">
            <div className="d-flex justify-content-start">
              <p className="d-inline fs-4 ">Current Work Details</p>
              <p className="d-inline p-2 mb-2 text-danger ">*Required</p>
            </div>
            <CurrentWorkDetails />
          </div>

          <div className="tab-pane" id="form-tabs-social" role="tabpanel">
            <div id="form-container">
              <div className="form-container" id="form-container-1">
                <p className="fs-4 d-flex justify-content-start mb-3">
                  Previous Work History
                </p>
                <PreviousWorkHistory />
              </div>
            </div>
          </div>

          <div
            className="tab-pane fade"
            id="form-tabs-education"
            role="tabpanel"
          >
            <div id="form-container">
              <div className="form-container" id="form-container-1">
                <p className="fs-4 d-flex justify-content-start mb-3">
                  Education Qualification
                </p>
                <EducationQualification />
              </div>
            </div>
          </div>

          <div
            className="tab-pane fade"
            id="form-tabs-dependent"
            role="tabpanel"
          >
            <div className="mb-3">
              <p className="d-inline fs-4 d-flex justify-content-start mb-4">
                Dependent Details
              </p>
            </div>
            <DependentDetails />
          </div>

          <div
            className="tab-pane fade"
            id="form-tabs-emergency"
            role="tabpanel"
          >
            <div className="mb-3 d-flex justify-content-start">
              <p className="d-inline fs-4">Emergency Contact</p>
              <p className="d-inline p-2 text-danger">*Required</p>
            </div>
            <EmergencyContact />
          </div>
        </div>
      </div>
    </div>
  );
}
