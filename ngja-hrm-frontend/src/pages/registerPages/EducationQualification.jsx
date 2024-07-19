import React, { useState } from 'react';
import AxiosInstance from "../../api/Axios";

const EducationQualification = () => {
  const [educationData, setEducationData] = useState([{
    university_name: "",
    qualification_type: "",
    start_date: "",
    end_date: ""
  }]);

  const handleChange = (index, e) => {
    const { name, value } = e.target;
    const newData = [...educationData];
    newData[index] = { ...newData[index], [name]: value };
    setEducationData(newData);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const config = {
      headers: {
        'X-API-VERSION': 'V1'
      }
    };

    try {
      await AxiosInstance.post("employees/3/qualifications", educationData, config);
      alert("Education details saved successfully!");
    } catch (error) {
      console.error("Error submitting form:", error);
      alert("Failed to submit the form. Please try again later.");
    }
  };

  const addEducationForm = () => {
    setEducationData([...educationData, {
      university_name: "",
      qualification_type: "",
      start_date: "",
      end_date: ""
    }]);
  };

  const removeEducationForm = index => {
    const newData = [...educationData];
    newData.splice(index, 1);
    setEducationData(newData);
  };

  return (
    <div className="container mt-5">
      <form onSubmit={handleSubmit} className="form-repeater">
        {educationData.map((data, index) => (
          <fieldset key={index} className="border p-4 mb-4">
            <legend className="float-none w-auto p-2">EDUCATION #{index + 1}</legend>
            <div className="form-group mb-3">
              <label htmlFor={`university_name_${index}`}>UNIVERSITY/INSTITUTE/COLLEGE NAME</label>
              <input
                id={`university_name_${index}`}
                type="text"
                className="form-control"
                name="university_name"
                value={data.university_name}
                onChange={e => handleChange(index, e)}
                placeholder="Enter University Name"
              />
            </div>
            <div className="form-group mb-3">
              <label htmlFor={`qualification_type_${index}`}>QUALIFICATION TYPE</label>
              <select
                id={`qualification_type_${index}`}
                className="form-select"
                name="qualification_type"
                value={data.qualification_type}
                onChange={e => handleChange(index, e)}
              >
                <option value="">Select the category</option>
                <option value="OL">Ordinary Level</option>
                <option value="AL">Advanced Level</option>
                <option value="HIGHER">Higher Education</option>
                <option value="OTHER">Other</option>
              </select>
            </div>
            <div className="form-row">
              <div className="col-md-6 mb-3">
                <label htmlFor={`start_date_${index}`}>STARTED DATE</label>
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
              <button type="button" className="btn btn-danger" onClick={() => removeEducationForm(index)}>
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
                onClick={addEducationForm}
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

export default EducationQualification;
