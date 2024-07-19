import React, { useState, useEffect } from "react";
import AxiosInstance from "../../api/Axios";

const CurrentWorkDetails = () => {
  const [employeeCategories, setEmployeeCategories] = useState([]);
  const [departments, setDepartments] = useState([]);
  const [branches, setBranches] = useState([]);

  const [formData, setFormData] = useState({
    designation: "",
    start_date: "",
    work_telephone: "",
    emp_code: "",
    branch_id: "",
    dep_id: "",
    emp_category_id: "",
  });

  useEffect(() => {
    fetchEmployeeCategories();
    fetchDepartments();
    fetchBranches();
  }, []);

  const fetchEmployeeCategories = async () => {
    try {
      const response = await AxiosInstance.get("employees_categories");
      setEmployeeCategories(response.data);
    } catch (error) {
      console.error("Error fetching employee categories:", error);
    }
  };

  const fetchBranches = async () => {
    try {
      const response = await AxiosInstance.get("branches");
      setBranches(response.data);
    } catch (error) {
      console.error("Error fetching branches:", error);
    }
  };

  const fetchDepartments = async () => {
    try {
      const response = await AxiosInstance.get("departments");
      setDepartments(response.data);
    } catch (error) {
      console.error("Error fetching departments:", error);
    }
  };

  const handleCategoryChange = (e) => {
    setFormData({ ...formData, emp_category_id: e.target.value });
  };

  const handleDepartmentChange = (e) => {
    setFormData({ ...formData, dep_id: e.target.value });
  };

  const handleBranchChange = (e) => {
    setFormData({ ...formData, branch_id: e.target.value });
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await AxiosInstance.post(
        "employees/8/current_work_details",
        formData
      );
      console.log("Form submitted successfully:", response.data);
      alert("Form submitted successfully");
      // Optionally, you can navigate to the next page or perform other actions upon successful form submission
    } catch (error) {
      console.error("Error submitting form:", error);
      // Handle error appropriately, such as displaying an error message to the user
    }
  };

  return (
    <div>
      <form
        className="needs-validation"
        noValidate=""
        id="bs-validation-form2"
        onSubmit={handleSubmit}
      >
        <div className="mb-3">
          <label
            className="form-label d-flex justify-content-start"
            htmlFor="bs-validation-name"
          >
            EMPLOYMENT NO
          </label>
          <input
            type="text"
            className="form-control"
            id="bs-validation-name"
            name="emp_code"
            placeholder="XXXXXXX"
            value={formData.emp_code}
            onChange={handleInputChange}
            required
          />
          <div className="invalid-feedback">Please enter your name.</div>
        </div>
        <div className="mb-3">
          <label
            className="form-label d-flex justify-content-start"
            htmlFor="basic-default-country"
          >
            BRANCH NAME
          </label>
          <select
            className="form-select"
            id="basic-default-country"
            name="branch_id"
            value={formData.branch_id}
            onChange={handleBranchChange}
            required
            fdprocessedid="9ypqh3"
          >
            <option value="">select the branch</option>
            {branches.map((branch) => (
              <option key={branch.id} value={branch.id}>
                {branch.name}
              </option>
            ))}
          </select>
        </div>
        <div className="mb-3">
          <label
            className="form-label d-flex justify-content-start mb-2"
            htmlFor="basic-default-country"
          >
            DEPARTMENT
          </label>
          <select
            className="form-select"
            id="basic-default-country"
            name="dep_id"
            value={formData.dep_id}
            onChange={handleDepartmentChange}
            required
            fdprocessedid="9ypqh3"
          >
            <option value="">select the department</option>
            {departments.map((department) => (
              <option key={department.id} value={department.id}>
                {department.name}
              </option>
            ))}
          </select>
        </div>
        <div className="mb-3">
          <label
            className="form-label d-flex justify-content-start mb-2"
            htmlFor="basic-default-country"
          >
            EMPLOYMENT CATEGORY
          </label>
          <select
            className="form-select"
            id="employee-category"
            name="emp_category_id"
            value={formData.emp_category_id}
            onChange={handleCategoryChange}
            required
          >
            <option value="">Select the category</option>
            {employeeCategories.map((category) => (
              <option key={category.id} value={category.id}>
                {category.empCategory} {category.empType}
              </option>
            ))}
          </select>
        </div>
        <div className="mb-3">
          <label
            className="form-label d-flex justify-content-start"
            htmlFor="basic-default-country"
          >
            DESIGNATION
          </label>
          <input
            type="text"
            className="form-control"
            id="designation"
            name="designation"
            placeholder="Type the designation"
            value={formData.designation}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="mb-3">
          <label
            className="form-label d-flex justify-content-start"
            htmlFor="bs-validation-dob"
          >
            STARTING DATE/JOINING DATE
          </label>
          <input
            type="date"
            className="form-control flatpickr-validation flatpickr-input"
            placeholder="YYYY/MM/DD"
            id="datepicker2"
            name="start_date"
            value={formData.start_date}
            onChange={handleInputChange}
            required
          />
          <div className="invalid-feedback"></div>
        </div>
        <div className="mb-3">
          <label
            className="form-label d-flex justify-content-start"
            htmlFor="bs-validation-mobile"
          >
            WORK TELEPHONE
          </label>
          <input
            type="number"
            id="bs-validation-mobile"
            className="form-control "
            placeholder="+94XXXXXXXXXX"
            aria-label="john.doe"
            name="work_telephone"
            value={formData.work_telephone}
            onChange={handleInputChange}
            required
          />
          <div className="invalid-feedback">Please enter a valid number</div>
        </div>
        <div className="row">
          <div className="col-12 d-flex justify-content-start">
            <button type="submit" className="btn btn-primary">
              Next
            </button>
            <button
              type="reset"
              className="btn btn-label-secondary ml-4"
              fdprocessedid="mo4gu"
            >
              Cancel
            </button>
          </div>
        </div>
      </form>
    </div>
  );
};

export default CurrentWorkDetails;
