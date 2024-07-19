import React, { useState } from "react";
import AxiosInstance from "../../api/Axios";

const AttandancePopup = ({handleClose}) => {

    const [attandance, setAttandance] = useState({
        finger_print_id : ""
    })

    const handleChange = (e) => {
        const { name, value } = e.target;
        setAttandance((prevData) => ({
          ...prevData,
          [name]: value,
        }));
      };
    

    const handleSubmit = async () => {
        try {
            const response = await AxiosInstance.post("attendance", attandance, {
                headers: {
                    'VERSION': 'V1'
                }
            });
          console.log("Response:", response);
          alert(response.data);
          setAttandance(false)
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
          <h2 className="text-lg font-bold mb-4 w-[500px]">Mark Attandance</h2>
          <div className=" flex flex-col gap-4">
            <input
              onChange={handleChange}
              name="finger_print_id"
              type="text"
              className=" fingerprint-input"
            />
            <button
              onClick={handleSubmit}
              className="btn btn-primary"
            >
              Mark
            </button>
            <button onClick={handleClose} className="btn btn-primary">
              Cancel
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AttandancePopup;
