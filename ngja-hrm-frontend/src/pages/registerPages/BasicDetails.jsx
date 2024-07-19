import React, { useState } from "react";
import AxiosInstance from "../../api/Axios";

const BasicDetails = () => {
  const [formData, setFormData] = useState({
    first_name: "",
    last_name: "",
    nic: "",
    gender: "",
    dob: "",
    email: "",
    address: "",
    contact_number: "",
  });
  console.log(formData);
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async () => {
    try {
      const response = await AxiosInstance.post("employees", formData);
      console.log("Response:", response);
      alert("Basic details saved successfully!");
    } catch (error) {
      console.error("Error saving basic details:", error);
      alert(
        "An error occurred while saving basic details. Please try again later."
      );
    }
  };

  return (
    <div class="">
      <div class="">
        <form
          class="needs-validation"
          // onSubmit={handleSubmit}
          novalidate
          id="bs-validation-form2"
        >
          <div class="row">
            <div class="mb-3 col-xl-6">
              <label
                class="form-label d-flex justify-content-start"
                for="bs-validation-name"
              >
                FIRST NAME
              </label>
              <input
                type="text"
                class="form-control"
                id="bs-validation-name"
                placeholder="John"
                name="first_name"
                value={formData.first_name}
                onChange={handleChange}
                required
              />
              <div class="invalid-feedback">Please enter your first name.</div>
            </div>
            <div class="mb-2 col-xl-6">
              <label
                class="form-label d-flex justify-content-start"
                for="bs-validation-last-name"
              >
                LAST NAME
              </label>
              <input
                type="text"
                class="form-control"
                id="bs-validation-last-name"
                placeholder="Doe"
                name="last_name"
                value={formData.last_name}
                onChange={handleChange}
                required
              />
              <div class="invalid-feedback">Please enter your last name.</div>
            </div>
          </div>

          <div className="mb-2">
            <label
              className="form-label d-flex justify-content-start"
              htmlFor="bs-validation-name"
            >
              NIC
            </label>
            <input
              type="number"
              className="form-control mb-3"
              id="bs-validation-name"
              placeholder="XXXXXXXXXXXXXXV"
              value={formData.nic}
              name="nic"
              onChange={handleChange}
              required
            />
            <div className="invalid-feedback">Please enter your nic.</div>
          </div>

          <div className="mb-2">
            <label className="form-check-label mt-2 d-flex justify-content-start">
              Gender
            </label>
            <div className="col mt-2 d-flex justify-content-start">
              <div className="form-check form-check-inline">
                <input
                  type="radio"
                  id="bs-validation-radio-male"
                  name="gender"
                  value="MALE"
                  onChange={handleChange}
                  className="form-check-input"
                  required
                />
                <label
                  className="form-check-label"
                  htmlFor="bs-validation-radio-male"
                >
                  Male
                </label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  type="radio"
                  id="bs-validation-radio-female"
                  name="gender"
                  value="FEMALE"
                  onChange={handleChange}
                  className="form-check-input"
                  required
                />
                <label
                  className="form-check-label"
                  htmlFor="bs-validation-radio-female"
                >
                  Female
                </label>
              </div>
            </div>
          </div>
          <div className="mb-3">
            <label
              className="form-label d-flex justify-content-start mt-3"
              htmlFor="datepicker1 bs-validation-dob"
            >
              DOB
            </label>
            <input
              type="date"
              className="form-control flatpickr-validation flatpickr-input mb-2"
              placeholder="YYYY/MM/DD"
              value={formData.dob}
              onChange={handleChange}
              id="dob"
              name="dob"
              max={new Date().toISOString().split("T")[0]}
              require
            />
            <div className="invalid-feedback">Please Enter Your DOB</div>
          </div>
          <div className="mb-3">
            <label
              className="form-label d-flex justify-content-start"
              htmlFor="bs-validation-email"
            >
              Email
            </label>
            <input
              type="email"
              id="bs-validation-email"
              className="form-control"
              placeholder="john.doe@example.com"
              value={formData.email}
              name="email"
              onChange={handleChange}
              required
            />
            <div className="invalid-feedback">Please enter a valid email</div>
          </div>

          <div className="mb-2">
            <label
              className="form-label d-flex justify-content-start"
              htmlFor="bs-validation-name"
            >
              ADDRESS
            </label>
            <textarea
              type="text"
              className="form-control mb-3"
              id="bs-validation-name"
              value={formData.address}
              name="address"
              onChange={handleChange}
              placeholder="address here"
              required
            ></textarea>
            <div className="invalid-feedback">Please enter your address.</div>
          </div>
          <div className="mb-3">
            <label
              className="form-label d-flex justify-content-start"
              htmlFor="bs-validation-mobile"
            >
              MOBILE
            </label>
            <input
              type="number"
              id="bs-validation-mobile"
              className="form-control"
              placeholder="+1XXXXXXXXXX"
              value={formData.contact_number}
              name="contact_number"
              onChange={handleChange}
              required
            />
            <div className="invalid-feedback">Please enter a valid number</div>
          </div>

          <div class="mb-3">
            <label
              className="form-label d-flex justify-content-start"
              htmlFor="image-upload"
            >
              PROFILE PHOTO
            </label>
            <input
              type="file"
              id="image-upload"
              name="profile-image"
              accept="image/*"
              class="form-control p-2"
            />
            <div class="mt-4 mb-4">
              <img
                id="profile-image"
                src="#"
                alt="Preview"
                style={{ display: "none" }}
                class="w-20 h-48 rounded-md"
              />
            </div>
            <div class="invalid-feedback">Please upload a profile photo.</div>
          </div>
          <div class="row">
            <div class="col-12 d-flex justify-content-start">
              <button
                type="submit"
                class="btn btn-primary"
                id="position-bottom-end"
                onClick={handleSubmit}
              >
                Next
              </button>
              <button type="reset" class="btn btn-label-secondary ml-4">
                Cancel
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
};

export default BasicDetails;
