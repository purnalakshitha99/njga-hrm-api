import React, { useState, useEffect } from 'react';
import AxiosInstance from "../api/Axios";

function PreviousWorkHistory() {
  const [previousWorkHistory, setPreviousWorkHistory] = useState([]);
  const [error, setError] = useState('');

  useEffect(() => {
      const fetchPreviousWorkHistory = async () => {
          const config = {
              headers: {
                  'version': 'v1'
              }
          };
          try {
              
              const response = await AxiosInstance.get(`employees/3/previousWorkHistories`, config);
              setPreviousWorkHistory(response.data);
          } catch (error) {
              console.error('Error fetching  previous workHistories:', error);
              setError('Error fetching previous workHistories. Please try again later.');
          }
      };

      fetchPreviousWorkHistory();
  }, []); 

  if (error) {
      return <div>Error: {error}</div>;
  }

  if (previousWorkHistory.length === 0) {
      return <div>Loading previous workHistories...</div>;
  }
  return (
    <div className="tab-pane fade" id="navs-top-previousWorkHistory" role="tabpanel">
        {previousWorkHistory.map((workHistories, index) => (
                <div key={index} className="card mb-3"> 
                    <div className="card-body">
                        <div className="row">
                            <div className="col-md-6">
                                <p className="card-text"><strong>Company Name:</strong> {workHistories.companyName}</p>
                                <p className="card-text"><strong>Designation:</strong> {workHistories.designation}</p>
                            </div>
                            <div className="col-md-6">
                                <p className="card-text"><strong>Starting Date/Joining Date:</strong> {workHistories.startDate}</p>
                                <p className="card-text"><strong>End Date:</strong> {workHistories.endDate}</p>
                            </div>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
}

export default PreviousWorkHistory;
