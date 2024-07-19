import React, { useState } from 'react';
import AxiosInstance from "../../api/Axios";

const EmergencyContact = () => {
  const [emergencyContactData, setEmergencyContactData] = useState([{
    name: "",
    relationship: "",
    contact: "",
    // end_date: ""
  }]);

  const handleChange = (index, e) => {
    const { name, value } = e.target;
    const newData = [...emergencyContactData];
    newData[index] = { ...newData[index], [name]: value };
    setEmergencyContactData(newData);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const config = {
      headers: {
        'version': 'v1'
      }
    };

    try {
      await AxiosInstance.post("employees/3/emergency-contacts", emergencyContactData, config);
      alert("Emergency Contact details saved successfully!");
    } catch (error) {
      console.error("Error submitting form:", error);
      alert("Failed to submit the form. Please try again later.");
    }
  };


  const addEmergencyContactForm = () => {
    setEmergencyContactData([...emergencyContactData, {
      name: "",
      relationship: "",
      contact: "",
    }]);
  };

  const removeEmergencyContactForm = index => {
    const newData = [...emergencyContactData];
    newData.splice(index, 1);
    setEmergencyContactData(newData);
  };

  return (
    <div className="container mt-5">
      <form onSubmit={handleSubmit} className="form-repeater">
        {emergencyContactData.map((data, index) => (
          <fieldset key={index} className="border p-4 mb-4">
            <legend className="float-none w-auto p-2">Emergency Contact #{index + 1}</legend>
            <div className="form-group mb-3">
              <label htmlFor={`name${index}`}>NAME</label>
              <input
                id={`name${index}`}
                type="text"
                className="form-control"
                name="name"
                value={data.name}
                onChange={e => handleChange(index, e)}
                placeholder="John Doe"
              />
            </div>

            <div className="form-group mb-3">
              <label htmlFor={`relationship${index}`}>RELATIONSHIP</label>
              <input
                id={`relationship${index}`}
                type="text"
                className="form-control"
                name="relationship"
                value={data.relationship}
                onChange={e => handleChange(index, e)}
                placeholder="Relationship"
              />
            </div>

          
            <div className="mb-3">
              <label htmlFor={`contact${index}`}>Contact Number</label>
              <input
                type="number"
                id="contact"
                className="form-control"
                placeholder="+94XXXXXXXXXX"
                value={data.contact}
                name="contact"
                onChange={(e) => handleChange(index, e)}
                required
              />
            <div className="invalid-feedback">Please enter a valid number</div>
          </div>


            {index > 0 && (
              <button type="button" className="btn btn-danger" onClick={() => removeEmergencyContactForm(index)}>
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
                onClick={addEmergencyContactForm}
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

export default EmergencyContact;




