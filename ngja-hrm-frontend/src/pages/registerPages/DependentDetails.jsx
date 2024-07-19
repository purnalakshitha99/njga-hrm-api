import React, {useState} from 'react';
import AxiosInstance from "../../api/Axios";

const DependentDetails = () => {
    const [dependentDetail, setDependentDetail] = useState([{
        dependents_name: "",
        relationship: "",
        dob: ""
    }]);

    const handleChange = (index, e) => {
        const {name, value} = e.target;
        const newData = [...dependentDetail];
        newData[index] = {...newData[index], [name]: value};
        setDependentDetail(newData);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const config = {
            headers: {
                'X-API-VERSION': 'V1'
            }
        };

        try {
            await AxiosInstance.post("/employees/2/dependent", dependentDetail, config);
            alert("Dependent details saved successfully!");
        } catch (error) {
            console.error("Error submitting form:", error);
            alert("Failed to submit the dependent detail. Please try again later.");
        }
    };

    const addDependentForm = () => {
        setDependentDetail([...dependentDetail, {
            dependents_name: "",
            relationship: "",
            dob: ""
        }]);
    };

    const removeDependentForm = index => {
        const newData = [...dependentDetail];
        newData.splice(index, 1);
        setDependentDetail(newData);
    };

    return (
        <div>
            <form className="" id="bs-validation-form" onSubmit={handleSubmit}>
                {dependentDetail.map((data, index) => (

                    <div className="mb-3" data-repeater-list="group-a">
                        <div className="mb-3" data-repeater-item>
                            <label className="form-label d-flex justify-content-start">DEPENDENT NAME</label>
                            <input
                                id={`dependents_name_${index}`}
                                className="form-control mb-4"
                                placeholder="John Doe"
                                name="dependents_name"
                                value={data.dependents_name}
                                required
                                onChange={(e) => handleChange(index, e)}
                            />
                            <div className="invalid-feedback"/>
                            <label className="form-label d-flex justify-content-start">RELATIONSHIP</label>
                            <input
                                id={`relationship_${index}`}
                                type="text"
                                className="form-control"
                                placeholder="Relationship"
                                name="relationship"
                                value={data.relationship}
                                required
                                onChange={(e) => handleChange(index, e)}
                            />
                            <div className="invalid-feedback"/>

                          <label className="form-label d-flex justify-content-start pt-4">DATE OF BIRTH</label>
                          <input
                              id={`dob_${index}`}
                              className="form-control mb-4"
                              placeholder="Date of birth"
                              type="date"
                              name="dob"
                              value={data.dob}
                              required
                              onChange={(e) => handleChange(index, e)}
                          />

                          <div className="invalid-feedback"/>

                            <div className="col-lg-12 col-12 d-flex justify-content-end align-items-center mb-5 mt-4">
                                <button
                                    type="button"
                                    className="btn btn-label-danger w-15"
                                    // data-repeater-delete
                                    id="confirm-color"
                                >
                                    <i className="bx bx-plus me-1"/>
                                    <span className="align-middle" style={{fontSize: "15px"}}
                                          onClick={(removeDependentForm)}>Remove</span>
                                </button>
                            </div>
                            <hr/>
                        </div>
                    </div>
                ))}
                <div className="mb-0 mt-3">
                    <div className="">
                        <div className="col-12 d-flex justify-content-between">
                            <div>
                                <button type="submit" className="btn btn-primary" onClick={handleSubmit}>Next</button>
                            </div>
                            <div className="" style={{marginLeft: "auto"}}>
                                <button className="btn btn-primary" type="button" id="addRepeater2">
                                    <i className="bx bx-plus me-1"/>
                                    <span className="align-middle" style={{fontSize: "15px"}}
                                          onClick={addDependentForm}>Add More</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    );
};

export default DependentDetails;
