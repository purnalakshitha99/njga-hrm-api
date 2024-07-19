import React, { useState, useEffect } from 'react';
import AxiosInstance from "../api/Axios";

function WorkDetails() {
  const [currentWork, setCurrentWork] = useState(null);
  const [error, setError] = useState('');

  useEffect(() => {
      const fetchCurrentWork = async () => {
          try {
              const response = await AxiosInstance.get(`employees/3/current_work_details`);
              setCurrentWork(response.data);
          } catch (error) {
              console.error('Error fetching current work details:', error);
              setError('Error fetching current work details. Please try again later.');
          }
      };

      fetchCurrentWork();
  }, []); 

  if (error) {
      return <div>Error: {error}</div>;
  }

  if (!currentWork) {
      return <div>Loading current work details...</div>;
  }

  return (
    <div className="tab-pane fade show active" id="navs-top-workDetails" role="tabpanel">
        <div className="card mb-3"> 
            <div className="card-body">
                <div className="row">
                    <div className="col-md-6">
                        <p className="card-text"><strong>Employee Id:</strong> {currentWork.empCode}</p>
                        <p className="card-text"><strong>Branch Name:</strong> {currentWork.branchId}</p>
                        <p className="card-text"><strong>Department:</strong> {currentWork.depId}</p>
                        <p className="card-text"><strong>Designation:</strong> {currentWork.designation}</p>
                    </div>
                    <div className="col-md-6">
                        <p className="card-text"><strong>Starting Date/Joining Date:</strong> {currentWork.startDate}</p>
                        <p className="card-text"><strong>Employment Category:</strong> {currentWork.empCategoryId}</p>
                        <p className="card-text"><strong>Employment Type:</strong> {currentWork.empType}</p>
                        <p className="card-text"><strong>Work Telephone:</strong> {currentWork.workTelephone}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
  );
}

export default WorkDetails;
