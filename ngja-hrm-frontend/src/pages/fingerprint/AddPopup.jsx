import React, { useEffect, useState } from "react";
import "./AddPopup.css";
import AxiosInstance from "../../api/Axios";

const AddPopup = ({ userId, handleClose }) => {
  console.log("inside popup", userId);

  const [fingerId, setFingerId] = useState({
    finger_print_id: "",
  });
  console.log(fingerId);
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFingerId((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async () => {
    try {
      const response = await AxiosInstance.post("fingerprint/user/" + userId, fingerId);
      console.log("Response:", response);
  
      alert("Fingerprint saved successfully!");
    } catch (error) {
      console.error("Error saving fingerprint:", error);
      alert(
        "An error occurred while saving Fingerprint Please try again later."
      );
    }
  };

  return (
    <div>
      <div className="fixed top-0 left-0 w-full h-full bg-black bg-opacity-50 flex justify-center items-center z-50">
        <div className="bg-white p-6 rounded-lg">
          <h2 className="text-lg font-bold mb-4 w-[500px]">Add Fingerprint</h2>
          <div className=" flex flex-col gap-4">
            <input
              onChange={handleChange}
              name="finger_print_id"
              type="text"
              className=" fingerprint-input"
            />
            <button onClick={handleSubmit} className="btn btn-primary">Add</button>
            <button onClick={handleClose} className="btn btn-primary">
              Clear
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddPopup;
