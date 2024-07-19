import React, { useState, useEffect } from 'react';
import AxiosInstance from "../api/Axios";

function DependentsDetails() {
  const [dependentList, setDependentList] = useState([]);
  const [error, setError] = useState('');

  useEffect(() => {
      const fetchDependents = async () => {
          const config = {
              headers: {
                  'version': 'v1'
              }
          };
          try {
              
              const response = await AxiosInstance.get(`employees/3/dependents`, config);
              setDependentList(response.data);
          } catch (error) {
              console.error('Error fetching dependents:', error);
              setError('Error fetching dependents details. Please try again later.');
          }
      };

      fetchDependents();
  }, []); 

  if (error) {
      return <div>Error: {error}</div>;
  }

  if (dependentList.length === 0) {
      return <div>Loading dependents details...</div>;
  }

  return (
    <div className="tab-pane fade" id="navs-top-dependentsDetails" role="tabpanel">
      {dependentList.map((dependents, index) => (
                <div key={index} className="card mb-3"> 
                    <div className="card-body">
                        <div className="row">
                            <div className="col-md-6">
                                <p className="card-text"><strong>Dependent Name:</strong> {dependents.dependentsName}</p>
                                <p className="card-text"><strong>Relationship:</strong> {dependents.relationship}</p>
                                <p className="card-text"><strong>DOB :</strong> {dependents.dob}</p>
                            </div>
                            <div className="col-md-6">
                                
                            </div>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
}

export default DependentsDetails;
