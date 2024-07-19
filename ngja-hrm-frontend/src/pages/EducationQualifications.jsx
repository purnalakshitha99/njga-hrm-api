import React, { useState, useEffect } from 'react';
import AxiosInstance from "../api/Axios";

function EducationQualifications({ employeeId }) {
    const [educationList, setEducationList] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchEducation = async () => {
            const config = {
                headers: {
                    'X-API-VERSION': 'V1'
                }
            };
            try {
                
                const response = await AxiosInstance.get(`employees/3/qualifications`, config);
                setEducationList(response.data);
            } catch (error) {
                console.error('Error fetching education qualifications:', error);
                setError('Error fetching education qualifications. Please try again later.');
            }
        };

        fetchEducation();
    }, []); 

    if (error) {
        return <div>Error: {error}</div>;
    }

    if (educationList.length === 0) {
        return <div>Loading education qualifications...</div>;
    }

    return (
        <div className="tab-pane fade show active" id="navs-top-educationQualifications" role="tabpanel">
            {educationList.map((education, index) => (
                <div key={index} className="card mb-3"> 
                    <div className="card-body">
                        <div className="row">
                            <div className="col-md-6">
                                <h5 className="card-title">Education Details</h5>
                                <p className="card-text"><strong>University/Institute Name:</strong> {education.universityName}</p>
                                <p className="card-text"><strong>Qualification Type:</strong> {education.qualificationType}</p>
                            </div>
                            <div className="col-md-6">
                                <h5 className="card-title">Dates</h5>
                                <p className="card-text"><strong>Starting Date/Joining Date:</strong> {education.startDate}</p>
                                <p className="card-text"><strong>End Date:</strong> {education.endDate}</p>
                            </div>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
}

export default EducationQualifications;
