import React, { useEffect, useState } from "react";
import NoticeHistory from "./NoticeHistory";
import AxiosInstance from "../api/Axios";

function Notice() {
  const [test, setTest] = useState("");

  useEffect(() => {
    const fetchData = async () => {
      const response = await AxiosInstance.get("test");
      console.log(response);
    };
    fetchData();
  }, []);

  const [formData, setFormData] = useState({
    category: "",
    intern: false,
    contractBasis: false,
    permanent: false,
    title: "",
    description: "",
  });

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
  
    if (type === "checkbox") {
      // If the checkbox being clicked is already checked, do nothing
      if (checked && formData[name]) return;
  
      // If the checkbox being clicked is not checked, update the state
      setFormData((prevData) => ({
        ...prevData,
        intern: name === 'intern' && checked,
        contractBasis: name === 'contractBasis' && checked,
        permanent: name === 'permanent' && checked
      }));
    } else {
      // Handle other input types (e.g., select)
      setFormData((prevData) => ({
        ...prevData,
        [name]: value
      }));
    }
    console.log(value)
  };
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await AxiosInstance.post("notice", formData);
      alert("Notice saved successfully!");
      // Optionally, you can clear the form data after successful submission
      setFormData({
        category: "",
        intern: false,
        contractBasis: false,
        permanent: false,
        title: "",
        description: "",
      });
      console.log(formData)
    } catch (error) {
      console.error("Error saving notice:", error);
      alert("An error occurred while saving notice. Please try again later.");
    }

  };
  
  return (
    <>
      <div className="container-xxl flex-grow-1">
        <h4 className="py-3 mb-4">Notice</h4>
        {/*              Content*/}
        <div className="row" onSubmit={handleSubmit}>
          <div className=" w-100">
            <div className="nav-align-top mb-4 ">
              <ul className="nav nav-tabs  " role="tablist">
                <li className="nav-item">
                  <button
                    type="button"
                    className="nav-link active"
                    role="tab"
                    data-bs-toggle="tab"
                    data-bs-target="#navs-top-home"
                    aria-controls="navs-top-home"
                    aria-selected="true"
                  >
                    Create Notice
                  </button>
                </li>
                <li className="nav-item">
                  <button
                    type="button"
                    className="nav-link"
                    role="tab"
                    data-bs-toggle="tab"
                    data-bs-target="#navs-top-profile"
                    aria-controls="navs-top-profile"
                    aria-selected="false"
                  >
                    History
                  </button>
                </li>
              </ul>
              <div className="tab-content col-sm">
                <div
                  className="tab-pane fade show active"
                  id="navs-top-home"
                  role="tabpanel"
                >
                  <div className="container tab-content">
                    <div className="row">
                      <div className="col-sm">
                        <div className="mb-3 w-100 ">
                          <label htmlFor="defaultSelect" className="form-label">
                            Select Category
                          </label>
                          <select
                            id="defaultSelect"
                            className="form-select"
                            name="category"
                            value={formData.category}
                            onChange={handleChange}
                          >
                            <option value=""></option>
                            <option >All</option>
                            <option value={formData.standard}>Standard</option>
                            <option value="PL">PL</option>
                          </select>
                        </div>
                        <div className="d-flex justify-content-between w-100 mb-5">
                          <div className="form-check mt-3">
                            <input
                              className="form-check-input"
                              type="checkbox"
                              id="defaultCheck1"
                              name="intern"
                              checked={formData.intern}
                              onChange={handleChange}
                            />
                            <label
                              className="form-check-label"
                              htmlFor="defaultCheck1"
                            >
                              {" "}
                              Intern{" "}
                            </label>
                          </div>
                          <div className="form-check mt-3">
                            <input
                              className="form-check-input"
                              type="checkbox"
                              id="defaultCheck2"
                              name="contractBasis"
                              checked={formData.contractBasis}
                              onChange={handleChange}
                            />
                            <label
                              className="form-check-label"
                              htmlFor="defaultCheck1"
                            >
                              {" "}
                              Contract Basis{" "}
                            </label>
                          </div>
                          <div className="form-check mt-3">
                            <input
                              className="form-check-input"
                              type="checkbox"
                              id="defaultCheck3"
                              name="permanent"
                              checked={formData.permanent}
                              onChange={handleChange}
                            />
                            <label
                              className="form-check-label"
                              htmlFor="defaultCheck1"
                            >
                              {" "}
                              Permenent{" "}
                            </label>
                          </div>
                        </div>
                        <div className="w-100 mb-5">
                          <label
                            htmlFor="defaultFormControlInput"
                            className="form-label"
                          >
                            Title
                          </label>
                          <input
                            type="text"
                            className="form-control"
                            id="defaultFormControlInput"
                            name="title"
                            value={formData.title}
                            onChange={handleChange}
                          />
                        </div>
                        <div className="mb-5 w-100">
                          <label htmlFor="formFile" className="form-label">
                            Choose a file
                          </label>
                          <input
                            className="form-control"
                            type="file"
                            id="formFile"
                          />
                        </div>
                      </div>
                      <div className="col-sm">
                        <label
                          htmlFor="exampleFormControlTextarea1"
                          className="form-label"
                        >
                          Description
                        </label>
                        <textarea
                          className="form-control"
                          id="exampleFormControlTextarea1"
                          rows={8}
                          name="description"
                          value={formData.description}
                          onChange={handleChange}
                        />
                        <p>
                          *It is a long established fact that a reader will be
                          distracted by the readable content of a page when
                          looking at its layout. The point of using Lorem Ipsum
                          is that it has a more-or-less normal distribution of
                          letters
                        </p>
                        <div className="row mt-5 gap-5 d-flex justify-content-end ">
                          <button
                            type="button"
                            className="btn btn-primary col-4"
                          >
                            Post
                          </button>
                          <button
                            type="button"
                            className=" col-4 btn btn-danger "
                          >
                            Cancel
                          </button>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                <NoticeHistory />
              </div>
            </div>
          </div>
          {/*              Content*/}
        </div>
      </div>
    </>
  );
}

export default Notice;
