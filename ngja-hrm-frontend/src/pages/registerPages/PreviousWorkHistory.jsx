import React, { useState } from 'react';
import AxiosInstance from "../../api/Axios";

const PreviousWorkHistory = () => {
  const [previousWorkData, setPreviousWorkData] = useState([{
    company_name: "",
    designation: "",
    start_date: "",
    end_date: ""
  }]);

  const handleChange = (index, e) => {
    const { name, value } = e.target;
    const newData = [...previousWorkData];
    newData[index] = { ...newData[index], [name]: value };
    setPreviousWorkData(newData);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const config = {
      headers: {
        'X-API-VERSION': 'V1'
      }
    };

    try {
      await AxiosInstance.post("employees/3/previous-work-histories", previousWorkData, config);
      alert("Previous Work History details saved successfully!");
    } catch (error) {
      console.error("Error submitting form:", error);
      alert("Failed to submit the form. Please try again later.");
    }
  };

  const addPreviousWorkForm = () => {
    setPreviousWorkData([...previousWorkData, {
      company_name: "",
      designation: "",
      start_date: "",
      end_date: ""
    }]);
  };

  const removePreviousWorkForm = index => {
    const newData = [...previousWorkData];
    newData.splice(index, 1);
    setPreviousWorkData(newData);
  };

  return (
    <div className="container mt-5">
      <form onSubmit={handleSubmit} className="form-repeater">
        {previousWorkData.map((data, index) => (
          <fieldset key={index} className="border p-4 mb-4">
            <legend className="float-none w-auto p-2">PREVIOUS WORK #{index + 1}</legend>
            <div className="form-group mb-3">
              <label htmlFor={`company_name_${index}`}>COMPANY NAME</label>
              <input
                id={`company_name_${index}`}
                type="text"
                className="form-control"
                name="company_name"
                value={data.company_name}
                onChange={e => handleChange(index, e)}
                placeholder="Enter Company Name"
              />
            </div>
            <div className="form-group mb-3">
              <label htmlFor={`designation_${index}`}>DESIGNATION</label>
              <input
                id={`designation_${index}`}
                type="text"
                className="form-control"
                name="designation"
                value={data.designation}
                onChange={e => handleChange(index, e)}
                placeholder="Enter Designation"
              />
            </div>
            <div className="form-row">
              <div className="col-md-6 mb-3">
                <label htmlFor={`start_date_${index}`}>JOINED DATE</label>
                <input
                  id={`start_date_${index}`}
                  type="date"
                  className="form-control"
                  name="start_date"
                  value={data.start_date}
                  onChange={e => handleChange(index, e)}
                />
              </div>
              <div className="col-md-6 mb-3">
                <label htmlFor={`end_date_${index}`}>END DATE</label>
                <input
                  id={`end_date_${index}`}
                  type="date"
                  className="form-control"
                  name="end_date"
                  value={data.end_date}
                  onChange={e => handleChange(index, e)}
                />
              </div>
            </div>
            {index > 0 && (
              <button type="button" className="btn btn-danger" onClick={() => removePreviousWorkForm(index)}>
                Remove
              </button>
            )}
            <hr />
          </fieldset>
        ))}
        <div className="mb-0 mt-3">
          <div className="row">
            <div className="col-12 d-flex justify-content-between">
              <button type="submit" className="btn btn-primary" onClick={handleSubmit}>Next</button>
              <button
                className="btn btn-primary"
                type="button"
                onClick={addPreviousWorkForm}
              >
                <i className="bx bx-plus me-1" />
                <span className="align-middle" style={{ fontSize: "15px" }}>
                  Add More
                </span>
              </button>
            </div>
          </div>
        </div>
      </form>
    </div>
  );
};

export default PreviousWorkHistory;

